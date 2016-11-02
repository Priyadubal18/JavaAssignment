import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	try {
		FileInputStream fin = new FileInputStream("E:/Consultant/Assignments/Assignment4IOThread/Hotel.jpg");
		FileOutputStream foutb = new FileOutputStream("E:/Consultant/Assignments/Assignment4IOThread/b.jpg");
		FileOutputStream foutc = new FileOutputStream("E:/Consultant/Assignments/Assignment4IOThread/c.jpg");
		FileOutputStream foutd = new FileOutputStream("E:/Consultant/Assignments/Assignment4IOThread/d.jpg");
		
		int x;
		
		long t1= System.currentTimeMillis();
		while((x = fin.read())!= -1	){
			foutb.write(x);
			foutc.write(x);
			foutd.write(x);
			
		}// end while
		long t2= System.currentTimeMillis();
		foutb.flush();
		foutb.close();
		foutc.flush();
		foutc.close();
		foutd.flush();
		foutd.close();
		fin.close();
		System.out.println("The total time to write 3 sequentially file:" + (t2-t1)/1000+ "secs");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	

	}

}
