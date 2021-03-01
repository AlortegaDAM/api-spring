package com.vinilo.apispring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinilo.apispring.exceptions.RecordNotFoundException;
import com.vinilo.apispring.model.Order;
import com.vinilo.apispring.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderServiceController {
	
	@Autowired
	OrderService service;
	
	 @GetMapping
	    public ResponseEntity<List<Order>> getAllOrder() {
	        List<Order> list = service.getAllOrder();

	        return new ResponseEntity<List<Order>>(list, new HttpHeaders(), HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) throws RecordNotFoundException {
	    	Order entity = service.getOrderById(id);

	        return new ResponseEntity<Order>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	   

	    @PostMapping
	    public ResponseEntity<Order> createOrder(@Validated @RequestBody Order myOrder) {
	    	Order entity = service.createOrder(myOrder);

	        return new ResponseEntity<Order>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

	    @PutMapping
	    public ResponseEntity<Order> updateOrder(@Validated @RequestBody Order myOrder) throws RecordNotFoundException {
	    	Order entity = service.updateOrder(myOrder);

	        return new ResponseEntity<Order>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public HttpStatus deleteOrderById(@PathVariable("id") Long id) throws RecordNotFoundException {
	        service.deleteOrderById(id);

	        return HttpStatus.ACCEPTED;
	    }

}
