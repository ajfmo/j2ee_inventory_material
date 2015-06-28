package com.j2ee.java.controller;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.j2ee.java.model.bo.ManufactureBO;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.ProductTypeBO;
import com.j2ee.java.model.bo.ProductUnitBO;
import com.j2ee.java.model.bo.ProviderBO;
import com.j2ee.java.model.dto.Manufacture;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.ProductType;
import com.j2ee.java.model.dto.ProductUnit;
import com.j2ee.java.model.dto.Provider;

/**
 * Handles requests for the application home page.
 */

@Controller
public class ProductManageController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductManageController.class);

	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;

	@Autowired
	@Qualifier("ProductTypeBOImpl")
	private ProductTypeBO productTypeBO;

	@Autowired
	@Qualifier("ProductUnitBOImpl")
	private ProductUnitBO productUnitBO;

	@Autowired
	@Qualifier("ManufactureBOImpl")
	private ManufactureBO manufactureBO;

	@Autowired
	@Qualifier("ProviderBOImpl")
	private ProviderBO providerBO;

	@RequestMapping(value = "/productNew", method = RequestMethod.GET)
	public String createNewProduct(Model model) {

		logger.info("Create New Product!");

		// get list product type and set it to model
		List<ProductType> listProductType = productTypeBO.getAllProductType();
		model.addAttribute("listProductType", listProductType);

		// get list product unit and set it to model
		List<ProductUnit> listProductUnit = productUnitBO.getAllProductUnit();
		model.addAttribute("listProductUnit", listProductUnit);

		// get list Manufacture and set it to model
		List<Manufacture> listManufacture = manufactureBO.getAllManufacture();
		model.addAttribute("listManufacture", listManufacture);

		// get list Manufacture and set it to model
		List<Provider> listProvider = providerBO.getAllProvider();
		model.addAttribute("listProvider", listProvider);

		// set this process is create new
		model.addAttribute("isEdit", 0);

		return "ProductNew";
	}

	// when choose edit a product
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public String updateProduct(Model model, HttpServletRequest req) {

		logger.info("Edit product!");

		String productIDRequest = (String) req.getParameter("productID");
		if (productIDRequest == null || "".equals(productIDRequest)) {
			return "ErrorPage";
		}

		int productID = Integer.parseInt(productIDRequest);

		Product product = productBO.getByID(productID);
		if (product == null) {
			return "ErrorPage";
		}

		// add product information to model
		model.addAttribute("productToEdit", product);

		// add product photo blob -> string to model
		Blob productPhoto = product.getPhoto();
		try {
			model.addAttribute("productPhoto", new String(productPhoto.getBytes(1, (int)productPhoto.length())));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// get list product type and set it to model
		List<ProductType> listProductType = productTypeBO.getAllProductType();
		model.addAttribute("listProductType", listProductType);

		// get list product unit and set it to model
		List<ProductUnit> listProductUnit = productUnitBO.getAllProductUnit();
		model.addAttribute("listProductUnit", listProductUnit);

		// get list Manufacture and set it to model
		List<Manufacture> listManufacture = manufactureBO.getAllManufacture();
		model.addAttribute("listManufacture", listManufacture);

		// get list Manufacture and set it to model
		List<Provider> listProvider = providerBO.getAllProvider();
		model.addAttribute("listProvider", listProvider);

		// set this process is create new
		model.addAttribute("isEdit", 1);

		return "ProductNew";
	}

	// when choose delete product
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public @ResponseBody String deleteProduct(HttpServletRequest req) {

		// get product info
		String productInfo = req.getParameter("0");
		JsonObject productObj = new Gson().fromJson(productInfo,
				JsonObject.class);

		Product product = productBO.getByID(productObj.get("productID")
				.getAsInt());
		if (product == null) {
			return "{\"result\" : \"0\"}";
		}

		if (productBO.deleteProduct(product)) {
			return "{\"result\" : \"1\"}";
		}

		return "{\"result\" : \"0\"}";
	}

	@RequestMapping(value = "/saveProduct")
	public @ResponseBody String saveProduct(HttpServletRequest req, Model model) {

		// get product info
		String productInfo = req.getParameter("0");
		JsonObject productObj = new Gson().fromJson(productInfo,
				JsonObject.class);

		Product product = new Product();

		// set product's photo
		String img64 = productObj.get("productImg64").getAsString();
		
		product.setPhoto(org.hibernate.Hibernate.createBlob(img64.getBytes()));

		// set product's name
		product.setProductName(productObj.get("productName").getAsString());

		// set origin price
		product.setOrgPrice(productObj.get("orgPrice").getAsBigDecimal());

		// set default sale price
		product.setSalePrice(productObj.get("orgPrice").getAsBigDecimal());

		// set product type
		ProductType productType = productTypeBO.getByID(productObj.get(
				"productTypeID").getAsInt());
		product.setTypeID(productType);

		// set product unit
		ProductUnit productUnit = productUnitBO.getByID(productObj.get(
				"productUnitID").getAsInt());
		product.setUnitID(productUnit);

		// set manufacture
		Manufacture manufacture = manufactureBO.getByID(productObj.get(
				"manufactureID").getAsInt());
		product.setManufactureID(manufacture);

		// set provider
		Provider provider = providerBO.getByID(productObj.get("providerID")
				.getAsInt());
		product.setProviderID(provider);

		// set minimum stock
		product.setMinStock(productObj.get("minStock").getAsInt());

		// set maximum stock
		product.setMaxStock(productObj.get("maxStock").getAsInt());

		// set description
		product.setDescription(productObj.get("description").getAsString());

		int isEdit = productObj.get("isEdit").getAsInt();

		if (isEdit == 0) {// create new
			if (productBO.insertProduct(product)) {
				return "{\"result\" : \"1\", \"isEdit\" : \"1\"}";
			}
		} else {// update
			product.setProductID(productObj.get("productID").getAsInt());
			if (productBO.updateProduct(product)) {
				return "{\"result\" : \"2\", \"isEdit\" : \"1\"}";
			}
		}

		return "{\"result\" : \"0\"}";
	}

}
