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
@Table(name="provider")
public class Provider {
	
	@Id
	@GeneratedValue
	@Column(name="ProviderID")
	private int providerID;
	
	@Column(name="ProviderName")
	private String providerName;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Tel")
	private String tel;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Website")
	private String website;
	
	@Column(name="Description")
	private String description;
	
	@OneToMany(mappedBy = "providerID")
	private Set<StockInward> providerStockInward = new HashSet<StockInward>();
	
	@OneToMany(mappedBy = "providerID")
	private Set<Product> providerProduct = new HashSet<Product>();
	/**
	 * 
	 */
	public Provider() {
		super();
	}
	
	
	/**
	 * @param providerID
	 * @param name
	 * @param adrress
	 * @param tel
	 * @param email
	 * @param website
	 * @param description
	 */
	public Provider(String name, String adrress, String tel,
			String email, String website, String description) {
		super();
		this.providerName = name;
		this.address = adrress;
		this.tel = tel;
		this.email = email;
		this.website = website;
		this.description = description;
	}


	/**
	 * @return the providerID
	 */
	public int getProviderID() {
		return providerID;
	}
	/**
	 * @param providerID the providerID to set
	 */
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	/**
	 * @return the name
	 */
	public String getProviderName() {
		return providerName;
	}
	/**
	 * @param name the name to set
	 */
	public void setProviderName(String name) {
		this.providerName = name;
	}
	/**
	 * @return the adrress
	 */
	public String getAdrress() {
		return address;
	}
	/**
	 * @param adrress the adrress to set
	 */
	public void setAdrress(String adrress) {
		this.address = adrress;
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
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
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


	public Set<StockInward> getProviderStockInward() {
		return providerStockInward;
	}


	public void setProviderStockInward(Set<StockInward> providerStockInward) {
		this.providerStockInward = providerStockInward;
	}


	public Set<Product> getProviderProduct() {
		return providerProduct;
	}


	public void setProviderProduct(Set<Product> providerProduct) {
		this.providerProduct = providerProduct;
	}

	@Override
	public String toString() {
		return "Provider [providerID=" + providerID + ", providerName="
				+ providerName + ", address=" + address + ", tel=" + tel
				+ ", email=" + email + ", website=" + website
				+ ", description=" + description + ", providerStockInward="
				+ providerStockInward + ", providerProduct=" + providerProduct
				+ "]";
	}
	
}
