package com.j2ee.java.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StockInwardController {
	
	@RequestMapping(value = "/StockInward")
	public String DemoWidget(Locale locale, Model model) {
		return "StockInward";
	}
}
