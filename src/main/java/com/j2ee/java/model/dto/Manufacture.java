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
@Table(name="manufacture")
public class Manufacture {
	
	@Id
	@GeneratedValue
	@Column(name="manufactureID")
	private int manufactureID;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="tel")
	private String tel;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy = "manufactureID")
	private Set<Product> manufactureProduct = new HashSet<Product>();
	
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
	public Manufacture(String name, String address,
			String tel, String description) {
		super();
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

	public Set<Product> getManufactureProduct() {
		return manufactureProduct;
	}

	public void setManufactureProduct(Set<Product> manufactureProduct) {
		this.manufactureProduct = manufactureProduct;
	}
	
	
}
