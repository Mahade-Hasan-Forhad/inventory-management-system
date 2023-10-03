package com.forhad.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forhad.ims.entities.Product;
import com.forhad.ims.repos.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	// add dependency
	@Autowired
	private ProductRepository repository;

	// save
	@Override
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	// update
	@Override
	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	// delete
	@Override
	public void deleteProduct(Product product) {
		repository.delete(product);
	}

	// get
	@Override
	public Product getProductById(long id) {
		return repository.getById(id);
	}

	// return list of product
	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	// get product by category
	@Override
	public List<Product> getProductsByCategory(String category) {
		return repository.findBypCategory(category);
	}

	// crating getter and setter for repository

	public ProductRepository getRepository() {
		return repository;
	}

	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}

}
