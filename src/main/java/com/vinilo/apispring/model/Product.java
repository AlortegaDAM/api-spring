package com.vinilo.apispring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="product_name")
    private String name;
	
	@Column(name="product_description")
    private String description;
    
    @Column(name="product_price")
    private double price;
    
    @Column(name="product_image")
    private String image;
    
    @JsonIgnoreProperties(value={"product"}, allowSetters=true)
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "product" , cascade = {CascadeType.ALL})
    private List<Opinion> opinions;
    
    @JsonIgnoreProperties(value={"products"}, allowSetters=true)
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "products" , cascade = {CascadeType.MERGE})
    private List<Order> product_orders;

	public List<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}

	public List<Order> getOrders() {
		return product_orders;
	}

	public void setOrders(List<Order> orders) {
		this.product_orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	

	
    
}
