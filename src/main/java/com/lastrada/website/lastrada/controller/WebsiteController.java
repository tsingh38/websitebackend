package com.lastrada.website.lastrada.controller;

import com.lastrada.website.lastrada.model.CustOrder;
import com.lastrada.website.lastrada.model.OrderStatus;
import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductOption;
import com.lastrada.website.lastrada.model.User;
import com.lastrada.website.lastrada.services.ShopService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin 
public class WebsiteController {

	@Autowired
	private ShopService shopService;
	
	
	   @RequestMapping(value = "/allitems")
	    public  List<Product>  fetchAllItems() {
	     return shopService.fetchAllItems();
	    }
	

	
	   @GetMapping(produces="application/json")
	   @RequestMapping({"/validateLogin"})
	   public User validateLogin() {
		   return new User("User successfully authenticated");
	   }
	
	
	   @RequestMapping(value = "/getOrders")
	    public  Iterable<OrderStatus>  fetchOrder(@RequestHeader("CustOrderFetchMode") String custOrderFetchMode) {
	     return shopService.fetchOrders(custOrderFetchMode);
	    }
	
	
	
	  @RequestMapping(value = "/saveOrder")
	   public Long saveOrder(@RequestBody CustOrder order) {
		  return shopService.saveCustomerOrder(order);
	   }
	
	
	  @RequestMapping(value = "/updateOrder")
	   public void updateOrder(@RequestBody OrderStatus order) {
		   shopService.updateOrder(order);
	   }
	
	   
	   @RequestMapping(value = "/saveProduct")
	   public ResponseEntity saveProduct(@RequestBody Product product) {
		   shopService.saveProduct(product);
		   return ResponseEntity.ok(HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/saveProductOption")
	   public ResponseEntity saveProductOption(@RequestBody ProductOption productOption) {
		   shopService.saveProductOption(productOption);
		   return ResponseEntity.ok(HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/saveProductAddition")
	   public ResponseEntity saveProductAddition(@RequestBody ProductAddition productAddition) {
		   shopService.saveProductAddition(productAddition);
		   return ResponseEntity.ok(HttpStatus.OK);
	   }
}
