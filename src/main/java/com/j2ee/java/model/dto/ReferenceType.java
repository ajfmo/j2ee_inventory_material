/**
 * 
 */
package com.j2ee.java.model.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author John Tran
 *
 */
@Component
@Entity
@Table(name="reference_type")
public class ReferenceType {
	
	@Id
	@GeneratedValue
	@Column(name="RefTypeID")
	private int refTypeID;
	
	@Column(name="Name")
	private String name;
	
	@OneToMany(mappedBy = "refID")
	private Set<StockInventory> refTypeStockInven = new HashSet<StockInventory>();
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
	public Set<StockInventory> getRefTypeStockInven() {
		return refTypeStockInven;
	}
	public void setRefTypeStockInven(Set<StockInventory> refTypeStockInven) {
		this.refTypeStockInven = refTypeStockInven;
	}
	
}
