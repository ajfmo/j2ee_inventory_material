package com.j2ee.java.controller;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.google.gson.JsonArray;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.ProductComponentBO;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.ProductComponent;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);

	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;

	@Autowired
	@Qualifier("ProductComponentBOImpl")
	private ProductComponentBO productCompoBO;

	@RequestMapping(value = "/getProductInfor", method = RequestMethod.POST)
	public final @ResponseBody String getProduct(HttpServletRequest request) {
		logger.debug("Get Product information using ID");

		Gson gson = new Gson();

		String productID = request.getParameter("productID");

		Product product = productBO.getByID(Integer.parseInt(productID));

		Type type = new TypeToken<Product>() {
		}.getType();

		String jsonProduct = gson.toJson(product, type);
		return jsonProduct;
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Locale locale, Model model) {
		logger.info("Display List Product information");

		return "ListProduct";
	}

	@RequestMapping(value = "/getListProduct", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public @ResponseBody String getListProduct() {
		Gson gson = new Gson();

		List<Product> listProduct = new ArrayList<Product>();
		listProduct = productBO.getAllProduct();

		Type type = new TypeToken<List<Product>>() {
		}.getType();

		String jsonProduct = gson.toJson(listProduct, type);
		return jsonProduct;
	}

	// open page Create Component for Product
	@RequestMapping(value = "/createComponent", method = RequestMethod.GET)
	public String createComponent(Locale locale, Model model) {
		logger.info("Display form add component information");

		return "Component";
	}

	// Save Component for Product
	@RequestMapping(value = "/saveProductComponent", method = RequestMethod.POST)
	public @ResponseBody String saveProductComponent(HttpServletRequest request) {

		// get compoID 
		String checkProductID = request.getParameter("0");
		JsonObject checkProductIDObj = new Gson().fromJson(checkProductID,
				JsonObject.class);
		List<ProductComponent> itemCheck = new ArrayList<ProductComponent>();
		itemCheck = productCompoBO.getByProductID(checkProductIDObj.get("productID").getAsInt());
		// check list
		if (itemCheck.size() > 0) {
			// delete all product Component
			productCompoBO.deleteProductCompoByProductID(checkProductIDObj.get("productID").getAsInt());
		}
		
		// get product component
		String ajaxData = request.getParameter("1");
		JsonArray productComponentObj = (JsonArray) new Gson().fromJson(
				ajaxData, JsonArray.class);

		Iterator<JsonElement> it = productComponentObj.iterator();
		List<JsonObject> listProCompo = new ArrayList<JsonObject>();
		while (it.hasNext()) {
			JsonObject item = it.next().getAsJsonObject();
			if (!item.toString().equals("{}")) {
				listProCompo.add(item);
			}
		}

		for (JsonObject jsonObject : listProCompo) {

			Product product = new Product();
			product.setProductID(jsonObject.get("productID").getAsInt());

			Product component = new Product();
			component = productBO.getByID(jsonObject.get("componentID").getAsInt());

			BigDecimal unitPrice = component.getOrgPrice();

			ProductComponent productCompo = new ProductComponent();
			productCompo.setProductID(product);
			productCompo.setComponentID(component);
			productCompo.setQuantity(jsonObject.get("quantity").getAsInt());
			productCompo.setUnitPrice(unitPrice);
			productCompo.setTotal(unitPrice.multiply(new BigDecimal(
					productCompo.getQuantity())));

			productCompoBO.insertProductComponent(productCompo);
		}

		String response = "{\"ID\": \"1\"}";
		return response;
	}
}
