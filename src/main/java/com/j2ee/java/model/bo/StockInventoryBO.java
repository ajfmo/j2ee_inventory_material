package com.j2ee.java.model.bo;

import java.util.List;

import com.j2ee.java.model.dto.StockInventory;

public interface StockInventoryBO {

	public StockInventory getByID(int id);
	
	public List<Object[]> getAllStockInventory();
	
	public boolean insertStockInventory(StockInventory stockInventory);
	
	public boolean updateStockInventory(StockInventory stockInventory);
	
	public boolean deleteStockInventory(StockInventory stockInventory);
}
