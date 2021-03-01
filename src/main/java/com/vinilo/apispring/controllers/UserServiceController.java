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
import com.vinilo.apispring.model.User;
import com.vinilo.apispring.services.UserService;

@RestController
@RequestMapping("/client")
public class UserServiceController {
	
	 @Autowired
	 	UserService service;
	 
	 @GetMapping
	    public ResponseEntity<List<User>> getAllUser() {
	        List<User> list = service.getAllUser();

	        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUsertById(@PathVariable("id") Long id) throws RecordNotFoundException {
	        User entity = service.getUserById(id);

	        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	    /*@GetMapping("/search/{category}")
	    public ResponseEntity<Product> getProductByCategory(@PathVariable("id") Long id) throws RecordNotFoundException {
	        Product entity = service.getProductById(id);////falta por hacer//////

	        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
	    }*/

	    @PostMapping
	    public ResponseEntity<User> createUser(@Validated @RequestBody User myProduct) {
	    	User entity = service.createUser(myProduct);

	        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

	    @PutMapping
	    public ResponseEntity<User> updateUser(@Validated @RequestBody User myProduct) throws RecordNotFoundException {
	    	User entity = service.updateUser(myProduct);

	        return new ResponseEntity<User>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public HttpStatus deleteUserById(@PathVariable("id") Long id) throws RecordNotFoundException {
	        service.deleteUserById(id);

	        return HttpStatus.ACCEPTED;
	    }
}
