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
import com.j2ee.java.model.dao.StockInventoryDAO;
import com.j2ee.java.model.dto.Product;
import com.j2ee.java.model.dto.StockInventory;

@Component(value = "StockInventoryBOImpl")
public class StockInventoryBOImpl implements StockInventoryBO {

	private static final Logger logger = LoggerFactory
			.getLogger(StockInventoryBOImpl.class);

	@Autowired
	@Qualifier("StockInventoryDAOImpl")
	private StockInventoryDAO stockInventoryDAO;

	@Autowired
	@Qualifier("ProductBOImpl")
	private ProductBO productBO;

	@Override
	public StockInventory getByID(int id) {

		StockInventory stockInventory = null;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			stockInventory = stockInventoryDAO.getByID(id);

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return stockInventory;
	}

	@Override
	public List<StockInventory> getAllStockInventory() {

		List<StockInventory> listStockInventory = new ArrayList<StockInventory>();
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listStockInventory = stockInventoryDAO.getAllStockInventory();

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listStockInventory;
	}

	@Override
	public boolean insertStockInventory(StockInventory stockInventory) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = stockInventoryDAO.insertStockInventory(stockInventory);

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
	public boolean updateStockInventory(StockInventory stockInventory) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = stockInventoryDAO.updateStockInventory(stockInventory);

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
	public boolean deleteStockInventory(StockInventory stockInventory) {

		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = stockInventoryDAO.deleteStockInventory(stockInventory);

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
	public int checkAvailableOfProduct(StockInventory stockInventory) {

		if (stockInventory == null) {
			return 0;
		}

		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			List<StockInventory> listStockInventory = stockInventoryDAO
					.getStockInventoryByProductAndStock(stockInventory
							.getProductID().getProductID(), stockInventory
							.getStockID().getStockID());
			tx.commit();
			if (listStockInventory != null) {
				if (listStockInventory.size() > 0) {
					StockInventory stockInventoryResult = listStockInventory
							.get(0);
					if (stockInventory.getQuantity() < stockInventoryResult
							.getQuantity()) {

						// available
						// then check minStock
						Product product = productBO.getByID(stockInventory
								.getProductID().getProductID());
						if (stockInventoryResult.getQuantity()
								- stockInventory.getQuantity() >= product
									.getMinStock()) {
							return 1;
						} else {
							return -1;
						}
					} else {

						// not available
						return 0;
					}
				}
			}

		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return 0;
	}

}
