/**
 * 
 */
package com.j2ee.java.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.ProductBOImpl;
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockBOImpl;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.Stock;

/**
 * @author John Tran
 *
 */
@Controller
public class StockMoveController {

	@RequestMapping(value = "/StockMove")
	public String stockMove() {
		return "StockMove";
	}

	// NewStockMoveBill
	@RequestMapping(value = "/NewStockMoveBill")
	public String newStockMoveBill(Model model) {
		
		//get list product
		ProductBO productBO = new ProductBOImpl();
		List<Product> listProducts = productBO.getAllProduct();
		
		//set to model attribute
		model.addAttribute("listProducts", listProducts);
		
		//get list active stock
		StockBO stockBO = new StockBOImpl();
		List<Stock> listStocks = stockBO.getAllStock();
		
		//set to model attribute
		model.addAttribute("listStocks", listStocks);
		
		return "StockMoveNew";
	}

	// processLater
	@RequestMapping(value = "/processLater")
	public String processLater() {
		return "StockMoveWaiting";
	}
	
	//checkAvailable
	@RequestMapping(value = "/checkAvailable")
	public String checkAvailable() {
		return "StockMoveAvailable";
	}
	
	//processAll
	@RequestMapping(value = "/processAll")
	public String processAll() {
		return "StockMoveDone";
	}
}
