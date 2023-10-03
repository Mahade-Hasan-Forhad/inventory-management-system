package com.forhad.ims.service;

import java.util.List;

import com.forhad.ims.entities.Product;

public interface ProductService {

	// save product
	Product saveProduct(Product product);

	// update product
	Product updateProduct(Product product);

	// delete product
	void deleteProduct(Product product);

	// get product
	Product getProductById(long id);

	// list of product
	List<Product> getAllProducts();

	// find by category
	List<Product> getProductsByCategory(String category);

}