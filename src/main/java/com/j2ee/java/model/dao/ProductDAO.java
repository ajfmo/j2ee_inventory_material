package com.j2ee.java.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.j2ee.java.model.dto.Product;

public class ProductDAO {

	static Logger logger = Logger.getLogger(ProductDAO.class.getName());

	/**
	 * get Product by ID
	 * 
	 * @param id
	 * @return
	 */
	public Product getByID(int id) {
		Product product = new Product();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			product = (Product) session.get(Product.class, id);

			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return product;
	}

	/**
	 * 
	 * @return list products
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Product.class);
			list = criteria.list();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return list;
	}

	/**
	 * save a new Product
	 * 
	 * @param product
	 * @return result of transaction
	 */
	public boolean insertProduct(Product product) {
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.save(product);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return result;
	}

	/**
	 * update data for available Product.
	 * 
	 * @param product
	 * @return result of transaction
	 */
	public boolean updataProduct(Product product) {
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.update(product);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update Product");
		}
		return result;
	}

	/**
	 * delete Product
	 * 
	 * @param product
	 * @return result of transaction
	 */
	public boolean deleteProduct(Product product) {
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.delete(product);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete Product");
		}
		return result;
		//InsertProduct();
	}
}
