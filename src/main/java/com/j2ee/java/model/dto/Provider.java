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
public class Provider {
	
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
	public Provider(int providerID, String name, String adrress, String tel,
			String email, String website, String description) {
		super();
		this.providerID = providerID;
		this.name = name;
		this.adrress = adrress;
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
	 * @return the adrress
	 */
	public String getAdrress() {
		return adrress;
	}
	/**
	 * @param adrress the adrress to set
	 */
	public void setAdrress(String adrress) {
		this.adrress = adrress;
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
	
	
	
	private int providerID;
	private String name;
	private String adrress;
	private String tel;
	private String email;
	private String website;
	private String description;
}
