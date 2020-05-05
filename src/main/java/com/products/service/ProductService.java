package com.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.model.Products;
import com.products.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	public boolean saveProduct(Products products) {
		Products prod = productRepo.save(products);
		if (null != prod) {
			return true;
		}
		return false;
	}

	public Products updateProduct(Products products) {
		Optional<Products> oldProduct = productRepo.findByProdId(products.getProdId());
		Products p = new Products();
		if(null!= oldProduct) {
			products.setId(oldProduct.get().getId());
			p=productRepo.save(products);
		}
		return p;
	}
	public void deleteProduct(int id) {
		productRepo.deleteById(id);;
	}
	public List<Products> getAllProducts() {
		List<Products> products = (List<Products>) productRepo.findAll();
		return products;
	}

	public Optional<Products> getProduct(int id) {
		Optional<Products> prod = productRepo.findById(id);
		return prod;
	}
}