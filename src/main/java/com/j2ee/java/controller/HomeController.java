
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
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockBOImpl;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.Provider;
import com.j2ee.java.model.dto.Stock;

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
		
		StockBO stockBO = new StockBOImpl();
		List<Stock> listStock = stockBO.getAllStock();
		model.addAttribute("listStock", listStock );
		return "StockInward";
	}
	
	@RequestMapping(value = "/demowidget", method = RequestMethod.GET)
	public String DemoWidget(Locale locale, Model model) {
		logger.info("Demo Widget");
		
		return "DemoJqWidget";
	}
	
	// demo auto-complete
	@RequestMapping(value = "/auto", method = RequestMethod.GET)
	public String Auto(Locale locale, Model model) {
		
		StockBO stockBO = new StockBOImpl();
		List<Stock> listStock = stockBO.getAllStock();
		model.addAttribute("listStock", listStock );
		return "Index";
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
	
	@RequestMapping(value = "/getData", method = RequestMethod.POST, produces="application/x-www-form-urlencoded;charset=UTF-8")
	public @ResponseBody String getData() {
		Gson gson = new Gson();
		
		ProductBO productBO = new ProductBOImpl();
		List<Product> product = productBO.getAllProduct();
		
		for (Product product2 : product) {
			logger.info("pro " + product2.getTypeID().getTypName());
		}
		String jsonP = gson.toJson(product);
		
		return jsonP; 	
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST, produces="application/x-www-form-urlencoded;charset=UTF-8")
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
}
