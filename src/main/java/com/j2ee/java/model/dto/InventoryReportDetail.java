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
public class InventoryReportDetail {
	private int id;
	private Date date;
	private int productID;
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
