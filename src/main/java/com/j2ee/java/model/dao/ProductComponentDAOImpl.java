package com.j2ee.java.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.j2ee.java.model.dto.ProductComponent;

public class ProductComponentDAOImpl implements ProductComponentDAO {

	static Logger logger = Logger.getLogger(ProductComponentDAOImpl.class.getName());
	@Override
	public ProductComponent getByID(int id) {
		// TODO Auto-generated method stub
		ProductComponent result = new ProductComponent();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			result = (ProductComponent) session.get(ProductComponent.class, id);

			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductComponent> getAllProductComponent() {
		// TODO Auto-generated method stub
		List<ProductComponent> list = new ArrayList<ProductComponent>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(ProductComponent.class);
			list = criteria.list();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return list;
	}

	@Override
	public boolean insertProductComponent(ProductComponent ProductComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.save(ProductComponent);

			session.getTransaction().commit();
			session.close();
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
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.update(ProductComponent);

			session.getTransaction().commit();
			session.close();
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
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.delete(ProductComponent);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete ProductComponent");
		}
		return result;
	}
}
