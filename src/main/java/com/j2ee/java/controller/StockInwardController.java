package com.j2ee.java.controller;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.ProductBOImpl;
import com.j2ee.java.model.bo.ProviderBO;
import com.j2ee.java.model.bo.ProviderBOImpl;
import com.j2ee.java.model.bo.StaffBO;
import com.j2ee.java.model.bo.StaffBOImpl;
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockBOImpl;
import com.j2ee.java.model.bo.StockInwardBO;
import com.j2ee.java.model.bo.StockInwardBOImpl;
import com.j2ee.java.model.bo.StockInwardDetailBO;
import com.j2ee.java.model.bo.StockInwardDetailBOImpl;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.Provider;
import com.j2ee.java.model.dto.Staff;
import com.j2ee.java.model.dto.Stock;
import com.j2ee.java.model.dto.StockInward;
import com.j2ee.java.model.dto.StockInwardDetail;

@Controller
public class StockInwardController {

	private static final Logger logger = LoggerFactory
			.getLogger(StockInwardController.class);

	private static final SimpleDateFormat formatterWeb = new SimpleDateFormat(
			"YYYY/MM/DD");
	private static final SimpleDateFormat formatter = new SimpleDateFormat(
			"YYYY-MM-DD");

	// return page of function StockInward
	@RequestMapping(value = "/StockInward")
	public String stockInward(Model model) {
		
		StockBO stockBO = new StockBOImpl();
		List<Stock> listStock = stockBO.getAllStock();
		model.addAttribute("listStock", listStock);

		ProviderBO providerBO = new ProviderBOImpl();
		List<Provider> listProvider = providerBO.getAllProvider();
		model.addAttribute("listProvider", listProvider);
		
		return "StockInward";
	}

	// get list of Provider
	@RequestMapping(value = "/getProvider", method = RequestMethod.GET)
	public @ResponseBody String getProvide() {
		Gson gson = new Gson();

		ProviderBO providerBO = new ProviderBOImpl();
		Provider listProvider = providerBO.getByID(1);

		Type type = new TypeToken<Provider>() {
		}.getType();

		String jsonS = gson.toJson(listProvider, type);
		logger.info(jsonS);
		return jsonS;
	}

	// get list of Product
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public @ResponseBody String getProduct() {
		String data = "";
		ProductBO productBO = new ProductBOImpl();
		List<Product> product = productBO.getAllProduct();

		data += "[";
		for (int i = 0; i < product.size(); i++) {
			data += "\"";
			data += product.get(i).getProductID() + "|"
					+ product.get(i).getProductName() + "|"
					+ product.get(i).getUnitID().getUnitName() + "|"
					+ product.get(i).getSalePrice() + "|"
					+ product.get(i).getDescription();
			data += "\"";
			if (i < product.size() - 1) {
				data += ",";
			}
		}
		data += "]";

		return data;
	}

	// save data
	@RequestMapping(value = "/saveStockInward", method = RequestMethod.POST, 
			produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public @ResponseBody String saveStockInward(HttpServletRequest request)
			throws ParseException {

		// StockInward BO
		StockInwardBO stockInwardBO = new StockInwardBOImpl();
		StockInwardDetailBO stockInDetailBO = new StockInwardDetailBOImpl();

		ProviderBO providerBO = new ProviderBOImpl();
		StaffBO staffBO = new StaffBOImpl();
		ProductBO productBO = new ProductBOImpl();
		StockBO stockBO = new StockBOImpl();

		// get stock inward
		String stockInward = request.getParameter("0");
		JsonObject stockInwardObj = new Gson().fromJson(stockInward,
				JsonObject.class);

		// Save value into database

		StockInward stockIn = new StockInward();

		// Get Provider Object
		Provider provider = new Provider();
		provider = providerBO.getByID(stockInwardObj.get("providerID")
				.getAsInt());

		// Get StaffID
		Staff staff = new Staff();
		staff = staffBO.getByID(stockInwardObj.get("staffID").getAsInt());

		String dateFormat = stockInwardObj.get("date").getAsString();
		logger.info("dateFormat " + dateFormat);

		Date date = formatterWeb.parse(dateFormat);

		String reason = stockInwardObj.get("reason").getAsString();
		BigDecimal totalAmount = new BigDecimal(stockInwardObj
				.get("totalMoney").getAsFloat());
		int totalNumber = stockInwardObj.get("totalNumber").getAsInt();

		// set value for StockInward
		stockIn.setProviderID(provider);
		stockIn.setStaffID(staff);
		stockIn.setDate(formatter.parse(formatter.format(date)));
		stockIn.setReason(reason);
		stockIn.setTotalAmount(totalAmount);
		stockIn.setTotalNumber(totalNumber);

		// save to database
		stockInwardBO.insertStockInward(stockIn);

		String stockInwardDetail = request.getParameter("1");
		JsonArray stockInwardDetailObj = (JsonArray) new Gson().fromJson(
				stockInwardDetail, JsonArray.class);
		Iterator<JsonElement> it = stockInwardDetailObj.iterator();
		List<JsonObject> list = new ArrayList<JsonObject>();
		while (it.hasNext()) {
			JsonObject cat = it.next().getAsJsonObject();
			if (!cat.toString().equals("{}")) {
				list.add(cat);
			}
		}

		// get StockInwardDetail and save to database

		for (JsonObject jsonObject : list) {
			StockInwardDetail stockInDetail = new StockInwardDetail();

			stockInDetail.setInwardID(stockIn);

			Product product = new Product();
			product = productBO.getByID(jsonObject.get("productID").getAsInt());
			stockInDetail.setProductID(product);

			Stock stock = new Stock();
			stock = stockBO.getByID(jsonObject.get("stockID").getAsInt());
			stockInDetail.setStockID(stock);
			// get Price and Amount

			stockInDetail.setNumber(jsonObject.get("quantity").getAsInt());
			stockInDetail.setPrice(product.getOrgPrice());
			BigDecimal amount = BigDecimal.ZERO;
			amount = product.getOrgPrice().multiply(
					new BigDecimal(stockInDetail.getNumber()));
			stockInDetail.setAmount(amount);

			stockInDetailBO.insertStockInwardDetail(stockInDetail);
		}

		return null;
	}
}
