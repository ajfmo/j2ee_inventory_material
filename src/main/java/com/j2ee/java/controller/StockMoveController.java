/**
 * 
 */
package com.j2ee.java.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.StaffBO;
import com.j2ee.java.model.bo.StockBO;
import com.j2ee.java.model.bo.StockTransferBO;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.ReferenceType;
import com.j2ee.java.model.dto.Staff;
import com.j2ee.java.model.dto.Stock;
import com.j2ee.java.model.dto.StockTransfer;

/**
 * @author John Tran
 *
 */
@Component
@Controller
public class StockMoveController {

	@Autowired
	@Qualifier("StTransferBOImpl")
	private StockTransferBO stockTransferBO;

	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;

	@Autowired
	@Qualifier("StockBOImpl")
	private StockBO stockBO;
	
	@Autowired
	@Qualifier("StaffBOImpl")
	private StaffBO staffBO;

	@RequestMapping(value = "/StockMove")
	public String stockMove() {

		return "StockMove";
	}

	// NewStockMoveBill -- StockMoveNew
	@RequestMapping(value = "/NewStockMoveBill")
	public String newStockMoveBill(Model model) {

		// get list product
		List<Product> listProducts = productBO.getAllProduct();

		// set to model attribute
		model.addAttribute("listProducts", listProducts);

		// get list active stock
		List<Stock> listStocks = stockBO.getAllStock();

		// set to model attribute
		model.addAttribute("listStocks", listStocks);

		return "StockMoveNew";
	}

	// processLater -- StockMoveWaiting
	@RequestMapping(value = "/processLater")
	public String processLater(Model model) {

		// get list product
		List<Product> listProducts = productBO.getAllProduct();

		// set to model attribute
		model.addAttribute("listProducts", listProducts);

		// get list active stock
		List<Stock> listStocks = stockBO.getAllStock();

		// set to model attribute
		model.addAttribute("listStocks", listStocks);

		return "StockMoveWaiting";
	}

	// checkAvailable -- StockMoveAvailable
	@RequestMapping(value = "/checkAvailable")
	public String checkAvailable(Model model) {

		// get list product
		List<Product> listProducts = productBO.getAllProduct();

		// set to model attribute
		model.addAttribute("listProducts", listProducts);

		// get list active stock
		List<Stock> listStocks = stockBO.getAllStock();

		// set to model attribute
		model.addAttribute("listStocks", listStocks);

		return "StockMoveAvailable";
	}

	// processAll -- StockMoveDone
	@RequestMapping(value = "/processAll")
	public String processAll(Model model) {

		// get list product
		List<Product> listProducts = productBO.getAllProduct();

		// set to model attribute
		model.addAttribute("listProducts", listProducts);

		// get list active stock
		List<Stock> listStocks = stockBO.getAllStock();

		// set to model attribute
		model.addAttribute("listStocks", listStocks);

		return "StockMoveDone";
	}

	// saveNewStockMove Bill
	@RequestMapping(value = "/saveNewStockMove")
	public @ResponseBody String saveNewStockMove(HttpServletRequest req,
			HttpSession session) {

		String productID = req.getParameter("product");
		String expectedDay = req.getParameter("expectedDay");
		String quantity = req.getParameter("quantity");
		String priority = req.getParameter("priority");
		String fromStockID = req.getParameter("fromStock");
		String toStockID = req.getParameter("toStock");
		String description = req.getParameter("description");

		// get stock move
		String stockMove = req.getParameter("0");
		JsonObject stockMoveObj = new Gson().fromJson(stockMove,
				JsonObject.class);

		//save data to database
		//get staff object
		Staff staff = new Staff();
		
		StockTransfer stTranfer = new StockTransfer();

		//Staff staff = new Staff();
		//staff.setStaffID((int) session.getAttribute("staffID"));

		stTranfer.setStaffID(staff);

		ReferenceType refType = new ReferenceType();
		refType.setRefTypeID(10); // 10 mean New

		stTranfer.setStatusID(refType);

		Product product = new Product();
		product.setProductID(Integer.parseInt(productID.split(":")[0]));

		stTranfer.setProductID(product);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			stTranfer.setExpectedDate(sdf.parse(expectedDay));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		stTranfer.setQuantity(Integer.parseInt(quantity));
		stTranfer.setPriority(stockTransferBO.getPriorityID(priority));

		Stock fromStock = new Stock();
		fromStock.setStockID(Integer.parseInt(fromStockID.split(":")[0]));

		stTranfer.setFromStock(fromStock);

		Stock toStock = new Stock();
		toStock.setStockID(Integer.parseInt(toStockID.split(":")[0]));

		stTranfer.setToStock(toStock);
		stTranfer.setDescription(description);

		if (stockTransferBO.insertStockInward(stTranfer)) {
			return "{\"result\" : \"1\"}";
		}

		// System.out.println(product + ": " + quantity);

		return "{\"result\" : \"0\"}";
	}
}
