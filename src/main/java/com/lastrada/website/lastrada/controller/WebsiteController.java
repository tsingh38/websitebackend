package com.lastrada.website.lastrada.controller;

import com.lastrada.website.lastrada.JWTUtil;
import com.lastrada.website.lastrada.MyUserDetailsService;
import com.lastrada.website.lastrada.model.AuthenticationRequest;
import com.lastrada.website.lastrada.model.AuthenticationResponse;
import com.lastrada.website.lastrada.model.Credentials;
import com.lastrada.website.lastrada.model.CredentialsHolder;
import com.lastrada.website.lastrada.model.CustOrder;
import com.lastrada.website.lastrada.model.OrderStatus;
import com.lastrada.website.lastrada.model.Product;
import com.lastrada.website.lastrada.model.ProductAddition;
import com.lastrada.website.lastrada.model.ProductOption;
import com.lastrada.website.lastrada.model.User;
import com.lastrada.website.lastrada.model.WebsiteStatus;
import com.lastrada.website.lastrada.repository.WebsiteStatusRepository;
import com.lastrada.website.lastrada.services.ShopService;

import java.util.List;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WebsiteController {

	@Autowired
	private ShopService shopService;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	
	private WebsiteStatusRepository websiteStatus;
	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/allitems")
	public List<Product> fetchAllItems() {
		return shopService.fetchAllItems();
	}

	
	@RequestMapping(value = "/authenticate", consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticateToken( AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException exception) {
			throw new Exception("Bad Credentials", exception);
		}

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}


	
	@RequestMapping(value = "/getOrders")
	public Iterable<OrderStatus> fetchOrder(@RequestHeader("CustOrderFetchMode") String custOrderFetchMode) throws Exception {
		return shopService.fetchOrders(custOrderFetchMode);
	}

	@RequestMapping(value = "/saveOrder")
	public ResponseEntity saveOrder(@RequestBody CustOrder order) {
		try {
			return shopService.saveCustomerOrder(order);
		} catch (Exception e) {
			return  new ResponseEntity<Long>(new Long(0), HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
	
	@RequestMapping(value = "/deleteProduct")
	public ResponseEntity deleteProduct(@RequestBody Product product) {
		shopService.deleteProduct(product);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/editProduct")
	public ResponseEntity editProduct(@RequestBody Product product) {
		shopService.editProduct(product);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@RequestMapping(value = "/updateWebsiteStatus")
	public ResponseEntity getWebsiteStatus(@RequestBody WebsiteStatus status) {
		shopService.updateWebsiteStatus(status);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getWebsiteStatus")
	public WebsiteStatus getWebisteStatus() {
		return shopService.getWebsiteStatus();
		
	}
	
	@RequestMapping(value = "/processChangeCredentials")
	public ResponseEntity processChangeCredentials(@RequestBody CredentialsHolder credentials) throws Exception {
		 shopService.processCredentialsChange(credentials);
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
