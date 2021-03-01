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
import com.vinilo.apispring.model.Opinion;
import com.vinilo.apispring.model.Order;
import com.vinilo.apispring.services.OpinionService;


@RestController
@RequestMapping("/opinion")
public class OpinionServiceController {
	
	 @Autowired
	    OpinionService service;

	    @GetMapping
	    public ResponseEntity<List<Opinion>> getAllOpinion() {
	        List<Opinion> list = service.getAllOpinion();

	        return new ResponseEntity<List<Opinion>>(list, new HttpHeaders(), HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Opinion> getOpinionById(@PathVariable("id") Long id) throws RecordNotFoundException {
	    	Opinion entity = service.getOpinionById(id);

	        return new ResponseEntity<Opinion>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	    
	    @GetMapping("/product/{id}")
	    public ResponseEntity<List<Opinion>> getOpinionByProduct(@PathVariable("id") Long id){
	        List<Opinion> list = service.getOpinionByProduct(id);
	        
	        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	   

	    @PostMapping
	    public ResponseEntity<Opinion> createOpinion(@Validated @RequestBody Opinion myOpinion) {
	    	Opinion entity = service.createOpinion(myOpinion);

	        return new ResponseEntity<Opinion>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

	    @PutMapping
	    public ResponseEntity<Opinion> updateOpinion(@Validated @RequestBody Opinion myOpinion) throws RecordNotFoundException {
	    	Opinion entity = service.updateOpinion(myOpinion);

	        return new ResponseEntity<Opinion>(entity, new HttpHeaders(), HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public HttpStatus deleteOpinionById(@PathVariable("id") Long id) throws RecordNotFoundException {
	        service.deleteOpinionById(id);

	        return HttpStatus.ACCEPTED;
	    }

}
