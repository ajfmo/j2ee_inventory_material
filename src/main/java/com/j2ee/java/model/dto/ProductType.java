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
@Table(name="product_type")
public class ProductType {
	
	@Id
	@GeneratedValue
	@Column(name="typeID")
	private int typeID;
	
	@Column(name="TypeName")
	private String typeName;
	
	@OneToMany(mappedBy = "typeID")
	private transient Set<Product> productTypeProduct = new HashSet<Product>();
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
	public ProductType(String typeName) {
		super();
		this.typeName = typeName;
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
	public String getTypName() {
		return typeName;
	}
	/**
	 * @param name the name to set
	 */
	public void setTypeName(String name) {
		this.typeName = name;
	}

	public Set<Product> getProductTypeProduct() {
		return productTypeProduct;
	}

	public void setProductTypeProduct(Set<Product> productTypeProduct) {
		this.productTypeProduct = productTypeProduct;
	}

	
}
