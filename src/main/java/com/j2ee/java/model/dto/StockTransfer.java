/**
 * 
 */
package com.j2ee.java.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
 * @author John Tran
 *
 */
@Component
@Entity
@Table(name = "stock_transfer")
public class StockTransfer {
	
	@Id
	@GeneratedValue
	@Column(name = "TransferID")
	private int transferID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "StaffID")  
	private Staff staffID;

	@Column(name = "Date")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "IsTransfered")
	private boolean isTransfered;

	@Column(name = "TotalNumber")
	private int totalNumber;

	@Column(name = "TotalAmount")
	private BigDecimal totalAmount;
	/**
	 * 
	 */
	public StockTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param transferID
	 * @param staffID
	 * @param date
	 * @param isTransfered
	 * @param totalNumber
	 * @param totalAmount
	 */
	public StockTransfer(int transferID, Staff staffID, Date date,
			boolean isTransfered, int totalNumber, BigDecimal totalAmount) {
		super();
		this.transferID = transferID;
		this.staffID = staffID;
		this.date = date;
		this.isTransfered = isTransfered;
		this.totalNumber = totalNumber;
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the transferID
	 */
	public int getTransferID() {
		return transferID;
	}
	/**
	 * @param transferID the transferID to set
	 */
	public void setTransferID(int transferID) {
		this.transferID = transferID;
	}
	/**
	 * @return the staffID
	 */
	public Staff getStaffID() {
		return staffID;
	}
	/**
	 * @param staffID the staffID to set
	 */
	public void setStaffID(Staff staffID) {
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
	 * @return the isTransfered
	 */
	public boolean isTransfered() {
		return isTransfered;
	}
	/**
	 * @param isTransfered the isTransfered to set
	 */
	public void setTransfered(boolean isTransfered) {
		this.isTransfered = isTransfered;
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
	
}
