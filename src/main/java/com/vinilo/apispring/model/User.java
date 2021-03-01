package com.vinilo.apispring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="email")
    private String email;
    
    @Column(name="avatar")
    private String avatar;
    
    @Column(name="direction")
    private String direction;
    
    @OneToMany(mappedBy = "user" , cascade = {CascadeType.ALL})
    private List<Opinion> opinions;
    
    @OneToMany(mappedBy = "user" , cascade = {CascadeType.ALL})
    private List<Order> orders;
    
    public void addOpinion(Opinion opinion){
        if(this.opinions == null){
            this.opinions = new ArrayList<>();
        }
        
        this.opinions.add(opinion);
    }

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", avatar=" + avatar + ", direction="
				+ direction + ", opinions=" + opinions + ", orders=" + orders + "]";
	}

    
    

}
