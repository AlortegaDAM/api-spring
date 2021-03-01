package com.vinilo.apispring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinilo.apispring.exceptions.RecordNotFoundException;
import com.vinilo.apispring.model.Opinion;
import com.vinilo.apispring.repositories.OpinionRepository;

@Service
public class OpinionService {
	
	@Autowired
	OpinionRepository repository;
public List<Opinion> getAllOpinion(){
    	
        List<Opinion> opinionList = repository.findAll();    
        if(opinionList.size() > 0){
            return opinionList;
        } else {
            return new ArrayList<Opinion>();
        }
    }
    
    public Opinion getOpinionById(Long id) throws RecordNotFoundException{
    	
        Optional<Opinion> opinion = repository.findById(id);
        
        if(opinion.isPresent()){
            return opinion.get();
        } else {
            throw new RecordNotFoundException("No opinion record exist for given id", id);
        }
    }
    
    public Opinion createOpinion(Opinion entity){
        entity = repository.save(entity);
        return entity;
    }
    
    public Opinion updateOpinion(Opinion entity) throws RecordNotFoundException{
    	
        if(entity.getId()!=null){
        	
            Optional<Opinion> opinion = repository.findById(entity.getId());
            
            if(opinion.isPresent()){
            	Opinion newEntity = opinion.get();
                newEntity.setDescription(entity.getDescription());
                newEntity.setImage(entity.getImage());
                newEntity.setProduct(entity.getProduct());
                newEntity.setUser(entity.getUser());
                
                newEntity = repository.save(newEntity);
                
                return newEntity;
            } else {
                throw  new RecordNotFoundException("Opinion not found", entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No id of opinion given", 0l);
        }
    }
    
    public void deleteOpinionById(Long id) throws RecordNotFoundException{
        Optional<Opinion> opinion = repository.findById(id);
        if(opinion.isPresent()){
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No opinion record exist for given id", id);
        }
    }
    
    public List<Opinion>getOpinionByProduct(Long id){
    	List<Opinion> opinion = repository.getOpinionByProduct(id);
        
    	if(opinion.size() > 0){
    		return opinion;
    	}else{
    		return new ArrayList<Opinion>();
    	}
    	
    }

}
