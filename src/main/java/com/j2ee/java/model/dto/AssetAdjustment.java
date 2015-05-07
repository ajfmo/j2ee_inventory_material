/**
 * 
 */
package com.j2ee.java.model.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;


/**
 * @author John Tran
 *
 */
@Component
public class AssetAdjustment {
	private int assetAdjustID;
	private int assetNumber;
	private int assetID;
	private String state;
	private Date date;
	private boolean isValid;
	/**
	 * 
	 */
	public AssetAdjustment() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param assetAdjustID
	 * @param assetNumber
	 * @param assetID
	 * @param state
	 * @param date
	 * @param isValid
	 */
	public AssetAdjustment(int assetAdjustID, int assetNumber, int assetID,
			String state, java.sql.Date date, boolean isValid) {
		super();
		this.assetAdjustID = assetAdjustID;
		this.assetNumber = assetNumber;
		this.assetID = assetID;
		this.state = state;
		this.date = date;
		this.isValid = isValid;
	}
	/**
	 * @return the assetAdjustID
	 */
	public int getAssetAdjustID() {
		return assetAdjustID;
	}
	/**
	 * @param assetAdjustID the assetAdjustID to set
	 */
	public void setAssetAdjustID(int assetAdjustID) {
		this.assetAdjustID = assetAdjustID;
	}
	/**
	 * @return the assetNumber
	 */
	public int getAssetNumber() {
		return assetNumber;
	}
	/**
	 * @param assetNumber the assetNumber to set
	 */
	public void setAssetNumber(int assetNumber) {
		this.assetNumber = assetNumber;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
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
	 * @return the isValid
	 */
	public boolean isValid() {
		return isValid;
	}
	/**
	 * @param isValid the isValid to set
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
}
