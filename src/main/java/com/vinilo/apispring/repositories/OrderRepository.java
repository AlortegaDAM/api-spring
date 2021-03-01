package com.vinilo.apispring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vinilo.apispring.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Query(value="select t1.id_user, t2.id_order, t2.id_product, t2.product_name, t2.product_description, t2.product_price from"
			+ "      ( select *"
			+ "        from order_buy"
			+ "       where id_user = ?1) t1 left join"
			+ "      ( select t3.id_product, t3.id_order, t4.product_name, t4.product_description, t4.product_price"
			+ "       from"
			+ "         (select *"
			+ "            from order_product) t3"
			+ "         left join"
			+ "         (select *"
			+ "            from product) t4"
			+ "         on t3.id_product = t4.id"
			+ "     ) t2 on t1.id = t2.id_order ", nativeQuery=true)
    public List<Order> getOrderByUserId(Long id);
	
	
	

}
