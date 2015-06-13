package com.j2ee.java.model.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.j2ee.java.model.dao.HibernateUtil;
import com.j2ee.java.model.dao.StockInwardDAOImpl;
import com.j2ee.java.model.dto.StockInward;
import com.j2ee.java.model.dao.StockInwardDAO;

public class StockInwardBOImpl implements StockInwardBO {

	private static final Logger logger = LoggerFactory.getLogger(StockInwardBOImpl.class);
	
	private static StockInwardDAO stockInwardDAO = new StockInwardDAOImpl();
	@Override
	public StockInward getByID(int id) {
		
		StockInward StockInward = null;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			StockInward = stockInwardDAO.getByID(id);

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return StockInward;
	}

	@Override
	public List<StockInward> getAllStockInward() {
		
		List<StockInward> listStockInward = new ArrayList<StockInward>();
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listStockInward = stockInwardDAO.getAllStockInward();

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listStockInward;
	}

	@Override
	public boolean insertStockInward(StockInward stockInward) {
		
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = stockInwardDAO.insertStockInward(stockInward);
			
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
	public boolean updateStockInward(StockInward stockInward) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = stockInwardDAO.updateStockInward(stockInward);
			
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
	public boolean deleteStockInward(StockInward stockInward) {
		
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = stockInwardDAO.deleteStockInward(stockInward);
			
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
