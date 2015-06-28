package com.j2ee.java.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.j2ee.java.model.bo.CustomerBO;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.StaffBO;
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockInventoryBO;
import com.j2ee.java.model.bo.StockOutwardBO;
import com.j2ee.java.model.bo.StockOutwardDetailBO;
import com.j2ee.java.model.bo.Utils;
import com.j2ee.java.model.dto.Customer;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.Staff;
import com.j2ee.java.model.dto.Stock;
import com.j2ee.java.model.dto.StockInventory;
import com.j2ee.java.model.dto.StockOutward;
import com.j2ee.java.model.dto.StockOutwardDetail;

@Controller
public class StockOutwardController {

	@Autowired
	@Qualifier("StockInventoryBOImpl")
	private StockInventoryBO sInventoryBO;

	@Autowired
	@Qualifier("StockBOImpl")
	private StockBO stockBO;

	@Autowired
	@Qualifier("CustomerBOImpl")
	private CustomerBO customerBO;

	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;

	@Autowired
	@Qualifier("StockOutwardBOImpl")
	private StockOutwardBO sOutwardBO;

	@Autowired
	@Qualifier("StockInventoryBOImpl")
	private StockInventoryBO stockInventoryBO;

	@Autowired
	@Qualifier("StaffBOImpl")
	private StaffBO staffBO;

	@Autowired
	@Qualifier("StockOutwardDetailBOImpl")
	private StockOutwardDetailBO stockOutDetailBO;

	// return page of function StockInward
	@RequestMapping(value = "/StockOutward")
	public String stockInward(Model model) {

		List<Stock> listStock = stockBO.getAllStock();
		model.addAttribute("listStock", listStock);

		List<Customer> listCustomer = customerBO.getAllCustomer();
		model.addAttribute("listCustomer", listCustomer);

		// get current max StockInward ID.
		int maxStockOut = sOutwardBO.getMaxStockOutID();
		model.addAttribute("maxStockOut", (maxStockOut + 1));

		return "StockOutward";
	}

	// save data
	@RequestMapping(value = "/saveStockOutward", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public @ResponseBody String saveStockInward(HttpServletRequest request)
			throws ParseException {

		String response = "";
		try {
			// get stock inward
			String stockOutward = request.getParameter("0");
			JsonObject stockOutwardObj = new Gson().fromJson(stockOutward,
					JsonObject.class);

			// Save value into database

			StockOutward stockOut = new StockOutward();

			// Get customerID
			Customer customer = new Customer();
			customer.setCustomerID(stockOutwardObj.get("customerID").getAsInt());

			// Get StaffID
			Staff staff = new Staff();
			staff = staffBO.getByID(stockOutwardObj.get("staffID").getAsInt());

			String dateFormat = stockOutwardObj.get("date").getAsString();
			Date date = Utils.DATE_FORMATTER.parse(dateFormat);

			String reason = stockOutwardObj.get("reason").getAsString();
			String note = stockOutwardObj.get("note").getAsString();
			BigDecimal totalAmount = new BigDecimal(stockOutwardObj.get(
					"totalMoney").getAsFloat());
			int totalNumber = stockOutwardObj.get("totalNumber").getAsInt();

			/* check if component of product is not enough quantity */
			String stockOutwardDetail = request.getParameter("1");
			JsonArray stockOutwardDetailObj = (JsonArray) new Gson().fromJson(
					stockOutwardDetail, JsonArray.class);

			Iterator<JsonElement> it = stockOutwardDetailObj.iterator();
			List<JsonObject> listStockOutwardDetail = new ArrayList<JsonObject>();
			while (it.hasNext()) {
				JsonObject item = it.next().getAsJsonObject();
				if (!item.toString().equals("{}")) {
					listStockOutwardDetail.add(item);
				}
			}
			for (JsonObject jsonObject : listStockOutwardDetail) {
				Product productID = new Product();
				productID = productBO.getByID(jsonObject.get("productID")
						.getAsInt());

				Stock stockID = new Stock();
				stockID.setStockID(jsonObject.get("stockID").getAsInt());

				StockInventory sInvenCheck = new StockInventory();
				sInvenCheck.setProductID(productID);
				sInvenCheck.setStockID(stockID);
				int currentQuantity = sInventoryBO.getCurrentQuantity(sInvenCheck);

				int quantityOfProduct = jsonObject.get("quantity").getAsInt();

				if ((currentQuantity - quantityOfProduct) < productID.getMinStock()) {
					response = "{\"ID\": \"2\",\"MGS\": \"Can not Shipment this product, Please check item "
							+ productID.getProductName() + "\"}";
					return response;
				}
			}

			// set value for StockInward
			stockOut.setCustomerID(customer);
			stockOut.setStaffID(staff);
			stockOut.setDate(date);
			stockOut.setReason(reason);
			stockOut.setNote(note);
			stockOut.setTotalAmount(totalAmount);
			stockOut.setTotalQuantity(totalNumber);

			// save to database
			sOutwardBO.insertStockOutward(stockOut);

			// get StockOutwardDetail and save to database

			for (JsonObject jsonObject : listStockOutwardDetail) {
				// Save to StockOutwardDetail
				StockOutwardDetail sOutDetail = new StockOutwardDetail();

				sOutDetail.setOutwardID(stockOut);
				Product product = new Product();
				product = productBO.getByID(jsonObject.get("productID").getAsInt());
				sOutDetail.setProductID(product);

				Stock stock = new Stock();
				stock = stockBO.getByID(jsonObject.get("stockID").getAsInt());
				sOutDetail.setStockID(stock);
				// get Price and Amount
				sOutDetail.setNumber(jsonObject.get("quantity").getAsInt());
				sOutDetail.setPrice(product.getOrgPrice());
				BigDecimal amount = BigDecimal.ZERO;
				amount = product.getOrgPrice().multiply(
						new BigDecimal(sOutDetail.getNumber()));
				sOutDetail.setAmount(amount);
				stockOutDetailBO.insertStockOutwardDetail(sOutDetail);

				// Save to StockInventory
				StockInventory sInventory = new StockInventory();
				sInventory.setDate(date);
				sInventory.setProductID(product);
				sInventory.setStockID(stock);
				sInventory.setQuantity(-(jsonObject.get("quantity").getAsInt()));
				sInventory.setPrice(product.getOrgPrice());
				sInventory.setAmount(amount);
				stockInventoryBO.insertStockInventory(sInventory);
			}
			response = "{\"ID\": \"1\"}";
			return response;
		} catch (Exception e) {
			response = "{\"ID\": \"2\",\"MGS\": \"Insert failed. Please try again.\"}";
			return response;
		}
	}
}
