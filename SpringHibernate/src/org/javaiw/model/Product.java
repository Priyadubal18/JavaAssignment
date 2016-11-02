package org.javaiw.model;
import org.springframework.beans.factory.annotation.Autowired;

public class Product  {

	int productid;
	String pname;	
	String brand;
	double price;
	
	@Autowired
	Vendor vendors;
	
	String bname;
	public Product() {
		
	}
		
	public Vendor getVendors() {
		return vendors;
	}


	public void setVendors(Vendor vendors) {
		this.vendors = vendors;
	}


	public Product(int productid, String pname, String brand, double price ) {
		super();
		this.productid = productid;
		this.pname = pname;
		this.brand = brand;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", pname=" + pname + ", brand=" + brand + ", price=" + price
				+ ", vendors=" + vendors + "bean name is "+bname+ "]";
	}

	

	

	
	
}