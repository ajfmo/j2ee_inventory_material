package com.j2ee.java.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.j2ee.java.model.dto.Manufacture;

public class ManufactureDAOImpl implements ManufactureDAO {

	static Logger logger = Logger.getLogger(ManufactureDAOImpl.class.getName());
	@Override
	public Manufacture getByID(int id) {
		// TODO Auto-generated method stub
		Manufacture result = new Manufacture();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			result = (Manufacture) session.get(Manufacture.class, id);

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
	public List<Manufacture> getAllManufacture() {
		// TODO Auto-generated method stub
		List<Manufacture> list = new ArrayList<Manufacture>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Manufacture.class);
			list = criteria.list();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return list;
	}

	@Override
	public boolean insertManufacture(Manufacture manufacture) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.save(manufacture);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Manufacture");
		}
		return result;
	}

	@Override
	public boolean updateManufacture(Manufacture manufacture) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.update(manufacture);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update Manufacture");
		}
		return result;
	}

	@Override
	public boolean deleteManufacture(Manufacture manufacture) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.delete(manufacture);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete Manufacture");
		}
		return result;
	}

}
