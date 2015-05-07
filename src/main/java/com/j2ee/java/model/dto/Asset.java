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
public class Asset {
	private int assetID;
	private String name;
	private BigDecimal orgPrice;
	private int number;
	/**
	 * @param assetID
	 * @param name
	 * @param orgPrice
	 * @param number
	 */
	public Asset(int assetID, String name, BigDecimal orgPrice, int number) {
		super();
		this.assetID = assetID;
		this.name = name;
		this.orgPrice = orgPrice;
		this.number = number;
	}
	/**
	 * 
	 */
	public Asset() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the orgPrice
	 */
	public BigDecimal getOrgPrice() {
		return orgPrice;
	}
	/**
	 * @param orgPrice the orgPrice to set
	 */
	public void setOrgPrice(BigDecimal orgPrice) {
		this.orgPrice = orgPrice;
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
}
