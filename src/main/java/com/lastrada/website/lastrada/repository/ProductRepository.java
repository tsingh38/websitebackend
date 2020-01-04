package com.lastrada.website.lastrada.repository;

import org.springframework.data.repository.CrudRepository;

import com.lastrada.website.lastrada.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
