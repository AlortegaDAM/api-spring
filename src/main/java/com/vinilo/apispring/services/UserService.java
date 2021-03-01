package com.vinilo.apispring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinilo.apispring.exceptions.RecordNotFoundException;
import com.vinilo.apispring.model.User;
import com.vinilo.apispring.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
    UserRepository repository;
    public List<User> getAllUser(){
    	
        List<User> userList = repository.findAll();    
        if(userList.size() > 0){
            return userList;
        } else {
            return new ArrayList<User>();
        }
    }
    
    public User getUserById(Long id) throws RecordNotFoundException{
    	
        Optional<User> user = repository.findById(id);
        
        if(user.isPresent()){
            return user.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id", id);
        }
    }
    
    public User createUser(User entity){
        entity = repository.save(entity);
        return entity;
    }
    
    public User updateUser(User entity) throws RecordNotFoundException{
    	
        if(entity.getId()!=null){
        	
            Optional<User> user = repository.findById(entity.getId());
            
            if(user.isPresent()){
                User newEntity = user.get();
                newEntity.setName(entity.getName());
                newEntity.setDirection(entity.getDirection());
                newEntity.setEmail(entity.getEmail());
                newEntity.setAvatar(entity.getAvatar());
                newEntity.setOpinions(entity.getOpinions());
                newEntity.setOrders(entity.getOrders());
                newEntity = repository.save(newEntity);
                
                return newEntity;
            } else {
                throw  new RecordNotFoundException("User not found", entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No id of user given", 0l);
        }
    }
    
    public void deleteUserById(Long id) throws RecordNotFoundException{
        Optional<User> user = repository.findById(id);
        if(user.isPresent()){
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No user record exist for given id", id);
        }
    }

}
