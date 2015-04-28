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
public class ProductUnit {
	
	/**
	 * 
	 */
	public ProductUnit() {
		super();
	}
	
	/**
	 * @param unitID
	 * @param name
	 * @param description
	 */
	public ProductUnit(int unitID, String name, String description) {
		super();
		this.unitID = unitID;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the unitID
	 */
	public int getUnitID() {
		return unitID;
	}
	/**
	 * @param unitID the unitID to set
	 */
	public void setUnitID(int unitID) {
		this.unitID = unitID;
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
	private int unitID;
	private String name;
	private String description;
	
}	
