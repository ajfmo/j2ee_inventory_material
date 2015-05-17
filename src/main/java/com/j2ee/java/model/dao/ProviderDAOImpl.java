package com.j2ee.java.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.j2ee.java.model.dto.Provider;

public class ProviderDAOImpl implements ProviderDAO {

	static Logger logger = Logger.getLogger(ProviderDAO.class.getName());
	
	@Override
	public Provider getByID(int id) {
		// TODO Auto-generated method stub
		Provider Provider = new Provider();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Provider = (Provider) session.get(Provider.class, id);

			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Provider");
		}
		return Provider;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provider> getAllProvider() {
		// TODO Auto-generated method stub
		List<Provider> list = new ArrayList<Provider>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Provider.class);
			list = criteria.list();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Provider");
		}
		return list;
	}

	@Override
	public boolean insertProvider(Provider Provider) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.save(Provider);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Provider");
		}
		return result;
	}

	@Override
	public boolean updateProvider(Provider Provider) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.update(Provider);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update Provider");
		}
		return result;
	}

	@Override
	public boolean deleteProvider(Provider Provider) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.delete(Provider);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete Provider");
		}
		return result;
	}

}
