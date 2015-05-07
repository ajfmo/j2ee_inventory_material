package com.j2ee.java.model.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class ProductComponent {
	private int id;
	private int componentID;
	private int productID;
	private int quantity;
	private BigDecimal price;
	private BigDecimal amount;
	/**
	 * 
	 */
	public ProductComponent() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param componentID
	 * @param productID
	 * @param quantity
	 * @param price
	 * @param amount
	 */
	public ProductComponent(int id, int componentID, int productID,
			int quantity, BigDecimal price, BigDecimal amount) {
		super();
		this.id = id;
		this.componentID = componentID;
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the componentID
	 */
	public int getComponentID() {
		return componentID;
	}
	/**
	 * @param componentID the componentID to set
	 */
	public void setComponentID(int componentID) {
		this.componentID = componentID;
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
