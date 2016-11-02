package org.jawaiw.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductData {
	
	Connection con;
	PreparedStatement ps1, ps2, ps3, ps4, ps5;	

	public ProductData() {
		
	}
	
	public  void setconnection(){
		try{			
			Class.forName("oracle.jdbc.OracleDriver");
		}
		catch(ClassNotFoundException e){e.printStackTrace();}
		try{
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priya", "raj1283");
			 ps1= con.prepareStatement("insert into product values(?, ?, ?, ?)");
			 ps2 = con.prepareStatement("select * from product where pid=? ");			
			 ps4 = con.prepareStatement("delete from product where pid=?");
	
		
	}catch(SQLException e){e.printStackTrace();}
	
	}
	
	public boolean insertvalues(String pid , String pname, String price, String brand ) {
		try{
			
			
			ps1.setInt(1, Integer.parseInt(pid));
			ps1.setString(2, pname);
			ps1.setDouble(3, Double.parseDouble(price));
			ps1.setString(4, brand);
			ps1.execute();
			return true;
			
			}
		catch(SQLException ee){ee.printStackTrace();
		return false;
		}		
		
	} // add  product 
	
	public  boolean deletevalues(int pid){
		try {
			
			ps4.setInt(1, pid);
			ps4.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	} // delete products
	
 
	public ArrayList<Product> getProduct(int  pid){
		ResultSet rs;
		ArrayList<Product> al = new ArrayList<Product>();
		Product s= new Product();
		try {
			
			ps2.setInt(1, pid);
			rs = ps2.executeQuery();
			while(rs.next()){
				 s.pid= rs.getInt(1);
				 s.productname = rs.getString(2);
			     s.price = rs.getDouble(3);
			     s.brand = rs.getString(4);
			     al.add(s);				
			    
			} }catch (SQLException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			
			}
		    return al;
		
		
	}
	
}
