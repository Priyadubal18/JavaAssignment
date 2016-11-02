package FileReader;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
   int rollnofinal;
   int marksfinal ;
   String rollno, marks,sname, coursename;
   
   
  try {
	  	Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priya", "raj1283");
		PreparedStatement ps = con.prepareStatement("insert into student values(?, ?, ? ,?)");
		PreparedStatement ps1 = con.prepareStatement("delete from student");
		PreparedStatement ps2 = con.prepareStatement("select * from student");
		ResultSet rs= ps2.executeQuery();		
		FileReader fr = new FileReader("E:/Consultant/Assignments//Assignment3/data.txt");
		FileWriter fw = new FileWriter("E:/Consultant/Assignments//Assignment3/datawrite.txt", true); // to append data to text file
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		String s1;
		String []s2;
		ps1.execute();
		
					while((s1 = br.readLine()) != null)
				{
	//System.out.println(s1);			
					s2= s1.split(",");
					rollno = s2[0].trim();
					rollnofinal =Integer.parseInt(rollno);				
					sname = s2[1].trim();			  
					coursename = s2[2].trim();			 	  
					marks = s2[3].trim();
					marksfinal = Integer.parseInt(marks);					
					ps.setInt(1, rollnofinal);
					ps.setString(2, sname);
					ps.setString(3, coursename);
					ps.setInt(4, marksfinal);
					ps.execute();
					
				}// end while 1
				
					 while(rs.next()){
		            	 rollnofinal = rs.getInt(1);
		            	 sname = rs.getString(2);
		            	 coursename = rs.getString(3);
		            	 marksfinal = rs.getInt(4);
		            	 String data = rollnofinal + ", "+sname+ ", "+coursename+ ", "+ marksfinal+ " \n";
		            	 bw.write(data);
		            	 bw.newLine();
		            	  
		              }	//		
			fr.close();
			br.close();	
			bw.flush();
			bw.close();
		} 
             
  
  
  		catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
  		catch (SQLException e) {
  		// TODO Auto-generated catch block
  			e.printStackTrace();
  		}	
  		catch (IOException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
  		} 
			}
}
