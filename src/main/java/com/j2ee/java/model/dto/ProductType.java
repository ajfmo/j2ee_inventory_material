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
public class ProductType {
	/**
	 * 
	 */
	public ProductType() {
		super();
	}
	
	/**
	 * @param typeID
	 * @param name
	 */
	public ProductType(int typeID, String name) {
		super();
		this.typeID = typeID;
		this.name = name;
	}
	
	/**
	 * @return the typeID
	 */
	public int getTypeID() {
		return typeID;
	}
	/**
	 * @param typeID the typeID to set
	 */
	public void setTypeID(int typeID) {
		this.typeID = typeID;
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
	
	private int typeID;
	private String name;
}
