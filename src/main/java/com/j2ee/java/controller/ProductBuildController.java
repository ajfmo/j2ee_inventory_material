package com.j2ee.java.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j2ee.java.model.bo.ProviderBO;
import com.j2ee.java.model.bo.ProviderBOImpl;
import com.j2ee.java.model.dto.Provider;

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
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "ProductBuild";
	}
	
	@RequestMapping(value = "/getProductComponent", method = RequestMethod.POST)
	public final @ResponseBody String markOrganisation() {
		Gson gson = new Gson();

		ProviderBO providerBO = new ProviderBOImpl();
		List<Provider> listProvider = providerBO.getAllProvider();

		Type type = new TypeToken<List<Provider>>() {
		}.getType();

		String jsonS = gson.toJson(listProvider, type);
		
		return jsonS;
	}
}
