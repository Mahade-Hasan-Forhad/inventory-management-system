package com.forhad.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forhad.ims.entities.Sale;
import com.forhad.ims.repos.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService {

	// add dependency
	@Autowired
	private SaleRepository repository;

	// save
	@Override
	public Sale saveSale(Sale sale) {

		return repository.save(sale);
	}

	// update
	@Override
	public Sale updateSale(Sale sale) {

		return repository.save(sale);
	}

	// delete
	@Override
	public void deleteSale(Sale sale) {
		repository.delete(sale);
	}

	// get
	@Override
	public Sale gertSaleById(long cId) {

		return repository.getById(cId);
	}

	// list of sales
	@Override
	public List<Sale> getAllSales() {

		return repository.findAll();
	}

	// getter and setters for repo
	public SaleRepository getRepository() {
		return repository;
	}

	public void setRepository(SaleRepository repository) {
		this.repository = repository;
	}

}
