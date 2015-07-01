
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
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		logger.info("Welcome home!");
		session.setAttribute("staffIDSession", 1);
		new com.j2ee.java.report.ProductReportDAO().runReport("G:\\WORK\\j2ee_inventory_material\\trunk\\src\\main\\resources\\demo.jrxml", "G:\\C1_report.pdf");
		return "Home";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		logger.info("Welcome home!");
		new com.j2ee.java.report.ProductReportDAO().runReport("/demo.jrxml", "Bao cao");
		return "Home";
	}
	
}
