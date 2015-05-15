package com.j2ee.java.model.dao;


import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.j2ee.java.model.dto.Manufacture;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.ProductComponent;
import com.j2ee.java.model.dto.ProductType;
import com.j2ee.java.model.dto.ProductUnit;
import com.j2ee.java.model.dto.Provider;

public class ProductDAO {

	static Logger log = Logger.getLogger(ProductDAO.class.getName());
	
	public static void InsertProduct() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		ProductType proType = (ProductType) session.get(ProductType.class, 1);
		Provider provider = (Provider) session.get(Provider.class, 2);
		
		Manufacture manu = new Manufacture("Dell", "USA", "2424", "May tinh apple");
		
		ProductUnit proUnit = (ProductUnit) session.get(ProductUnit.class, 3);
		
		Product product = new Product("Lap top apple", proType, provider, manu, proUnit, 
				new BigDecimal(1000), new BigDecimal(500), "May tinh", 10, 100, "abd");
		session.save(product);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Product product1 = (Product) session.get(Product.class, 1);
		log.info("pro1 " + product1.getSalePrice());
		log.info("pro1 " + product1.getProductName());
		Product product2 = (Product) session.get(Product.class, 2);
		
		Product product3 = (Product) session.get(Product.class, 3);
		
		ProductComponent proCompo = new ProductComponent(product1, product3, 1, product1.getSalePrice(), (product1.getSalePrice()));
		
		log.info("proCom " + proCompo.getProductID());
		session.save(proCompo);
		ProductComponent proCompo2 = new ProductComponent(product2, product3, 1, product2.getSalePrice(), (product2.getSalePrice()));
		session.save(proCompo2);
		session.getTransaction().commit();
		session.close();
	}
}
