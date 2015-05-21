
package com.j2ee.java.controller;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.ProductBOImpl;
import com.j2ee.java.model.bo.ProviderBO;
import com.j2ee.java.model.bo.ProviderBOImpl;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.Provider;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		///
//		product.setProductID(11);
//		model.addAttribute("product1", product );
		
//		ProviderBO providerBO = new ProviderBOImpl();
//		List<Provider> listProvider = providerBO.getAllProvider();
//		model.addAttribute("listProvider", listProvider );
		///
		return "StockInward";
	}
	
	@RequestMapping(value = "/demowidget", method = RequestMethod.GET)
	public String DemoWidget(Locale locale, Model model) {
		logger.info("Demo Widget");
		
		return "DemoJqWidget";
	}
	@RequestMapping(value = "/getProvider", method = RequestMethod.GET)
	public @ResponseBody String getProvide() {
		Gson gson = new Gson(); 
		
		ProviderBO providerBO = new ProviderBOImpl();
		Provider listProvider = providerBO.getByID(1);
		
		Type type = new TypeToken<Provider>(){}.getType();
		
		String jsonS = gson.toJson(listProvider, type);
		logger.info(jsonS);
		return jsonS;
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET, produces="application/x-www-form-urlencoded;charset=UTF-8")
	public @ResponseBody String getProduct() {
		Gson gson = new Gson();
		
		ProductBO productBO = new ProductBOImpl();
		List<Product> product = productBO.getAllProduct();
		
		for (Product product2 : product) {
			logger.info("pro " + product2.getTypeID().getTypName());
		}
		String jsonP = gson.toJson(product);
		
		return jsonP; 
		
		
	}
}
