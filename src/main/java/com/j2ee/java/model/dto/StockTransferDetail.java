/**
 * 
 */
package com.j2ee.java.model.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * @author John Tran
 *
 */
@Component
public class StockTransferDetail {
	private int stockTrDetailID;
	private int productID;
	private int fromStock;
	private int toStock;
	private int number;
	private BigDecimal price;
	private BigDecimal amount;
	/**
	 * 
	 */
	public StockTransferDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param stockTrDetailID
	 * @param productID
	 * @param fromStock
	 * @param toStock
	 * @param number
	 * @param price
	 * @param amount
	 */
	public StockTransferDetail(int stockTrDetailID, int productID,
			int fromStock, int toStock, int number, BigDecimal price,
			BigDecimal amount) {
		super();
		this.stockTrDetailID = stockTrDetailID;
		this.productID = productID;
		this.fromStock = fromStock;
		this.toStock = toStock;
		this.number = number;
		this.price = price;
		this.amount = amount;
	}
	/**
	 * @return the stockTrDetailID
	 */
	public int getStockTrDetailID() {
		return stockTrDetailID;
	}
	/**
	 * @param stockTrDetailID the stockTrDetailID to set
	 */
	public void setStockTrDetailID(int stockTrDetailID) {
		this.stockTrDetailID = stockTrDetailID;
	}
	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}
	/**
	 * @return the fromStock
	 */
	public int getFromStock() {
		return fromStock;
	}
	/**
	 * @param fromStock the fromStock to set
	 */
	public void setFromStock(int fromStock) {
		this.fromStock = fromStock;
	}
	/**
	 * @return the toStock
	 */
	public int getToStock() {
		return toStock;
	}
	/**
	 * @param toStock the toStock to set
	 */
	public void setToStock(int toStock) {
		this.toStock = toStock;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
