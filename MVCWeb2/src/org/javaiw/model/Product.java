package org.javaiw.model;

public class Product {

	int productid;
	String pname;
	double price;
	
	
	public Product() {
		
	}
	
	public Product(int productid, String pname, double price) {
		super();
		this.productid = productid;
		this.pname = pname;
		this.price = price;
	}
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
