/**
 * 
 */
package com.j2ee.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	// NewStockMoveBill -- StockMoveNew
	@RequestMapping(value = "/NewStockMoveBill")
	public String newStockMoveBill(Model model) {

		// get list product
		ProductBO productBO = new ProductBOImpl();
		List<Product> listProducts = productBO.getAllProduct();

		// set to model attribute
		model.addAttribute("listProducts", listProducts);

		// get list active stock
		StockBO stockBO = new StockBOImpl();
		List<Stock> listStocks = stockBO.getAllStock();

		// set to model attribute
		model.addAttribute("listStocks", listStocks);

		return "StockMoveNew";
	}

	// processLater -- StockMoveWaiting
	@RequestMapping(value = "/processLater")
	public String processLater(Model model) {

		// get list product
		ProductBO productBO = new ProductBOImpl();
		List<Product> listProducts = productBO.getAllProduct();

		// set to model attribute
		model.addAttribute("listProducts", listProducts);

		// get list active stock
		StockBO stockBO = new StockBOImpl();
		List<Stock> listStocks = stockBO.getAllStock();

		// set to model attribute
		model.addAttribute("listStocks", listStocks);

		return "StockMoveWaiting";
	}

	// checkAvailable -- StockMoveAvailable
	@RequestMapping(value = "/checkAvailable")
	public String checkAvailable(Model model) {

		// get list product
		ProductBO productBO = new ProductBOImpl();
		List<Product> listProducts = productBO.getAllProduct();

		// set to model attribute
		model.addAttribute("listProducts", listProducts);

		// get list active stock
		StockBO stockBO = new StockBOImpl();
		List<Stock> listStocks = stockBO.getAllStock();

		// set to model attribute
		model.addAttribute("listStocks", listStocks);

		return "StockMoveAvailable";
	}

	// processAll -- StockMoveDone
	@RequestMapping(value = "/processAll")
	public String processAll(Model model) {

		// get list product
		ProductBO productBO = new ProductBOImpl();
		List<Product> listProducts = productBO.getAllProduct();

		// set to model attribute
		model.addAttribute("listProducts", listProducts);

		// get list active stock
		StockBO stockBO = new StockBOImpl();
		List<Stock> listStocks = stockBO.getAllStock();

		// set to model attribute
		model.addAttribute("listStocks", listStocks);

		return "StockMoveDone";
	}

	// saveNewStockMove Bill
	@RequestMapping(value = "/saveNewStockMove")
	public @ResponseBody String saveNewStockMove(HttpServletRequest req) {
		
		String product = req.getParameter("product");
		String expectedDay = req.getParameter("expectedDay");
		String quantity = req.getParameter("quantity");
		String priority = req.getParameter("priority");
		String fromStock = req.getParameter("fromStock");
		String toStock = req.getParameter("toStock");
		String description = req.getParameter("description");
		System.out.println(product + ": " + quantity);

		return "StockMoveDone";
	}
	
	//Save new stock move bill
	@RequestMapping(value="/saveNewStockMove")
	public @ResponseBody String saveNewStockMove(HttpServletRequest req){
		String a = req.getParameter("quantity");
		System.out.println(a);
		
		return "";
	}
}
