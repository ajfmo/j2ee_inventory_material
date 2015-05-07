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
public class AssetLiquidation {
	private int liquidID;
	private Date date;
	private int staffID;
	private int totalNumber;
	private BigDecimal totalAmount;
	private String reason;
	/**
	 * 
	 */
	public AssetLiquidation() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param liquidID
	 * @param date
	 * @param staffID
	 * @param totalNumber
	 * @param totalAmount
	 * @param reason
	 */
	public AssetLiquidation(int liquidID, Date date, int staffID,
			int totalNumber, BigDecimal totalAmount, String reason) {
		super();
		this.liquidID = liquidID;
		this.date = date;
		this.staffID = staffID;
		this.totalNumber = totalNumber;
		this.totalAmount = totalAmount;
		this.reason = reason;
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
	 * @return the staffID
	 */
	public int getStaffID() {
		return staffID;
	}
	/**
	 * @param staffID the staffID to set
	 */
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	/**
	 * @return the totalNumber
	 */
	public int getTotalNumber() {
		return totalNumber;
	}
	/**
	 * @param totalNumber the totalNumber to set
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
}
