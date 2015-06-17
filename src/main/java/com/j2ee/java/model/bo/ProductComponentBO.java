package com.j2ee.java.model.bo;

import java.util.List;

import com.j2ee.java.model.dto.ProductComponent;

public interface ProductComponentBO {

	public List<ProductComponent> getByID(int id);
	
	public List<ProductComponent> getAllProductComponent();
	
	public boolean insertProductComponent(ProductComponent productComponent);
	
	public boolean updateProductComponent(ProductComponent productComponent);
	
	public boolean deleteProductComponent(ProductComponent productComponent);
}
