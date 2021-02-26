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
import com.vinilo.apispring.model.Product;
import com.vinilo.apispring.services.ProductService;


@RestController
@RequestMapping("/product")
public class ProductServiceController {
	
	 @Autowired
	    ProductService service;

	    @GetMapping
	    public ResponseEntity<List<Product>> getAllProduct() {
	        List<Product> list = service.getAllProduct();

	        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws RecordNotFoundException {
	        Product entity = service.getProductById(id);

	        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	    @GetMapping("/search/{category}")
	    public ResponseEntity<Product> getProductByCategory(@PathVariable("id") Long id) throws RecordNotFoundException {
	        Product entity = service.getProductById(id);////falta por hacer//////

	        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product myProduct) {
	        Product entity = service.createProduct(myProduct);

	        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

	    @PutMapping
	    public ResponseEntity<Product> updateProduct(@Validated @RequestBody Product myProduct) throws RecordNotFoundException {
	        Product entity = service.updateProduct(myProduct);

	        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public HttpStatus deleteProductById(@PathVariable("id") Long id) throws RecordNotFoundException {
	        service.deleteProductById(id);

	        return HttpStatus.ACCEPTED;
	    }

}
