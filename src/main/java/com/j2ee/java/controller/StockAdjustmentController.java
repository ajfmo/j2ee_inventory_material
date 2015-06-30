package com.j2ee.java.controller;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockInventoryBO;
import com.j2ee.java.model.bo.Utils;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.Stock;
import com.j2ee.java.model.dto.StockInventory;

@Controller
public class StockAdjustmentController {

	@Autowired
	@Qualifier("StockInventoryBOImpl")
	private StockInventoryBO stockInventoryBO;

	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;

	@Autowired
	@Qualifier("StockBOImpl")
	private StockBO stockBO;

	@Autowired
	private Utils utils;

	@RequestMapping(value = "/getListStockAdjustment")
	public @ResponseBody String stockInventory() throws ParseException {

		Gson gson = new Gson();
		
		List<StockInventory> listSInven = new ArrayList<StockInventory>();

		List<Object[]> listInventory = stockInventoryBO.getAllStockInventory();
		Iterator<Object[]> itr = listInventory.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			String date = String.valueOf(obj[0]);

			String proID = String.valueOf(obj[1]);
			Product product = new Product();
			product = productBO.getByID(Integer.parseInt(proID));

			String stocID = String.valueOf(obj[2]);
			Stock stock = new Stock();
			stock = stockBO.getByID(Integer.parseInt(stocID));

			int totalQ = Integer.parseInt(obj[3].toString());

			/* set value */
			StockInventory sInven = new StockInventory();
			sInven.setDate(Utils.DATE_FORMATTER.parse(date));
			sInven.setProductID(product);
			sInven.setStockID(stock);
			sInven.setQuantity(totalQ);
			sInven.setPrice(product.getOrgPrice());
			BigDecimal amount = BigDecimal.ZERO;
			amount = product.getOrgPrice().multiply(new BigDecimal(totalQ));
			sInven.setAmount(amount);

			// add to list
			listSInven.add(sInven);
		}

		Type type = new TypeToken<List<StockInventory>>() {
		}.getType();
		
		String jsonS = gson.toJson(listSInven, type);
		
		return jsonS;
	}
	
	@RequestMapping(value = "/StockAdjustment")
	public String StockAdjustment(Model model) throws ParseException {
		List<Stock> listStock = stockBO.getAllStock();
		model.addAttribute("listStock", listStock);
		
		return "StockAdjustment";
	}
}
