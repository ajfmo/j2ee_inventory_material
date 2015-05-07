/**
 * 
 */
package com.j2ee.java.model.dto;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * @author John Tran
 *
 */
@Component
public class StockInventory {
	private int inventoryID;
	private int refID;
	private Date date;
	private int productID;
	private int stockID;
	private int quantity;
	private BigDecimal price;
	private BigDecimal amount;
	/**
	 * 
	 */
	public StockInventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param inventoryID
	 * @param refID
	 * @param date
	 * @param productID
	 * @param stockID
	 * @param quantity
	 * @param price
	 * @param amount
	 */
	public StockInventory(int inventoryID, int refID, Date date, int productID,
			int stockID, int quantity, BigDecimal price, BigDecimal amount) {
		super();
		this.inventoryID = inventoryID;
		this.refID = refID;
		this.date = date;
		this.productID = productID;
		this.stockID = stockID;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}
	/**
	 * @return the inventoryID
	 */
	public int getInventoryID() {
		return inventoryID;
	}
	/**
	 * @param inventoryID the inventoryID to set
	 */
	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}
	/**
	 * @return the refID
	 */
	public int getRefID() {
		return refID;
	}
	/**
	 * @param refID the refID to set
	 */
	public void setRefID(int refID) {
		this.refID = refID;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
