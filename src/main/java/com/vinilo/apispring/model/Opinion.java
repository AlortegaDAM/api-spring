package com.vinilo.apispring.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="opinion")
public class Opinion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="image")
    private String image;
	
	@Column(name="description")
    private String description;
    
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_user")
    private User user;
    
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "id_product")
    private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Opinion [id=" + id + ", image=" + image + ", description=" + description + ", user=" + user.getName()
				+ ", product=" + product.getName() + "]";
	}
	
	

}
