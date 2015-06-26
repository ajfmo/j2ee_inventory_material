package com.j2ee.java.controller;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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
import com.j2ee.java.model.bo.ProductComponentBO;
import com.j2ee.java.model.bo.StaffBO;
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockBuildBO;
import com.j2ee.java.model.bo.StockBuildDetailBO;
import com.j2ee.java.model.bo.StockInventoryBO;
import com.j2ee.java.model.bo.Utils;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.ProductComponent;
import com.j2ee.java.model.dto.Staff;
import com.j2ee.java.model.dto.Stock;
import com.j2ee.java.model.dto.StockBuild;
import com.j2ee.java.model.dto.StockBuildDetail;
import com.j2ee.java.model.dto.StockInventory;

@Controller
public class ProductBuildController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductBuildController.class);
	
	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;
	
	@Autowired
	@Qualifier("ProductComponentBOImpl")
	private ProductComponentBO proCompoBO;
	
	@Autowired
	@Qualifier("StaffBOImpl")
	private StaffBO staffBO;
	
	@Autowired
	@Qualifier("StockBuildBOImpl")
	private StockBuildBO sBuildBO;
	
	@Autowired
	@Qualifier("StockBuildDetailBOImpl")
	private StockBuildDetailBO sBuildDetailBO;
	
	@Autowired
	@Qualifier("StockBOImpl")
	private StockBO stockBO;
	
	@Autowired
	@Qualifier("StockInventoryBOImpl")
	private StockInventoryBO sInventoryBO;
	
	@Autowired
	private Utils utils;
	
	// build product
	@RequestMapping(value = "/build", method = RequestMethod.GET)
	public String build(Locale locale, Model model) {
		
		List<Product> listProduct = productBO.getAllProduct();
		model.addAttribute("listProduct", listProduct);
		
		List<Stock> listStock = stockBO.getAllStock();
		model.addAttribute("listStock", listStock);
		
		return "ProductBuild";
	}
	
	@RequestMapping(value = "/getProductComponent", method = RequestMethod.POST)
	public final @ResponseBody String getProductComponent(HttpServletRequest request) {
		logger.info("Get Product information");
		Gson gson = new Gson();
		
		String productID = request.getParameter("productID");

		List<ProductComponent> listProductComponent = proCompoBO.getByID(Integer.valueOf(productID));

		Type type = new TypeToken<List<ProductComponent>>() {
		}.getType();

		String jsonListProCompoBO = gson.toJson(listProductComponent, type);
		
		return jsonListProCompoBO;
	}
	
	//saveStockBuild
	@RequestMapping(value = "/saveStockBuild", method = RequestMethod.POST,
			produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public @ResponseBody String saveStockBuild(HttpServletRequest request) throws ParseException {
		
		String response = "";
		
		try {
			// get stock inward
			String stockBuild = request.getParameter("0");
			JsonObject stockBuildObj = new Gson().fromJson(stockBuild,
					JsonObject.class);

			// Save value into database

			StockBuild sBuild = new StockBuild();

			// product
			Product product = new Product();
			product = productBO.getByID(stockBuildObj.get("productID").getAsInt());
			
			// Get StaffID
			Staff staff = new Staff();
			staff.setStaffID(stockBuildObj.get("staffID").getAsInt());
			Stock stockID = new Stock();
			stockID = stockBO.getByID(stockBuildObj.get("stockID").getAsInt());
			String dateFormat = stockBuildObj.get("buildDate").getAsString();
			Date date = Utils.DATE_FORMATTER_WEB.parse(dateFormat);
			String note = stockBuildObj.get("note").getAsString();
			BigDecimal totalAmount = new BigDecimal(stockBuildObj
					.get("totalAmount").getAsFloat());
			int totalQuantity = stockBuildObj.get("totalQuantity").getAsInt();

			/* check if component of product is not enough quantity */
			String proBuildDetail = request.getParameter("1");
			JsonArray proBuildDetailObj = (JsonArray) new Gson().fromJson(
					proBuildDetail, JsonArray.class);
			
			Iterator<JsonElement> it = proBuildDetailObj.iterator();
			List<JsonObject> listproBuildDetail = new ArrayList<JsonObject>();
			while (it.hasNext()) {
				JsonObject item = it.next().getAsJsonObject();
				if (!item.toString().equals("{}")) {
					listproBuildDetail.add(item);
				}
			}
			
			for (JsonObject jsonObject : listproBuildDetail) {
				Product compoID = new Product();
				compoID = productBO.getByID(jsonObject.get("compoID").getAsInt());
				
				StockInventory sInvenCheck = new StockInventory();
				sInvenCheck.setProductID(compoID);
				sInvenCheck.setStockID(stockID);
				int currentQuantity = sInventoryBO.getCurrentQuantity(sInvenCheck);
				
				if (currentQuantity < 0) {
					response = "{\"ID\": \"2\",\"MGS\": \"Can not build this product, Please check item " 
							+ compoID.getProductName() + "\"}";
					return response;
				}
			}
			
			// set value for StockBuild
			sBuild.setProductID(product);
			sBuild.setStaffID(staff);
			sBuild.setStockID(stockID);
			sBuild.setTotalAmount(totalAmount);
			sBuild.setTotalQuantity(totalQuantity);
			sBuild.setBuildDate(Utils.DATE_FORMATTER.parse(Utils.DATE_FORMATTER.format(date)));
			sBuild.setReason(note);

			// save to database
			sBuildBO.insertStockBuild(sBuild);
			
			// update quantity in stock inventory
			StockInventory sInventory = new StockInventory();
			sInventory.setDate(date);
			sInventory.setProductID(product);
			sInventory.setStockID(stockID);
			sInventory.setQuantity(totalQuantity);
			sInventory.setPrice(product.getOrgPrice());
			sInventory.setAmount(totalAmount);
			sInventoryBO.insertStockInventory(sInventory);

			// get StockInwardDetail and save to database

			for (JsonObject jsonObject : listproBuildDetail) {
				// Save to Product Build Detail
				StockBuildDetail sBuildDetail = new StockBuildDetail();

				sBuildDetail.setBuildID(sBuild);
				
				Product compoID = new Product();
				compoID = productBO.getByID(jsonObject.get("compoID").getAsInt());
				sBuildDetail.setComponentID(compoID);
				
				int quantitySBuildDetail = jsonObject.get("quantityCompo").getAsInt();
				sBuildDetail.setQuantity(quantitySBuildDetail);
				sBuildDetail.setPrice(compoID.getOrgPrice());
				BigDecimal subTotal = BigDecimal.ZERO;
				subTotal = product.getOrgPrice().multiply(
						new BigDecimal(sBuildDetail.getQuantity()));
				sBuildDetail.setSubTotal(subTotal);
				
				// Save to StockBuild
				
				sBuildDetailBO.insertStockBuildDetail(sBuildDetail);
				
				// stock inventory detail
				StockInventory sInvenDetail = new StockInventory();
				sInvenDetail.setDate(date);
				sInvenDetail.setProductID(compoID);
				sInvenDetail.setStockID(stockID);
				sInvenDetail.setQuantity(-quantitySBuildDetail);
				sInvenDetail.setPrice(compoID.getOrgPrice());
				sInvenDetail.setAmount(subTotal);
				sInventoryBO.insertStockInventory(sInvenDetail);

			}
			response = "{\"ID\": \"1\"}";
			return response;
		} catch (Exception e) {
			response = "{\"ID\": \"2\",\"MGS\": \"Insert failed. Please try again.\"}";
			return response;
		}
	}
}
