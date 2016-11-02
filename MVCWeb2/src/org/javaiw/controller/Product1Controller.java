package org.javaiw.controller;
import org.javaiw.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Product1Controller {
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ModelAndView product(){
		ModelAndView mview = new ModelAndView("products", "command", new Product());
		return mview;
	}
	
	@RequestMapping(value="/addproduct", method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("attr1")Product product, ModelMap model ){
		model.addAttribute("productid",product.getProductid() );
		model.addAttribute("pname",product.getPname() );		
		model.addAttribute("price",product.getPrice() );
		return "final";
				
	}

}
