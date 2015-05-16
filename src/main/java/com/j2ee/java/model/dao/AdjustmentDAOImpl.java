package com.j2ee.java.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.j2ee.java.model.dto.Adjustment;

public class AdjustmentDAOImpl implements AdjustmentDAO {

	static Logger logger = Logger.getLogger(AdjustmentDAOImpl.class.getName());
	@Override
	public Adjustment getByID(int id) {
		// TODO Auto-generated method stub
		Adjustment result = new Adjustment();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			result = (Adjustment) session.get(Adjustment.class, id);

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
	public List<Adjustment> getAllAdjustment() {
		// TODO Auto-generated method stub
		List<Adjustment> list = new ArrayList<Adjustment>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Adjustment.class);
			list = criteria.list();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return list;
	}

	@Override
	public boolean insertAdjustment(Adjustment adjustment) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.save(adjustment);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save adjustment");
		}
		return result;
	}

	@Override
	public boolean updateAdjustment(Adjustment adjustment) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.update(adjustment);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update adjustment");
		}
		return result;
	}

	@Override
	public boolean deleteAdjustment(Adjustment adjustment) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.delete(adjustment);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete adjustment");
		}
		return result;
	}

}
