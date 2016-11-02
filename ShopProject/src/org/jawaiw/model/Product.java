package org.jawaiw.model;

public class Product {


	int pid;
	String productname;
	double price;
	String brand;
	
	public Product(){}

	public Product(int pid, String productname, double price, String brand) {
		super();
		this.pid = pid;
		this.productname = productname;
		this.price = price;
		this.brand = brand;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	
	
}
