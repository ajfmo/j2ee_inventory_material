package com.j2ee.java.model.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class InventoryReport {
	private int reportID;
	private int staffID;
	private Date date;
	private String reason;
	/**
	 * 
	 */
	public InventoryReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param reportID
	 * @param staffID
	 * @param date
	 * @param reason
	 */
	public InventoryReport(int reportID, int staffID, Date date, String reason) {
		super();
		this.reportID = reportID;
		this.staffID = staffID;
		this.date = date;
		this.reason = reason;
	}
	/**
	 * @return the reportID
	 */
	public int getReportID() {
		return reportID;
	}
	/**
	 * @param reportID the reportID to set
	 */
	public void setReportID(int reportID) {
		this.reportID = reportID;
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
	
}
