package com.vinilo.apispring.repositories;

import org.springframework.stereotype.Repository;

import com.vinilo.apispring.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
