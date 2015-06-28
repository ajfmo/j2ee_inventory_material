package com.j2ee.java.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.j2ee.java.model.bo.ManufactureBO;
import com.j2ee.java.model.bo.ProductBO;
import com.j2ee.java.model.bo.ProductTypeBO;
import com.j2ee.java.model.bo.ProductUnitBO;
import com.j2ee.java.model.bo.ProviderBO;
import com.j2ee.java.model.dto.Manufacture;
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
		
		return "ProductNew";
	}

}
