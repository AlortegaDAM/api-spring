package com.vinilo.apispring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinilo.apispring.model.Opinion;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long>{

}
