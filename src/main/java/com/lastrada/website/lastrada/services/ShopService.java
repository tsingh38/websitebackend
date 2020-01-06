package com.lastrada.website.lastrada.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.pojo.ProductPOJO;
import com.lastrada.website.lastrada.repository.ProductRepository;

@Service
public class ShopService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> fetchAllItems() {
	return (List<Product>) productRepository.findAll();
	}
	
	
	
}
