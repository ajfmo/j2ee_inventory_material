/**
 * 
 */
package com.j2ee.java.model.bo;

import java.util.List;

import com.j2ee.java.model.dto.StockTransfer;

/**
 * @author John Tran
 *
 */
public interface StockTransferBO {
	
	public int getPriorityID(String priority);
	
	public StockTransfer getByID(int id);
	
	public List<StockTransfer> getAllStockInward();

	public boolean insertStockInward(StockTransfer stockTransfer);

	public boolean updateStockInward(StockTransfer stockTransfer);

	public boolean deleteStockInward(StockTransfer stockTransfer);
}
