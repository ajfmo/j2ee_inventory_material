package com.j2ee.java.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.j2ee.java.model.bo.CustomerBO;
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockOutwardBO;
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
	@Qualifier("StockOutwardBOImpl")
	private StockOutwardBO sOutwardBO;

	// return page of function StockInward
	@RequestMapping(value = "/StockOutward")
	public String stockInward(Model model) {

		List<Stock> listStock = stockBO.getAllStock();
		model.addAttribute("listStock", listStock);

		List<Customer> listCustomer = customerBO.getAllCustomer();
		model.addAttribute("listCustomer", listCustomer);

		// get current max StockInward ID.
		int maxStockOut = sOutwardBO.getMaxStockOutID();
		model.addAttribute("maxStockOut", (maxStockOut + 1));

		return "StockOutward";
	}

	// save data
	@RequestMapping(value = "/saveStockOutward", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public @ResponseBody String saveStockInward(HttpServletRequest request)
			throws ParseException {

		String response = "";
		try {
			response = sOutwardBO.insertStockOutward(request);
			return response;
		} catch (Exception e) {
			response = "{\"ID\": \"2\",\"MGS\": \"Insert failed. Please try again.\"}";
			return response;
		}
	}
}
