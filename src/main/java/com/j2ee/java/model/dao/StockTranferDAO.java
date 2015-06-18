/**
 * 
 */
package com.j2ee.java.model.dao;

import java.util.List;

import com.j2ee.java.model.dto.StockTransfer;

/**
 * @author John Tran
 *
 */

public interface StockTranferDAO {
	
	public StockTransfer getByID(int id);

	public List<StockTransfer> getAllStockInward();

	public boolean insertStockInward(StockTransfer stockTransfer);

	public boolean updateStockInward(StockTransfer stockTransfer);

	public boolean deleteStockInward(StockTransfer stockTransfer);
}
