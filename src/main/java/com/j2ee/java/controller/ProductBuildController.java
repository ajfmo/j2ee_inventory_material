package com.j2ee.java.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.ProductBOImpl;
import com.j2ee.java.model.bo.ProductComponentBO;
import com.j2ee.java.model.bo.ProductComponentBOImpl;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.ProductComponent;

@Controller
public class ProductBuildController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductBuildController.class);
	
	@RequestMapping(value = "/modal", method = RequestMethod.GET)
	public String modal(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "Component";
	}
	
	// build product
	@RequestMapping(value = "/build", method = RequestMethod.GET)
	public String build(Locale locale, Model model) {
		
		ProductBO productBO = new ProductBOImpl();
		List<Product> listProduct = productBO.getAllProduct();
		
		model.addAttribute("listProduct", listProduct);
		
		return "ProductBuild";
	}
	
	@RequestMapping(value = "/getProductComponent", method = RequestMethod.POST)
	public final @ResponseBody String markOrganisation(HttpServletRequest request) {
		Gson gson = new Gson();
		
		String productID = request.getParameter("productID");

		ProductComponentBO proCompoBO = new ProductComponentBOImpl();
		List<ProductComponent> listProductComponent = proCompoBO.getByID(Integer.valueOf(productID));

		Type type = new TypeToken<List<ProductComponent>>() {
		}.getType();

		String jsonListProCompoBO = gson.toJson(listProductComponent, type);
		
		if (listProductComponent.size() < 0) {
			String jsonList = "[" + jsonListProCompoBO + "]";
			
			return jsonList;
		} else {
			return jsonListProCompoBO;
		}
	}
}
