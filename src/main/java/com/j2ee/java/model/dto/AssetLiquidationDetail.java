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
public class AssetLiquidationDetail {
	private int liDetailID;
	private int liquidID;
	private int assetID;
	private int number;
	private BigDecimal price;
	private BigDecimal amount;
	private String customer;
	/**
	 * 
	 */
	public AssetLiquidationDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param liDetailID
	 * @param liquidID
	 * @param assetID
	 * @param number
	 * @param price
	 * @param amount
	 * @param customer
	 */
	public AssetLiquidationDetail(int liDetailID, int liquidID, int assetID,
			int number, BigDecimal price, BigDecimal amount, String customer) {
		super();
		this.liDetailID = liDetailID;
		this.liquidID = liquidID;
		this.assetID = assetID;
		this.number = number;
		this.price = price;
		this.amount = amount;
		this.customer = customer;
	}
	/**
	 * @return the liDetailID
	 */
	public int getLiDetailID() {
		return liDetailID;
	}
	/**
	 * @param liDetailID the liDetailID to set
	 */
	public void setLiDetailID(int liDetailID) {
		this.liDetailID = liDetailID;
	}
	/**
	 * @return the liquidID
	 */
	public int getLiquidID() {
		return liquidID;
	}
	/**
	 * @param liquidID the liquidID to set
	 */
	public void setLiquidID(int liquidID) {
		this.liquidID = liquidID;
	}
	/**
	 * @return the assetID
	 */
	public int getAssetID() {
		return assetID;
	}
	/**
	 * @param assetID the assetID to set
	 */
	public void setAssetID(int assetID) {
		this.assetID = assetID;
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
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}
}
