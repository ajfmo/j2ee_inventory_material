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
public class StockInwardDetail {
	private int inwardDetailID;
	private int inwardID;
	private int productID;
	private int stockID;
	private int number;
	private BigDecimal price;
	private BigDecimal amount;
	/**
	 * 
	 */
	public StockInwardDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param inwardDetailID
	 * @param inwardID
	 * @param productID
	 * @param stockID
	 * @param number
	 * @param price
	 * @param amount
	 */
	public StockInwardDetail(int inwardDetailID, int inwardID, int productID,
			int stockID, int number, BigDecimal price, BigDecimal amount) {
		super();
		this.inwardDetailID = inwardDetailID;
		this.inwardID = inwardID;
		this.productID = productID;
		this.stockID = stockID;
		this.number = number;
		this.price = price;
		this.amount = amount;
	}
	/**
	 * @return the inwardDetailID
	 */
	public int getInwardDetailID() {
		return inwardDetailID;
	}
	/**
	 * @param inwardDetailID the inwardDetailID to set
	 */
	public void setInwardDetailID(int inwardDetailID) {
		this.inwardDetailID = inwardDetailID;
	}
	/**
	 * @return the inwardID
	 */
	public int getInwardID() {
		return inwardID;
	}
	/**
	 * @param inwardID the inwardID to set
	 */
	public void setInwardID(int inwardID) {
		this.inwardID = inwardID;
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
	 * @return the stockID
	 */
	public int getStockID() {
		return stockID;
	}
	/**
	 * @param stockID the stockID to set
	 */
	public void setStockID(int stockID) {
		this.stockID = stockID;
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
