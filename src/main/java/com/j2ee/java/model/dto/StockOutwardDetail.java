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
public class StockOutwardDetail {
	private int outwardDetailID;
	private int outwardID;
	private int stockID;
	private int productID;
	private int number;
	private BigDecimal price;
	private BigDecimal amount;
	/**
	 * 
	 */
	public StockOutwardDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param outwardDetailID
	 * @param outwardID
	 * @param stockID
	 * @param productID
	 * @param number
	 * @param price
	 * @param amount
	 */
	public StockOutwardDetail(int outwardDetailID, int outwardID, int stockID,
			int productID, int number, BigDecimal price, BigDecimal amount) {
		super();
		this.outwardDetailID = outwardDetailID;
		this.outwardID = outwardID;
		this.stockID = stockID;
		this.productID = productID;
		this.number = number;
		this.price = price;
		this.amount = amount;
	}
	/**
	 * @return the outwardDetailID
	 */
	public int getOutwardDetailID() {
		return outwardDetailID;
	}
	/**
	 * @param outwardDetailID the outwardDetailID to set
	 */
	public void setOutwardDetailID(int outwardDetailID) {
		this.outwardDetailID = outwardDetailID;
	}
	/**
	 * @return the outwardID
	 */
	public int getOutwardID() {
		return outwardID;
	}
	/**
	 * @param outwardID the outwardID to set
	 */
	public void setOutwardID(int outwardID) {
		this.outwardID = outwardID;
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
