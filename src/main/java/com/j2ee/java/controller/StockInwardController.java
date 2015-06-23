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
import com.google.gson.reflect.TypeToken;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.ProviderBO;
import com.j2ee.java.model.bo.StaffBOImpl;
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockInventoryBOImpl;
import com.j2ee.java.model.bo.StockInwardBO;
import com.j2ee.java.model.bo.StockInwardBOImpl;
import com.j2ee.java.model.bo.StockInwardDetailBOImpl;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.Provider;
import com.j2ee.java.model.dto.Staff;
import com.j2ee.java.model.dto.Stock;
import com.j2ee.java.model.dto.StockInventory;
import com.j2ee.java.model.dto.StockInward;
import com.j2ee.java.model.dto.StockInwardDetail;

@Controller
public class StockInwardController {
	
	@Autowired
	@Qualifier("StockBOImpl")
	private StockBO stockBO;
	
	@Autowired
	@Qualifier("ProviderBOImpl")
	private ProviderBO providerBO;
	
	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;
	
	@Autowired
	@Qualifier("StockInwardBOImpl")
	private StockInwardBO stockInwardBO;
	
	@Autowired
	@Qualifier("StockInventoryBOImpl")
	private StockInventoryBOImpl stockInventoryBO;
	
	@Autowired
	@Qualifier("StaffBOImpl")
	private StaffBOImpl staffBO;
	
	@Autowired
	@Qualifier("StockInwardBOImpl")
	private StockInwardBOImpl stockInBOImpl;
	
	@Autowired
	@Qualifier("StockInwardDetailBOImpl")
	private StockInwardDetailBOImpl stockInDetailBO;
	
	private static final Logger logger = LoggerFactory
			.getLogger(StockInwardController.class);

	private static final SimpleDateFormat formatterWeb = new SimpleDateFormat(
			"MM/dd/yyyy");
	private static final SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy-MM-dd");

	// return page of function StockInward
	@RequestMapping(value = "/StockInward")
	public String stockInward(Model model) {
		
		List<Stock> listStock = stockBO.getAllStock();
		model.addAttribute("listStock", listStock);

		List<Provider> listProvider = providerBO.getAllProvider();
		model.addAttribute("listProvider", listProvider);
		
		// get current max StockInward ID.
		int maxStockIn = stockInwardBO.getMaxStockInID();
		model.addAttribute("maxStockIn", (maxStockIn + 1));
		
		
		// TODO demo for get inventory
//		List<Object[]> listTe = stockInventoryBO.getAllStockInventory();
//		
//		Iterator<Object[]> itr = listTe.iterator();
//		while(itr.hasNext()){
//		   Object[] obj = (Object[]) itr.next();
//		   
//		   String proID = String.valueOf(obj[0]); 
//		   String stocID = String.valueOf(obj[1]);
//		   long totalQ = Long.valueOf(obj[2].toString());
//		}
		
		return "StockInward";
	}

	// get list of Provider
	@RequestMapping(value = "/getProvider", method = RequestMethod.GET)
	public @ResponseBody String getProvide() {
		Gson gson = new Gson();
		
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
		Gson gson = new Gson();
		String data = "";
		
		List<Product> product = productBO.getAllProduct();
		
		Type type = new TypeToken<List<Product>>() {
		}.getType();
		
		String jsonS = gson.toJson(product, type);
		
		logger.info(jsonS);
		
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

		String response = "";
		
		// get stock inward
		String stockInward = request.getParameter("0");
		JsonObject stockInwardObj = new Gson().fromJson(stockInward,
				JsonObject.class);

		// Save value into database

		StockInward stockIn = new StockInward();

		// Get StaffID
		Staff staff = new Staff();
		staff = staffBO.getByID(stockInwardObj.get("staffID").getAsInt());

		String dateFormat = stockInwardObj.get("date").getAsString();
		Date date = formatterWeb.parse(dateFormat);

		String reason = stockInwardObj.get("reason").getAsString();
		String note = stockInwardObj.get("note").getAsString();
		BigDecimal totalAmount = new BigDecimal(stockInwardObj
				.get("totalMoney").getAsFloat());
		int totalNumber = stockInwardObj.get("totalNumber").getAsInt();

		// set value for StockInward
		stockIn.setStaffID(staff);
		stockIn.setDate(formatter.parse(formatter.format(date)));
		stockIn.setReason(reason);
		stockIn.setNote(note);
		stockIn.setTotalAmount(totalAmount);
		stockIn.setTotalNumber(totalNumber);

		// save to database
		stockInwardBO.insertStockInward(stockIn);

		String stockInwardDetail = request.getParameter("1");
		JsonArray stockInwardDetailObj = (JsonArray) new Gson().fromJson(
				stockInwardDetail, JsonArray.class);
		
		Iterator<JsonElement> it = stockInwardDetailObj.iterator();
		List<JsonObject> listStockInwardDetail = new ArrayList<JsonObject>();
		while (it.hasNext()) {
			JsonObject item = it.next().getAsJsonObject();
			if (!item.toString().equals("{}")) {
				listStockInwardDetail.add(item);
			}
		}

		// get StockInwardDetail and save to database

		for (JsonObject jsonObject : listStockInwardDetail) {
			// Save to StockInwarDetail
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
			
			// Save to StockInventory
			StockInventory sInventory = new StockInventory();
			sInventory.setDate(formatter.parse(formatter.format(date)));
			sInventory.setProductID(product);
			sInventory.setStockID(stock);
			sInventory.setQuantity(jsonObject.get("quantity").getAsInt());
			sInventory.setPrice(product.getOrgPrice());
			sInventory.setAmount(amount);
			stockInventoryBO.insertStockInventory(sInventory);
		}
		response = "{\"ID\": \"1\"}";
		return response;
	}
}
