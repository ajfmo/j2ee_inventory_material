/**
 * 
 */
package com.j2ee.java.model.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author John Tran
 *
 */
@Component
@Entity
@Table(name="stock_build_detail")
public class StockBuildDetail {
	
	@Id
	@GeneratedValue
	@Column(name="buildDetailID")
	private int buildDetailID;
	
	@Column(name="buildID")
	private int buildID;
	
	@Column(name="componentID")
	private int componentID;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="amount")
	private BigDecimal amount;
	/**
	 * 
	 */
	public StockBuildDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param buildDetailID
	 * @param buildID
	 * @param componentID
	 * @param quantity
	 * @param price
	 * @param amount
	 */
	public StockBuildDetail(int buildDetailID, int buildID, int componentID,
			int quantity, BigDecimal price, BigDecimal amount) {
		super();
		this.buildDetailID = buildDetailID;
		this.buildID = buildID;
		this.componentID = componentID;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}
	/**
	 * @return the buildDetailID
	 */
	public int getBuildDetailID() {
		return buildDetailID;
	}
	/**
	 * @param buildDetailID the buildDetailID to set
	 */
	public void setBuildDetailID(int buildDetailID) {
		this.buildDetailID = buildDetailID;
	}
	/**
	 * @return the buildID
	 */
	public int getBuildID() {
		return buildID;
	}
	/**
	 * @param buildID the buildID to set
	 */
	public void setBuildID(int buildID) {
		this.buildID = buildID;
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
