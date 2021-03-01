package com.vinilo.apispring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vinilo.apispring.model.Opinion;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long>{
	
	@Query(value="select t1.id as id_product, t2.id, t2.id_user, t2.image, t2.description from ( select * from product where id = ?1 ) t1 left join ( select id, id_user, id_product, image, description from opinion ) t2 on t1.id = t2.id_product", nativeQuery=true)
	public List<Opinion>getOpinionByProduct(Long id);
}
