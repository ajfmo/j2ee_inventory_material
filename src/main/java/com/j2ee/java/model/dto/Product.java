/**
 * 
 */
package com.j2ee.java.model.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;


/**
 * @author John Tran
 *
 */
@Component
public class Product {
	
	/**
	 * 
	 */
	public Product() {
		super();
	}
	/**
	 * @param productID
	 * @param productName
	 * @param typeID
	 * @param providerID
	 * @param manufactureID
	 * @param unitID
	 * @param salePrice
	 * @param orgPrice
	 * @param description
	 * @param minStock
	 * @param maxStock
	 * @param photo
	 */
	public Product(int productID, String productName, int typeID,
			int providerID, int manufactureID, int unitID, BigDecimal salePrice,
			BigDecimal orgPrice, String description, int minStock, int maxStock,
			String photo) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.typeID = typeID;
		this.providerID = providerID;
		this.manufactureID = manufactureID;
		this.unitID = unitID;
		this.salePrice = salePrice;
		this.orgPrice = orgPrice;
		this.description = description;
		this.minStock = minStock;
		this.maxStock = maxStock;
		this.photo = photo;
	}
	
	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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
	 * @return the salePrice
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * @return the orgPrice
	 */
	public BigDecimal getOrgPrice() {
		return orgPrice;
	}
	/**
	 * @param orgPrice the orgPrice to set
	 */
	public void setOrgPrice(BigDecimal orgPrice) {
		this.orgPrice = orgPrice;
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
	/**
	 * @return the minStock
	 */
	public int getMinStock() {
		return minStock;
	}
	/**
	 * @param minStock the minStock to set
	 */
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	/**
	 * @return the maxStock
	 */
	public int getMaxStock() {
		return maxStock;
	}
	/**
	 * @param maxStock the maxStock to set
	 */
	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	private int productID;
	private String productName;
	private int typeID;
	private int providerID;
	private int manufactureID;
	private int unitID;
	private BigDecimal salePrice;
	private BigDecimal orgPrice;
	private String description;
	private int minStock;
	private int maxStock;
	private String photo;
}
