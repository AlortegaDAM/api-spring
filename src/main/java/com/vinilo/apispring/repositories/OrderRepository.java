package com.vinilo.apispring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinilo.apispring.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
