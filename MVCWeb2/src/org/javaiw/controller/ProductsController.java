package org.javaiw.controller;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductsController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHome(){
		return "start";
	}
	
	@RequestMapping ("/raj")
	public String getraj(){
		return "priya";
	}
	
}
