package com.j2ee.java.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.j2ee.java.model.dto.StockInventory;

@Component(value="StockInventoryDAOImpl")
public class StockInventoryDAOImpl implements StockInventoryDAO{

	static Logger logger = Logger.getLogger(StockInventoryDAOImpl.class.getName());
	
	@Override
	public StockInventory getByID(int id) {
		
		return (StockInventory) HibernateUtil.getSessionFactory()
				.getCurrentSession().get(StockInventory.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllStockInventory() {
		String hql = "SELECT s.productID.productID, s.stockID.stockID, SUM(s.quantity) as totalQuantity"
				+ " FROM StockInventory s"
				+ " GROUP BY s.productID, s.stockID";
		Query query = HibernateUtil.getSessionFactory().getCurrentSession().createQuery(hql);
		@SuppressWarnings("rawtypes")
		List results = query.list();
		return results;
	}

	@Override
	public boolean insertStockInventory(StockInventory stockInventory) {

		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.save(stockInventory);
			result = true;
		} catch (Exception e) {
			
			logger.info("Can't save StockInward");
		}
		return result;
	}

	@Override
	public boolean updateStockInventory(StockInventory stockInventory) {

		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.update(stockInventory);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update StockInward");
		}
		return result;
	}

	@Override
	public boolean deleteStockInventory(StockInventory stockInventory) {
		// TODO Auto-generated method stub
		return false;
	}

}
