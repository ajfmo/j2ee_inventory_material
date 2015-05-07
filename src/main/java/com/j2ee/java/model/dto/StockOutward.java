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
public class StockOutward {
	private int outwardID;
	private Date date;
	private String reason;
	private int customerID;
	private int staffID;
	private int totalQuantity;
	private BigDecimal totalAmount;
	/**
	 * 
	 */
	public StockOutward() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param outwardID
	 * @param date
	 * @param reason
	 * @param customerID
	 * @param staffID
	 * @param totalQuantity
	 * @param totalAmount
	 */
	public StockOutward(int outwardID, Date date, String reason,
			int customerID, int staffID, int totalQuantity,
			BigDecimal totalAmount) {
		super();
		this.outwardID = outwardID;
		this.date = date;
		this.reason = reason;
		this.customerID = customerID;
		this.staffID = staffID;
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
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
	/**
	 * @return the customerID
	 */
	public int getCustomerID() {
		return customerID;
	}
	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
	 * @return the totalQuantity
	 */
	public int getTotalQuantity() {
		return totalQuantity;
	}
	/**
	 * @param totalQuantity the totalQuantity to set
	 */
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
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
	
}
