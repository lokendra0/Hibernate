package com.src.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	   @Column(nullable = false)
	   private String name;

	   @Column(nullable = false)
	   private double price;

	   // Default constructor (required by JPA)
	   public Product() {}

	   // Constructor with fields
	   public Product(String name, double price) {
	       this.name = name;
	       this.price = price;
	   }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	   @Override
	   public String toString() {
	       return "Product{" +
	               "id=" + id +
	               ", name='" + name + '\'' +
	               ", price=" + price +
	               '}';
	   }

}
