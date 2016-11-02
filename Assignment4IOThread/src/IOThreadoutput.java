import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOThreadoutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			//FileInputStream fin = new FileInputStream("E:/Consultant/Assignments/Assignment4IOThread/Hotel.jpg");
			FileOutputStream foutb = new FileOutputStream("E:/Consultant/Assignments/Assignment4IOThread/b.jpg");
			FileOutputStream foutc = new FileOutputStream("E:/Consultant/Assignments/Assignment4IOThread/c.jpg");
			FileOutputStream foutd = new FileOutputStream("E:/Consultant/Assignments/Assignment4IOThread/d.jpg");		
			Mythread mt1 = new Mythread(foutb, "priya");	
			Mythread mt2 = new Mythread(foutc, "raj");
			Mythread mt3 = new Mythread(foutd, "smitha");		
		
		
			
		} // end try
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
}


	

