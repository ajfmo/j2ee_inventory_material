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
import com.j2ee.java.model.dao.StockBuildDAO;
import com.j2ee.java.model.dto.StockBuild;

@Component(value="StockBuildBOImpl")
public class StockBuildBOImpl implements StockBuildBO {

	private static final Logger logger = LoggerFactory.getLogger(StockBuildBOImpl.class);
	
	@Autowired
	@Qualifier("StockBuildDAOImpl")
	private StockBuildDAO StockBuildDAO;
	
	@Override
	public StockBuild getByID(int id) {
		
		StockBuild StockBuild = null;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			StockBuild = StockBuildDAO.getByID(id);

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return StockBuild;
	}

	@Override
	public List<StockBuild> getAllStockBuild() {
		
		List<StockBuild> listStockBuild = new ArrayList<StockBuild>();
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listStockBuild = StockBuildDAO.getAllStockBuild();

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listStockBuild;
	}

	@Override
	public boolean insertStockBuild(StockBuild stockBuild) {
		
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = StockBuildDAO.insertStockBuild(stockBuild);
			
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
	public boolean updateStockBuild(StockBuild stockBuild) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = StockBuildDAO.updateStockBuild(stockBuild);
			
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
	public boolean deleteStockBuild(StockBuild stockBuild) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = StockBuildDAO.deleteStockBuild(stockBuild);
			
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
