package com.vinilo.apispring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinilo.apispring.exceptions.RecordNotFoundException;
import com.vinilo.apispring.model.Product;
import com.vinilo.apispring.repositories.ProductRepository;


@Service
public class ProductService {
	
    @Autowired
    ProductRepository repository;
    
    public List<Product> getAllProduct(){
    	
        List<Product> productList = repository.findAll();    
        if(productList.size() > 0){
            return productList;
        } else {
            return new ArrayList<Product>();
        }
    }
    
    public Product getProductById(Long id) throws RecordNotFoundException{
    	
        Optional<Product> product = repository.findById(id);
        
        if(product.isPresent()){
            return product.get();
        } else {
            throw new RecordNotFoundException("No product record exist for given id", id);
        }
    }
    
    public Product createProduct(Product entity){
        entity = repository.save(entity);
        return entity;
    }
    
    public Product updateProduct(Product entity) throws RecordNotFoundException{
    	
        if(entity.getId()!=null){
        	
            Optional<Product> product = repository.findById(entity.getId());
            
            if(product.isPresent()){
                Product newEntity = product.get();
                newEntity.setName(entity.getName());
                newEntity.setPrice(entity.getPrice());
                newEntity.setDescription(entity.getDescription());
                newEntity.setImage(entity.getImage());
                newEntity.setOpinions(entity.getOpinions());
                newEntity.setOrders(entity.getOrders());;
                
                newEntity = repository.save(newEntity);
                
                return newEntity;
            } else {
                throw  new RecordNotFoundException("Product not found", entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No id of product given", 0l);
        }
    }
    
    public void deleteProductById(Long id) throws RecordNotFoundException{
        Optional<Product> product = repository.findById(id);
        if(product.isPresent()){
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No product record exist for given id", id);
        }
    }
}

