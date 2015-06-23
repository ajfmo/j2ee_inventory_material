package com.j2ee.java.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import com.j2ee.java.model.dto.StockTransfer;

@Component(value="StTransferDAOImpl")
public class StockTranferDAOImpl implements StockTranferDAO{

	static Logger logger = Logger.getLogger(StockTranferDAOImpl.class.getName());
	
	@Override
	public StockTransfer getByID(int id) {
		
		return (StockTransfer) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(StockTransfer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockTransfer> getAllStockTransfer() {

		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from StockTransfer").list();
	}

	@Override
	public boolean insertStockTransfer(StockTransfer stockTransfer) {

		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.save(stockTransfer);
			result = true;
		} catch (Exception e) {
			logger.info("Can't save StockTransfer");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateStockTransfer(StockTransfer stockTransfer) {

		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.update(stockTransfer);
			result = true;
		} catch (Exception e) {
			logger.info("Can't update StockTransfer");
		}
		return result;
	}

	@Override
	public boolean deleteStockTransfer(StockTransfer stockTransfer) {

		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.delete(stockTransfer);
			result = true;
		} catch (Exception e) {
			logger.info("Can't delete StockTransfer");
		}
		return result;
	}

	@Override
	public int getLastestBillID() {
		// TODO Auto-generated method stub
		return (int) HibernateUtil.getSessionFactory().getCurrentSession()
				.createSQLQuery("SELECT TransferID FROM stock_transfer ORDER BY TransferID DESC").list().get(0);
	}

}
	