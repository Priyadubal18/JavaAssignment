package org.javaiw.main;
import org.javaiw.model.HibDaoImplementation;
import org.javaiw.model.Product;
import org.javaiw.model.Vendor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		HibDaoImplementation dao = (HibDaoImplementation)context.getBean("hibDaoImplementation");
		//dao.showAll();		
		dao.selectall();
	}

}
