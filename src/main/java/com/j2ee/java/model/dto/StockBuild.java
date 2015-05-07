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
public class StockBuild {
	private int buildID;
	private int productID;
	private int refTypeID;
	private int staffID;
	private BigDecimal totalAmount;
	private int totalQuantity;
	private String reason;
	private Date buildDate;
	/**
	 * 
	 */
	public StockBuild() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param buildID
	 * @param productID
	 * @param refTypeID
	 * @param staffID
	 * @param totalAmount
	 * @param totalQuantity
	 * @param reason
	 * @param buildDate
	 */
	public StockBuild(int buildID, int productID, int refTypeID, int staffID,
			BigDecimal totalAmount, int totalQuantity, String reason,
			Date buildDate) {
		super();
		this.buildID = buildID;
		this.productID = productID;
		this.refTypeID = refTypeID;
		this.staffID = staffID;
		this.totalAmount = totalAmount;
		this.totalQuantity = totalQuantity;
		this.reason = reason;
		this.buildDate = buildDate;
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
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}
	/**
	 * @return the refTypeID
	 */
	public int getRefTypeID() {
		return refTypeID;
	}
	/**
	 * @param refTypeID the refTypeID to set
	 */
	public void setRefTypeID(int refTypeID) {
		this.refTypeID = refTypeID;
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
	 * @return the buildDate
	 */
	public Date getBuildDate() {
		return buildDate;
	}
	/**
	 * @param buildDate the buildDate to set
	 */
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	
}		
