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
public class AssetReport {
	private int assetReportID;
	private Date date;
	private int staffID;
	private String reason;
	/**
	 * 
	 */
	public AssetReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param assetReportID
	 * @param date
	 * @param staffID
	 * @param reason
	 */
	public AssetReport(int assetReportID, Date date, int staffID, String reason) {
		super();
		this.assetReportID = assetReportID;
		this.date = date;
		this.staffID = staffID;
		this.reason = reason;
	}
	/**
	 * @return the assetReportID
	 */
	public int getAssetReportID() {
		return assetReportID;
	}
	/**
	 * @param assetReportID the assetReportID to set
	 */
	public void setAssetReportID(int assetReportID) {
		this.assetReportID = assetReportID;
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
