package com.j2ee.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StockInwardController {
	
	@RequestMapping(value = "/StockInward")
	public String stockInward() {
		return "StockInward";
	}
}
