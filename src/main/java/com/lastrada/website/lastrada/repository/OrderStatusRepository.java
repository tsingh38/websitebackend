package com.lastrada.website.lastrada.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lastrada.website.lastrada.model.CustOrder;
import com.lastrada.website.lastrada.model.OrderStatus;


public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {

	
	@Query( value = "SELECT * FROM order_status o WHERE o.status = 1", nativeQuery = true)
	Collection<OrderStatus> findAllProcessedOrders();
	
	@Query( value = "SELECT * FROM order_status o WHERE o.status = 0", nativeQuery = true)
	Collection<OrderStatus> findAllNotProcessedOrders();
	
	@Query( value = "SELECT * FROM order_status o WHERE o.status = 2", nativeQuery = true)
	Collection<OrderStatus> findAllInvalidOrders();
	
	
	
}
