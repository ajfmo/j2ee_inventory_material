package com.j2ee.java.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.j2ee.java.model.dto.Staff;

public class StaffDAOImpl implements StaffDAO {

	static Logger logger = Logger.getLogger(StaffDAOImpl.class.getName());
	@Override
	public Staff getByID(int id) {
		// TODO Auto-generated method stub
		Staff result = new Staff();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			result = (Staff) session.get(Staff.class, id);

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
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		List<Staff> list = new ArrayList<Staff>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Staff.class);
			list = criteria.list();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Product");
		}
		return list;
	}

	@Override
	public boolean insertStaff(Staff Staff) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.save(Staff);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save Staff");
		}
		return result;
	}

	@Override
	public boolean updateStaff(Staff Staff) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.update(Staff);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update Staff");
		}
		return result;
	}

	@Override
	public boolean deleteStaff(Staff Staff) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			session.delete(Staff);

			session.getTransaction().commit();
			session.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete Staff");
		}
		return result;
	}
}
