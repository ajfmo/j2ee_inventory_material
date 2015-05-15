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
@Table(name="product_unit")
public class ProductUnit {
	
	@Id
	@GeneratedValue
	@Column(name="unitID")
	private int unitID;
	
	@Column(name="UnitName")
	private String unitName;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "unitID")
	private Set<Product> productUnitProduct = new HashSet<Product>();
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
	public ProductUnit(String unitName, String description) {
		super();
		this.unitName = unitName;
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
	public String getUnitName() {
		return unitName;
	}
	/**
	 * @param name the name to set
	 */
	public void setUnitName(String name) {
		this.unitName = name;
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

	public Set<Product> getProductUnitProduct() {
		return productUnitProduct;
	}

	public void setProductUnitProduct(Set<Product> productUnitProduct) {
		this.productUnitProduct = productUnitProduct;
	}

	
}	
