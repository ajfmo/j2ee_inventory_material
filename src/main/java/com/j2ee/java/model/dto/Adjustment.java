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
public class Adjustment {
	private int id;
	private Date date;
	private String adjustID;
	private int refType;
	private int stockID;
	private BigDecimal TotalDiffAmount;
	private int staffID;
	private boolean accept;
	private boolean active;
	/**
	 * 
	 */
	public Adjustment() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param date
	 * @param adjustID
	 * @param refType
	 * @param stockID
	 * @param totalDiffAmount
	 * @param staffID
	 * @param accept
	 * @param active
	 */
	public Adjustment(int id, Date date, String adjustID, int refType,
			int stockID, BigDecimal totalDiffAmount, int staffID,
			boolean accept, boolean active) {
		super();
		this.id = id;
		this.date = date;
		this.adjustID = adjustID;
		this.refType = refType;
		this.stockID = stockID;
		TotalDiffAmount = totalDiffAmount;
		this.staffID = staffID;
		this.accept = accept;
		this.active = active;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the adjustID
	 */
	public String getAdjustID() {
		return adjustID;
	}
	/**
	 * @param adjustID the adjustID to set
	 */
	public void setAdjustID(String adjustID) {
		this.adjustID = adjustID;
	}
	/**
	 * @return the refType
	 */
	public int getRefType() {
		return refType;
	}
	/**
	 * @param refType the refType to set
	 */
	public void setRefType(int refType) {
		this.refType = refType;
	}
	/**
	 * @return the stockID
	 */
	public int getStockID() {
		return stockID;
	}
	/**
	 * @param stockID the stockID to set
	 */
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	/**
	 * @return the totalDiffAmount
	 */
	public BigDecimal getTotalDiffAmount() {
		return TotalDiffAmount;
	}
	/**
	 * @param totalDiffAmount the totalDiffAmount to set
	 */
	public void setTotalDiffAmount(BigDecimal totalDiffAmount) {
		TotalDiffAmount = totalDiffAmount;
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
	 * @return the accept
	 */
	public boolean isAccept() {
		return accept;
	}
	/**
	 * @param accept the accept to set
	 */
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
}
