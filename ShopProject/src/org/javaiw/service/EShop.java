package org.javaiw.service;
import java.util.ArrayList;
import javax.jws.WebService;
import org.jawaiw.model.Product;
import org.jawaiw.model.ProductData;

@WebService(endpointInterface = "org.javaiw.service.ProductIntf" )

public class EShop implements ProductIntf{	


	ProductData  data = new ProductData();
	
	@Override
	public ArrayList<Product> getProduct(int pid){
		data.setconnection();
		return data.getProduct(pid);			
		
	}
	@Override
	public  boolean deletevalues(int pid){
	data.setconnection();
	return data.deletevalues(pid);
	}
	
	
	@Override
	public boolean insertvalues(String pid, String pname, String price, String brand) {
		// TODO Auto-generated method stub
	data.setconnection();
	return (data.insertvalues(pid, pname, price, brand));
	}
	
 
}
