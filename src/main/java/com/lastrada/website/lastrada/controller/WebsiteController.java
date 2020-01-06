package com.lastrada.website.lastrada.controller;

import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.pojo.ProductPOJO;
import com.lastrada.website.lastrada.services.ShopService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
