/**
 * 
 */
package com.j2ee.java.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.j2ee.java.model.bo.StockInventoryBO;
import com.j2ee.java.model.bo.StockTransferBO;
import com.j2ee.java.model.bo.Utils;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.Stock;
import com.j2ee.java.model.dto.StockInventory;
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

	@Autowired
	@Qualifier("StockInventoryBOImpl")
	private StockInventoryBO stockInventoryBO;

	@RequestMapping(value = "/StockMove")
	public String stockMove() {

		return "StockMove";
	}

	// NewStockMoveBill -- StockMoveNew
	@RequestMapping(value = "/NewStockMoveBill")
	public String newStockMoveBill(Model model) {

		// get latest stock transfer id
		int lastestID = stockTransferBO.getLastestBillID();

		// set to model attribute, after increase this ID
		model.addAttribute("lastestID", lastestID + 1);

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

	// updateToAvailable -- update status of bill to available
	@RequestMapping(value = "/updateToAvailable")
	public @ResponseBody String updateToAvailable(HttpServletRequest req) {

		int result = 0; 
		
		//get current stock transfer id
		String stTransIDReq = req.getParameter("stockTransferID");
		if(!"".equals(stTransIDReq)){
			int currentStockTransfer = Integer.parseInt(stTransIDReq);
			StockTransfer stockTransfer = stockTransferBO.getByID(currentStockTransfer);
			stockTransfer.setStatusID(stockTransferBO.getStatusID("Available"));
			if(stockTransferBO.updateStockTransfer(stockTransfer)){
				result = 1;
			}
		}
		return "{\"result\" : \"" + result + "\"}";
	}

	// processLater -- StockMoveWaiting
	@RequestMapping(value = "/processLater")
	public @ResponseBody String processLater(HttpServletRequest req) {

		// get stock move
		String stockMove = req.getParameter("0");
		JsonObject stockMoveObj = new Gson().fromJson(stockMove,
				JsonObject.class);

		// get latest stock transfer id from form
		int latestIDFromForm = stockMoveObj.get("latestID").getAsInt();

		if (latestIDFromForm <= 0) {
			return "{\"result\" : \"0\"}";
		}

		// check if have this stock transfer id in database
		// get latest stock transfer id from database
		int latestIDFromData = stockTransferBO.getLastestBillID();

		// save data to database
		if (latestIDFromData != latestIDFromForm) {

			// if didn't have:
			// create a stockTransfer object from request, with status is
			// Waiting Available (2)
			StockTransfer stTranfer = createStockTransferDTOObject(req, 2);
			if (stockTransferBO.insertStockTransfer(stTranfer)) {
				return "{\"result\" : \"1\"}";
			} else {
				return "{\"result\" : \"0\"}";
			}
		} else {

			// if had: update status of stock transfer bill to: Waiting
			StockTransfer stTranfer = stockTransferBO.getByID(latestIDFromForm);
			stTranfer.setStatusID(2); // 2 == Waiting Available
			if (stockTransferBO.updateStockTransfer(stTranfer)) {
				return "{\"result\" : \"1\"}";
			} else {
				return "{\"result\" : \"0\"}";
			}
		}

	}

	// navigate -- StockMoveWaiting
	// TO-DO: set values of selects, quantity, date,... same as database
	/*
	 * @RequestMapping(value = "/stockMoveWaiting") public String
	 * stockMoveWaiting(Model model) {
	 * 
	 * // get list product List<Product> listProducts =
	 * productBO.getAllProduct();
	 * 
	 * // set to model attribute model.addAttribute("listProducts",
	 * listProducts);
	 * 
	 * // get list active stock List<Stock> listStocks = stockBO.getAllStock();
	 * 
	 * // set to model attribute model.addAttribute("listStocks", listStocks);
	 * 
	 * return "StockMoveWaiting";
	 * 
	 * }
	 */

	// checkAvailable -- StockMoveAvailable
	@RequestMapping(value = "/checkAvailable")
	public @ResponseBody String checkAvailable(HttpServletRequest req) {

		StockInventory stockInventory = new StockInventory();

		// get stock move
		String stockMove = req.getParameter("0");
		JsonObject stockMoveObj = new Gson().fromJson(stockMove,
				JsonObject.class);

		// get Product
		Product product = new Product();
		product = productBO.getByID(Integer.parseInt(stockMoveObj
				.get("product").getAsString().split(":")[0]));
		stockInventory.setProductID(product);

		// get quantity
		int quantity = stockMoveObj.get("quantity").getAsInt();
		stockInventory.setQuantity(quantity);

		// get from stock
		Stock fromStock = new Stock();
		fromStock = stockBO.getByID(Integer.parseInt(stockMoveObj
				.get("fromStock").getAsString().split(":")[0]));
		stockInventory.setStockID(fromStock);

		int result = stockInventoryBO.checkAvailableOfProduct(stockInventory);

		return "{\"result\" : \"" + result + "\"}";
	}

	// processAll -- StockMoveDone
	/*
	 * @RequestMapping(value = "/processAll") public String processAll(Model
	 * model) {
	 * 
	 * // get list product List<Product> listProducts =
	 * productBO.getAllProduct();
	 * 
	 * // set to model attribute model.addAttribute("listProducts",
	 * listProducts);
	 * 
	 * // get list active stock List<Stock> listStocks = stockBO.getAllStock();
	 * 
	 * // set to model attribute model.addAttribute("listStocks", listStocks);
	 * 
	 * return "StockMoveDone"; }
	 */

	// saveNewStockMove Bill
	@RequestMapping(value = "/saveNewStockMove")
	public @ResponseBody String saveNewStockMove(HttpServletRequest req) {

		// create a stockTransfer object from request, with status is New (1)
		StockTransfer stTranfer = createStockTransferDTOObject(req, 1);

		// get stock move
		String stockMove = req.getParameter("0");
		JsonObject stockMoveObj = new Gson().fromJson(stockMove,
				JsonObject.class);

		// get latest stock transfer id from form
		int latestIDFromForm = stockMoveObj.get("latestID").getAsInt();

		// get latest stock transfer id from database
		int latestIDFromData = stockTransferBO.getLastestBillID();

		// save data to database
		if (latestIDFromData != latestIDFromForm) {
			if (stockTransferBO.insertStockTransfer(stTranfer)) {
				return "{\"result\" : \"1\"}";
			}
		} else {
			stTranfer.setTransferID(latestIDFromData);
			if (stockTransferBO.updateStockTransfer(stTranfer)) {
				return "{\"result\" : \"2\"}";
			}
		}

		return "{\"result\" : \"0\"}";
	}

	private StockTransfer createStockTransferDTOObject(HttpServletRequest req,
			int statusID) {

		StockTransfer stTranfer = new StockTransfer();

		// get stock move
		String stockMove = req.getParameter("0");
		JsonObject stockMoveObj = new Gson().fromJson(stockMove,
				JsonObject.class);

		// get staff object
		/*
		 * Staff staff = new Staff(); int staffID = (int)
		 * session.getAttribute("staffIDSession"); staff = staffBO.getByID(1);
		 * stTranfer.setStaffID(staff);
		 */

		// get Reference Type
		stTranfer.setStatusID(statusID);

		// get Product
		Product product = new Product();
		product = productBO.getByID(Integer.parseInt(stockMoveObj
				.get("product").getAsString().split(":")[0]));
		stTranfer.setProductID(product);

		// get expected day
		try {
			stTranfer.setExpectedDate(Utils.DATE_FORMATTER_WEB
					.parse(stockMoveObj.get("expectedDay").getAsString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// get quantity
		stTranfer.setQuantity(stockMoveObj.get("quantity").getAsInt());

		// get priority
		stTranfer.setPriority(stockTransferBO.getPriorityID(stockMoveObj.get(
				"priority").getAsString()));

		// get from stock
		Stock fromStock = new Stock();
		fromStock = stockBO.getByID(Integer.parseInt(stockMoveObj
				.get("fromStock").getAsString().split(":")[0]));
		stTranfer.setFromStock(fromStock);

		// get to stock
		Stock toStock = new Stock();
		toStock = stockBO.getByID(Integer.parseInt(stockMoveObj.get("toStock")
				.getAsString().split(":")[0]));
		stTranfer.setToStock(toStock);

		// get description
		stTranfer.setDescription(stockMoveObj.get("description").getAsString());

		return stTranfer;
	}
}
