package com.j2ee.java.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import com.j2ee.java.model.dto.ProductComponent;

public class ProductComponentDAOImpl implements ProductComponentDAO {

	static Logger logger = Logger.getLogger(ProductComponentDAOImpl.class.getName());
	@Override
	public ProductComponent getByID(int id) {
		// TODO Auto-generated method stub
		return (ProductComponent) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(ProductComponent.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductComponent> getAllProductComponent() {
		// TODO Auto-generated method stub
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from ProductComponent").list();
	}

	@Override
	public boolean insertProductComponent(ProductComponent ProductComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.save(ProductComponent);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save ProductComponent");
		}
		return result;
	}

	@Override
	public boolean updateProductComponent(ProductComponent ProductComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.update(ProductComponent);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update ProductComponent");
		}
		return result;
	}

	@Override
	public boolean deleteProductComponent(ProductComponent ProductComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.delete(ProductComponent);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete ProductComponent");
		}
		return result;
	}
}
