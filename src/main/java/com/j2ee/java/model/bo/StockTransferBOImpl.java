/**
 * 
 */
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
import com.j2ee.java.model.dao.StockTranferDAO;
import com.j2ee.java.model.dto.StockTransfer;

/**
 * @author John Tran
 *
 */
@Component(value="StTransferBOImpl")
public class StockTransferBOImpl implements StockTransferBO {

	private static final Logger logger = LoggerFactory.getLogger(StockTransferBOImpl.class);
	
	@Autowired
	@Qualifier("StTransferDAOImpl")
	private StockTranferDAO stockTransferDAO;
	
	@Override
	public StockTransfer getByID(int id) {
		
		StockTransfer stockTransfer = null;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			stockTransfer = stockTransferDAO.getByID(id);

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return stockTransfer;
	}
	
	@Override
	public List<StockTransfer> getAllStockInward() {

		List<StockTransfer> listStockTransfer = new ArrayList<StockTransfer>();
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listStockTransfer = stockTransferDAO.getAllStockInward();

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listStockTransfer;
	}

	@Override
	public boolean insertStockInward(StockTransfer stockTransfer) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = stockTransferDAO.insertStockInward(stockTransfer);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateStockInward(StockTransfer stockTransfer) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = stockTransferDAO.updateStockInward(stockTransfer);
			
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
	public boolean deleteStockInward(StockTransfer stockTransfer) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = stockTransferDAO.deleteStockInward(stockTransfer);
			
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
	public int getPriorityID(String priority){
		
		int result = 0;
		if("Urgent".equals(priority)){
			result = 4;
		}
		if("High".equals(priority)){
			result = 3;
		}
		if("Normal".equals(priority)){
			result = 2;
		}
		if("Low".equals(priority)){
			result = 1;
		}
		
		return result;
	}

}
