package com.products.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products.model.Products;

@Repository
public interface ProductRepository extends CrudRepository<Products, Integer>{

	Optional<Products> findByProdId(int prodId);

}
