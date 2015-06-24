/**
 * 
 */
package com.j2ee.java.model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.j2ee.java.model.dto.StockInventory;
import com.j2ee.java.model.dto.StockInward;

/**
 * @author John Tran
 *
 */
@Component(value = "StockInventoryDAOImpl")
public class StockInventoryDAOImpl implements StockInventoryDAO {

	static Logger logger = Logger.getLogger(StockInventoryDAOImpl.class.getName());
	/* (non-Javadoc)
	 * @see com.j2ee.java.model.dao.StockInventoryDAO#getByID(int)
	 */
	@Override
	public StockInventory getByID(int id) {

		return (StockInventory) HibernateUtil.getSessionFactory()
				.getCurrentSession().get(StockInventory.class, id);
	}

	/* (non-Javadoc)
	 * @see com.j2ee.java.model.dao.StockInventoryDAO#getAllStockInventory()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StockInventory> getAllStockInventory() {

		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from StockInventory").list();
	}

	/* (non-Javadoc)
	 * @see com.j2ee.java.model.dao.StockInventoryDAO#insertStockInventory(com.j2ee.java.model.dto.StockInventory)
	 */
	@Override
	public boolean insertStockInventory(StockInventory stockInventory) {

		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.save(stockInventory);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save stockInventory");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.j2ee.java.model.dao.StockInventoryDAO#updateStockInventory(com.j2ee.java.model.dto.StockInventory)
	 */
	@Override
	public boolean updateStockInventory(StockInventory stockInventory) {

		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.update(stockInventory);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update stockInventory");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.j2ee.java.model.dao.StockInventoryDAO#deleteStockInventory(com.j2ee.java.model.dto.StockInventory)
	 */
	@Override
	public boolean deleteStockInventory(StockInventory stockInventory) {

		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.delete(stockInventory);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete stockInventory");
		}
		return result;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<StockInventory> getStockInventoryByProductAndStock(int productID, int stockID) {

		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from StockInventory si where si.productID = :proID and si.stockID = :stID")
				.setInteger("proID", productID)
				.setInteger("stID", stockID)
				.list();
	}


}
