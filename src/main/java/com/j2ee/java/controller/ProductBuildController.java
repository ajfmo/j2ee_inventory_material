package com.j2ee.java.controller;

import java.lang.reflect.Type;
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
import com.google.gson.reflect.TypeToken;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.ProductComponentBO;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.ProductComponent;

@Controller
public class ProductBuildController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductBuildController.class);
	
	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;
	
	@Autowired
	@Qualifier("ProductComponentBOImpl")
	private ProductComponentBO proCompoBO;
	
	// build product
	@RequestMapping(value = "/build", method = RequestMethod.GET)
	public String build(Locale locale, Model model) {
		
		List<Product> listProduct = productBO.getAllProduct();
		
		model.addAttribute("listProduct", listProduct);
		
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
}
