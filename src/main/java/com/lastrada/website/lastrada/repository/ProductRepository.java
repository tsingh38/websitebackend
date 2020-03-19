package com.lastrada.website.lastrada.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lastrada.website.lastrada.model.OrderStatus;
import com.lastrada.website.lastrada.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	
	@Query( value = "SELECT * FROM product p WHERE p.product_category = 'Pizza' LIMIT 1", nativeQuery = true)
	Product findOnePizza();
	
	@Query( value = "SELECT * FROM product p WHERE p.product_category = 'Calzone' LIMIT 1", nativeQuery = true)
	Product findOneCalzone();
	
	@Query( value = "SELECT * FROM product p WHERE p.product_category = 'Rösti' LIMIT 1", nativeQuery = true)
	Product findOneRösti();
}
