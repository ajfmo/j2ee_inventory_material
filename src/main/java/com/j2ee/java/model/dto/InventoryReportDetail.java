/**
 * 
 */
package com.j2ee.java.model.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author John Tran
 *
 */
//@Component
//@Entity
//@Table(name="InventoryReportDetail")
public class InventoryReportDetail {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="productID")
	private int productID;
	
	@Column(name="number")
	private int number;
	/**
	 * 
	 */
	public InventoryReportDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param date
	 * @param productID
	 * @param number
	 */
	public InventoryReportDetail(int id, Date date, int productID, int number) {
		super();
		this.id = id;
		this.date = date;
		this.productID = productID;
		this.number = number;
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
