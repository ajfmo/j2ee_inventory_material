package com.j2ee.java.model.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Staff {
	private int staffID;
	private String staffName;
	private Date birthday;
	private String email;
	private int identifyNum;
	private String Tel;
	private String address;
	/**
	 * 
	 */
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param staffID
	 * @param staffName
	 * @param birthday
	 * @param email
	 * @param identifyNum
	 * @param tel
	 * @param address
	 */
	public Staff(int staffID, String staffName, Date birthday, String email,
			int identifyNum, String tel, String address) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.birthday = birthday;
		this.email = email;
		this.identifyNum = identifyNum;
		Tel = tel;
		this.address = address;
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
	 * @return the staffName
	 */
	public String getStaffName() {
		return staffName;
	}
	/**
	 * @param staffName the staffName to set
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the identifyNum
	 */
	public int getIdentifyNum() {
		return identifyNum;
	}
	/**
	 * @param identifyNum the identifyNum to set
	 */
	public void setIdentifyNum(int identifyNum) {
		this.identifyNum = identifyNum;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return Tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		Tel = tel;
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
}
