package com.vinilo.apispring.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="order_buy")
public class Order {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name="date")
	private Date date;
		
	@Column(name="description")
	private String description;
	
	@JsonIgnoreProperties("user_orders")
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_user")
    private User user;
	
	@JsonIgnoreProperties("product_orders")
	@JoinTable(
	        name = "order_product",
	        joinColumns = @JoinColumn(name = "id_order"),
	        inverseJoinColumns = @JoinColumn(name="id_product")
	    )
	@ManyToMany(cascade = CascadeType.MERGE)
    private List<Product> products;
   


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if(user!=null)
		this.user = user;
		
		
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		
		this.products = products;
	}

	public void addProduct(Product product){
        if(this.products == null){
            this.products = new ArrayList<>();
        }
        
        this.products.add(product);
    }

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", description=" + description + ", user=" + user.getName() + ", products="
				+ products + "]";
	}
	
}
