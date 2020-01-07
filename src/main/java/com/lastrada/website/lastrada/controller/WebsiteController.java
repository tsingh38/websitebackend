package com.lastrada.website.lastrada.controller;

import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductOption;
import com.lastrada.website.lastrada.pojo.ProductPOJO;
import com.lastrada.website.lastrada.services.ShopService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebsiteController {

	@Autowired
	private ShopService shopService;
	
	
	   @RequestMapping(value = "/allitems")
	    public  List<Product>  fetchAllItems() {
	     return shopService.fetchAllItems();
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
