package com.j2ee.java.model.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.j2ee.java.model.dao.HibernateUtil;
import com.j2ee.java.model.dao.ProductComponentDAO;
import com.j2ee.java.model.dto.ProductComponent;
@Component(value="ProductComponentBOImpl")
public class ProductComponentBOImpl implements ProductComponentBO {

	private static final Logger logger = LoggerFactory.getLogger(ProductComponentBOImpl.class);
	@Autowired
	@Qualifier("ProductComponentDAOImpl")
	private ProductComponentDAO ProductComponentDAO;
	
	@Override
	public List<ProductComponent> getByProductID(int id) {
		// TODO Auto-generated method stub
		List<ProductComponent> ProductComponent = null;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			ProductComponent = ProductComponentDAO.getByProductID(id);

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return ProductComponent;
	}

	@Override
	public List<ProductComponent> getAllProductComponent() {
		// TODO Auto-generated method stub
		List<ProductComponent> listProductComponent = new ArrayList<ProductComponent>();
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listProductComponent = ProductComponentDAO.getAllProductComponent();

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listProductComponent;
	}

	@Override
	public boolean insertProductComponent(ProductComponent productComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = ProductComponentDAO.insertProductComponent(productComponent);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

	@Override
	public boolean updateProductComponent(ProductComponent productComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = ProductComponentDAO.updateProductComponent(productComponent);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

	@Override
	public boolean deleteProductComponent(ProductComponent productComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = ProductComponentDAO.deleteProductComponent(productComponent);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

	@Override
	public int deleteProductCompoByProductID(int id) {
		int result = 0;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = ProductComponentDAO.deleteProductCompoByProductID(id);
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

}
