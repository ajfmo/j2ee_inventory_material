package com.j2ee.java.model.bo;

import java.util.List;

import com.j2ee.java.model.dto.StockInward;

public interface StockInwardBO {

	public StockInward getByID(int id);

	public List<StockInward> getAllStockInward();

	public boolean insertStockInward(StockInward stockInward);

	public boolean updateStockInward(StockInward stockInward);

	public boolean deleteStockInward(StockInward stockInward);
}
