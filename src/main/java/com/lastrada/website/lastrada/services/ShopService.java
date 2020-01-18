package com.lastrada.website.lastrada.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lastrada.website.lastrada.model.CustOrder;
import com.lastrada.website.lastrada.model.OrderItem;
import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductOption;
import com.lastrada.website.lastrada.pojo.ProductPOJO;
import com.lastrada.website.lastrada.repository.CustOrderRepository;
import com.lastrada.website.lastrada.repository.OrderItemRepository;
import com.lastrada.website.lastrada.repository.ProductAdditionRepository;
import com.lastrada.website.lastrada.repository.ProductOptionRepository;
import com.lastrada.website.lastrada.repository.ProductRepository;

@Service
public class ShopService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductOptionRepository productOptionRepository;
	
	@Autowired
	private ProductAdditionRepository productAdditionRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CustOrderRepository customerOrderRepository;
	
	public List<Product> fetchAllItems() {
	return (List<Product>) productRepository.findAll();
	}
	
	public void saveProduct(Product product) {
		this.productRepository.save(product);
	}
	
	public void saveCustomerOrder(CustOrder customerOrder) {
		for(OrderItem orderItem : customerOrder.getOrder()) {
			
			this.orderItemRepository.save(orderItem);
		}
		this.customerOrderRepository.save(customerOrder);
	}

	public void saveProductOption(ProductOption productOption) {
		this.productOptionRepository.save(productOption);
		
	}
	
	public void saveProductAddition(ProductAddition productAddition) {
		this.productAdditionRepository.save(productAddition);
		
	}
	

	
	
}
