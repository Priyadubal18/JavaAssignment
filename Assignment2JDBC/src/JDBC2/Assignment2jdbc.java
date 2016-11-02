package JDBC2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Assignment2jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		//Load driver class
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priya", "raj1283");
			PreparedStatement ps = con.prepareStatement("insert into courses values(?, ?, ? ,?)");
			PreparedStatement ps1 = con.prepareStatement("delete from courses where cid = ?");
			PreparedStatement ps2 = con.prepareStatement("select * from courses");
			while(true){
			System.out.println("1. New course \n2. Delete course \n3. Show all \n4. Exit \n Your choice");	
			int id = scan.nextInt();
			switch(id){
			case 1:
				
				System.out.println("Please enter the 3 digit course id");
				int cid = scan.nextInt();
				System.out.println("Please enter the coursename id");
				scan.nextLine();
				String coursename = scan.nextLine();
				System.out.println("Please enter the course duration");
				int duration = scan.nextInt();
				System.out.println("Please enter the course fee");
				int fee = scan.nextInt();
				ps.setInt(1, cid);
				ps.setString(2, coursename);
				ps.setInt(3, duration);
				ps.setInt(4, fee);
				ps.execute();
				System.out.println("New course added");
				
				break;
			case 2:
				
				System.out.println("Please enter the 3 digit course id");
				int cid1 = scan.nextInt();
				ps1.setInt(1, cid1);
				ps1.execute();
				System.out.println("Course deleted");
				break;
			case 3:
				System.out.println("The entire course description is");
				
				ResultSet rs= ps2.executeQuery();
				while(rs.next()){	
					
					int cid2 = rs.getInt("cid");
					String cname = rs.getString("cname");
					int duration2 = rs.getInt("duration");
					int fee2 = rs.getInt("fee");
				    System.out.println("The CID " + cid2+ " is for course name " + cname+ ". The course total duration is "+ duration2+ " hours and the fee are " + fee2+ "INR");
					
				}
				break;
			case 4:
				System.exit(0);
				
				
				
			
			
			}
				
			}// end while
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}// end main

} // end Assignment2jdbc 
