
package com.j2ee.java.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

@Controller
public class ProductNewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductNewController.class);
	
	
	@RequestMapping(value = "/productnew", method = RequestMethod.GET)
	public String createNewProduct() {
		logger.info("Create New Product!");
		
		return "ProductNew";
	}
	
}
