package com.j2ee.java.model.dto;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="product_component")
public class ProductComponent {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ComponentID")  
	private Product componentID;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductID")
	private Product productID;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="Price")
	private BigDecimal price;
	
	@Column(name="Amount")
	private BigDecimal amount;
	/**
	 * 
	 */
	public ProductComponent() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param componentID
	 * @param productID
	 * @param quantity
	 * @param price
	 * @param amount
	 */
	public ProductComponent(Product componentID, Product productID,
			int quantity, BigDecimal price, BigDecimal amount) {
		super();
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
	public Product getComponentID() {
		return componentID;
	}
	/**
	 * @param componentID the componentID to set
	 */
	public void setComponentID(Product componentID) {
		this.componentID = componentID;
	}
	/**
	 * @return the productID
	 */
	public Product getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(Product productID) {
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
