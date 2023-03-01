package com.Service;

public interface Service {

	void addCustomer();

	void addProducts();

	void showCustomer();

	void showSpecificCustomer();

	void showproducts();

	void showSpecificProductUsingCustomerID();

	void updateCustomer();

	void updateProductUsingCustomerID();

	void deleteCustomer();

	void deleteProductsUsingCustomerID();
	
	void deletSpecificCustomer();
	
	void deleteSpecificProductUsingCustomerID();

}
