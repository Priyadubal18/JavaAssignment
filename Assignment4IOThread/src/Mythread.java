import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Mythread implements Runnable {

	
	Thread t1;
	int x;	
	String name;
	FileOutputStream fout;
	
	FileInputStream fin;
	
	public Mythread(FileOutputStream fout, String name){
		super();
		this.fout = fout; 
	    //this.fin = fin;
		this.name= name;
		t1 = new Thread(this);
		t1.start();
		
	}
	
	public void run(){
		long t1= System.currentTimeMillis();
		try {
			fin = new FileInputStream("E:/Consultant/Assignments/Assignment4IOThread/Hotel.jpg");
			while((x = fin.read())!= -1	){
				fout.write(x);	
				//System.out.println(name);
			}
			fout.flush();
			fout.close();
			fin.close();
			
		long t2= System.currentTimeMillis();
		System.out.println("The total time to write 3 sequentially file:" + (t2-t1)/1000+ "secs");
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// end while
		
		
	}
	
}
