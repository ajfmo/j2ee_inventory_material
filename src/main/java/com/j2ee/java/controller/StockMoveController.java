/**
 * 
 */
package com.j2ee.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String newStockMoveBill() {
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
