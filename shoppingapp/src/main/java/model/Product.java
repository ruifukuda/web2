package model;

import java.io.Serializable;

public class Product implements Serializable{
	private String name;
	private String price;
	private String date;
	
	public Product() {}
	public Product(String name, String price, String date) {
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

}
