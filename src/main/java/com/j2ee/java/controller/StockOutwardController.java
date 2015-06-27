package com.j2ee.java.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j2ee.java.model.bo.CustomerBO;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.CustomerBO;
import com.j2ee.java.model.bo.StaffBO;
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockInventoryBO;
import com.j2ee.java.model.bo.StockInwardBO;
import com.j2ee.java.model.bo.StockInwardDetailBO;
import com.j2ee.java.model.dto.Customer;
import com.j2ee.java.model.dto.Stock;

@Controller
public class StockOutwardController {

	@Autowired
	@Qualifier("StockBOImpl")
	private StockBO stockBO;
	
	@Autowired
	@Qualifier("CustomerBOImpl")
	private CustomerBO customerBO;
	
	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;
	
	@Autowired
	@Qualifier("StockInwardBOImpl")
	private StockInwardBO stockInwardBO;
	
	@Autowired
	@Qualifier("StockInventoryBOImpl")
	private StockInventoryBO stockInventoryBO;
	
	@Autowired
	@Qualifier("StaffBOImpl")
	private StaffBO staffBO;
	
	@Autowired
	@Qualifier("StockInwardDetailBOImpl")
	private StockInwardDetailBO stockInDetailBO;
	
	private static final Logger logger = LoggerFactory
			.getLogger(StockInwardController.class);
	
	// return page of function StockInward
	@RequestMapping(value = "/StockOutward")
	public String stockInward(Model model) {
		
		List<Stock> listStock = stockBO.getAllStock();
		model.addAttribute("listStock", listStock);

		List<Customer> listCustomer = customerBO.getAllCustomer();
		model.addAttribute("listCustomer", listCustomer);
		
		// get current max StockInward ID.
		int maxStockIn = stockInwardBO.getMaxStockInID();
		model.addAttribute("maxStockIn", (maxStockIn + 1));
		
		return "StockInward";
	}
}
