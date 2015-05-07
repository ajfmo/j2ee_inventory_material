package com.j2ee.java.model.dto;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class StockInward {
	private int inwardID;
	private int providerID;
	private int staffID;
	private Date date;
	private String reason;
	private BigDecimal totalAmount;
	private int totalNumber;
	/**
	 * 
	 */
	public StockInward() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param inwardID
	 * @param providerID
	 * @param staffID
	 * @param date
	 * @param reason
	 * @param totalAmount
	 * @param totalNumber
	 */
	public StockInward(int inwardID, int providerID, int staffID, Date date,
			String reason, BigDecimal totalAmount, int totalNumber) {
		super();
		this.inwardID = inwardID;
		this.providerID = providerID;
		this.staffID = staffID;
		this.date = date;
		this.reason = reason;
		this.totalAmount = totalAmount;
		this.totalNumber = totalNumber;
	}
	/**
	 * @return the inwardID
	 */
	public int getInwardID() {
		return inwardID;
	}
	/**
	 * @param inwardID the inwardID to set
	 */
	public void setInwardID(int inwardID) {
		this.inwardID = inwardID;
	}
	/**
	 * @return the providerID
	 */
	public int getProviderID() {
		return providerID;
	}
	/**
	 * @param providerID the providerID to set
	 */
	public void setProviderID(int providerID) {
		this.providerID = providerID;
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
	
}
