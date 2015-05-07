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
public class ReferenceType {
	private int refTypeID;
	private String name;
	/**
	 * 
	 */
	public ReferenceType() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param refTypeID
	 * @param name
	 */
	public ReferenceType(int refTypeID, String name) {
		super();
		this.refTypeID = refTypeID;
		this.name = name;
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
}
