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
import com.j2ee.java.model.dao.StockOutwardDAO;
import com.j2ee.java.model.dto.StockOutward;

@Component(value="StockOutwardBOImpl")
public class StockOutwardBOImpl implements StockOutwardBO {

private static final Logger logger = LoggerFactory.getLogger(StockOutwardBOImpl.class);
	
	@Autowired
	@Qualifier("StockOutwardDAOImpl")
	private StockOutwardDAO StockOutwardDAO;
	
	@Override
	public StockOutward getByID(int id) {
		
		StockOutward StockOutward = null;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			StockOutward = StockOutwardDAO.getByID(id);

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return StockOutward;
	}

	@Override
	public List<StockOutward> getAllStockOutward() {
		
		List<StockOutward> listStockOutward = new ArrayList<StockOutward>();
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listStockOutward = StockOutwardDAO.getAllStockOutward();

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listStockOutward;
	}

	@Override
	public boolean insertStockOutward(StockOutward sOutward) {
		
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = StockOutwardDAO.insertStockOutward(sOutward);
			
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
	public boolean updateStockOutward(StockOutward sOutward) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = StockOutwardDAO.updateStockOutward(sOutward);
			
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
	public boolean deleteStockOutward(StockOutward sOutward) {
		
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = StockOutwardDAO.deleteStockOutward(sOutward);
			
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
	public int getMaxStockOutID() {
		int result = 0;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = StockOutwardDAO.getMaxStockOutID();
			
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
}
