package org.javaiw.service;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.jawaiw.model.Product;
@WebService(name="ProductServe")
public interface ProductIntf {
	@WebMethod
	public ArrayList<Product> getProduct(int pid);
	
	@WebMethod
	public boolean deletevalues(int pid);	
	
	@WebMethod
	public boolean insertvalues(String pid, String pname, String price, String brand);
	
	

}
