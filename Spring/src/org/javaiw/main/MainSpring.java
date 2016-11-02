package org.javaiw.main;

import org.javaiw.model.Product;
import org.javaiw.model.Vendor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Product p1= (Product)context.getBean("product1");
		p1.setPname("babu");
		p1.getPname();
		Vendor v1 = (Vendor)context.getBean("vendors");
	    v1.setName("ssss");
		System.out.println(p1);
	}

}
