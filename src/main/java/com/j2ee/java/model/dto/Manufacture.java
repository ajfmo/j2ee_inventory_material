/**
 * 
 */
package com.j2ee.java.model.dto;

import org.springframework.stereotype.Component;

/**
 * @author John Tran
 *
 */
@Component
public class Manufacture {
	
	/**
	 * 
	 */
	public Manufacture() {
		super();
	}
	
	/**
	 * @param manufactureID
	 * @param name
	 * @param address
	 * @param tel
	 * @param description
	 */
	public Manufacture(int manufactureID, String name, String address,
			String tel, String description) {
		super();
		this.manufactureID = manufactureID;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.description = description;
	}

	/**
	 * @return the manufactureID
	 */
	public int getManufactureID() {
		return manufactureID;
	}
	/**
	 * @param manufactureID the manufactureID to set
	 */
	public void setManufactureID(int manufactureID) {
		this.manufactureID = manufactureID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	private int manufactureID;
	private String name;
	private String address;
	private String tel;
	private String description;
}
