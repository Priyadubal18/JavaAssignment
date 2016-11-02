package org.javaiw.model;

public class Vendor {

	String vemail,name;

	public Vendor(String vemail, String name) {
		super();
		this.vemail = vemail;
		this.name = name;
	}

	public Vendor() {
		//super();
	}

	public String getVemail() {
		return vemail;
	}

	public void setVemail(String vemail) {
		this.vemail = vemail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vendor [vemail=" + vemail + ", name=" + name + "]";
	}
	
	
}
