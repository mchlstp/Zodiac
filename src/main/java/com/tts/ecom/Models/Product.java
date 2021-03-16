package com.tts.ecom.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	private int quantity; 
	private float price; 
	
	private String name; 

	private String category; 
	private String image;
	private String sign;
	
	public Product(int quantity, float price, String name, String category,
			String image, String sign) {
		this.quantity = quantity;
		this.price = price;
		this.name = name;
		this.category = category;
		this.image = image;
		this.sign = sign;
	}
	public Product() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
		
	}
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", quantity=" + quantity + ", price=" + price + ", name=" + name + ", sign=" + sign + ", category=" + category + ", image=" + image + "]";
	} 
	
	
	
}