package com.j2ee.java.model.dto;

import org.springframework.stereotype.Component;

@Component
public class Stock {
	private int stockID;
	private String stockName;
	private String address;
	private int size;
	private int managerid;
	private boolean isActive;
	private String desciption;
	/**
	 * 
	 */
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param stockID
	 * @param stockName
	 * @param address
	 * @param size
	 * @param managerid
	 * @param isActive
	 * @param desciption
	 */
	public Stock(int stockID, String stockName, String address, int size,
			int managerid, boolean isActive, String desciption) {
		super();
		this.stockID = stockID;
		this.stockName = stockName;
		this.address = address;
		this.size = size;
		this.managerid = managerid;
		this.isActive = isActive;
		this.desciption = desciption;
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
	 * @return the stockName
	 */
	public String getStockName() {
		return stockName;
	}
	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the managerid
	 */
	public int getManagerid() {
		return managerid;
	}
	/**
	 * @param managerid the managerid to set
	 */
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the desciption
	 */
	public String getDesciption() {
		return desciption;
	}
	/**
	 * @param desciption the desciption to set
	 */
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
}
