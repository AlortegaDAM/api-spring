package com.vinilo.apispring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinilo.apispring.exceptions.RecordNotFoundException;
import com.vinilo.apispring.model.Order;
import com.vinilo.apispring.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
public List<Order> getAllOrder(){
    	
        List<Order> orderList = repository.findAll();    
        if(orderList.size() > 0){
            return orderList;
        } else {
            return new ArrayList<Order>();
        }
    }
    
    public Order getOrderById(Long id) throws RecordNotFoundException{
    	
        Optional<Order> order = repository.findById(id);
        
        if(order.isPresent()){
            return order.get();
        } else {
            throw new RecordNotFoundException("No order record exist for given id", id);
        }
    }
    
    public Order createOrder(Order entity){
        entity = repository.save(entity);
        return entity;
    }
    
    public Order updateOrder(Order entity) throws RecordNotFoundException{
    	
        if(entity.getId()!=null){
        	
            Optional<Order> order = repository.findById(entity.getId());
            
            if(order.isPresent()){
            	Order newEntity = order.get();
                newEntity.setDate(entity.getDate());
                newEntity.setProducts(entity.getProducts());
                newEntity.setDescription(entity.getDescription());
                newEntity.setUser(entity.getUser());
                
                
                newEntity = repository.save(newEntity);
                
                return newEntity;
            } else {
                throw  new RecordNotFoundException("Order not found", entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No id of order given", 0l);
        }
    }
    
    public void deleteOrderById(Long id) throws RecordNotFoundException{
        Optional<Order> order = repository.findById(id);
        if(order.isPresent()){
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No order record exist for given id", id);
        }
    }
    public List<Order> getOrderByUserId(Long id){
    	List<Order> order = repository.getOrderByUserId(id);
    
    	if(order.size() > 0){
    		return order;
    	}else{
    		return new ArrayList<>();
    	}
    }


}
