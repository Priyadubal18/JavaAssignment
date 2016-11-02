package javaawt;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextField;

public class Calculator extends Frame{

	TextField t1;	
	Button b0, b1, b2, b3, b4, b5, b6, b7, b8,b9, b10, b11, b12,b13, b14, b15, b16, b17, b18;
	
	
	public Calculator(String title) throws HeadlessException {
		
		super(title);
		setLayout(null);
		
		Panel p1= new Panel();
		p1.setBounds(0, 45, 350, 40);
		p1.setBackground(Color.LIGHT_GRAY);
		t1= new TextField(36);
		t1.setBounds(10, 60, 330, 80);
		p1.add(t1);		
		
		
		b1 = new Button("1");
		b1.setBounds(20,100, 60, 60);
				
		b2 = new Button("2");
		b2.setBounds(100,100, 60, 60);
		
		b3 = new Button("3");
		b3.setBounds(180,100, 60, 60);	
		
		b13 = new Button("+");
		b13.setBounds(260,100, 60, 60);
		
		b4 = new Button("4");
		b4.setBounds(20,170, 60, 60);
		
		b5 = new Button("5");	
		b5.setBounds(100,170, 60, 60);
		
		b6 = new Button("6");
		b6.setBounds(180,170, 60, 60);
		
		b14 = new Button("-");
		b14.setBounds(260,170, 60, 60);
		
		b7 = new Button("7");
		b7.setBounds(20,240, 60, 60);
		
		b8 = new Button("8");
		b8.setBounds(100,240, 60, 60);
		
		b9 = new Button("9");
		b9.setBounds(180,240, 60, 60);
		
		b15 = new Button("*");
		b15.setBounds(260,240, 60, 60);
		
		b0 = new Button("0");
		b0.setBounds(20,310, 60, 60);
		
		b10 = new Button(".");
		b10.setBounds(100,310, 60, 60);
		
		b11 = new Button("C");
		b11.setBounds(180,310, 60, 60);
		
		b12 = new Button("/");
		b12.setBounds(260,310, 60, 60);
		
		b17 = new Button("+/-");
		b17.setBounds(20,380, 140, 60);
		
		b16 = new Button("=");
		b16.setBounds(180,380, 140, 60);
		
		add(p1);
		add(b1);
		add(b2);
		add(b3);
		add(b13);
		add(b4);
		add(b5);
		add(b6);
		add(b14);
		add(b7);
		add(b8);
		add(b9);
		add(b15);
		add(b0);
		add(b10);
		add(b11);
		add(b12);
		add(b17);
		add(b16);		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator m1 = new Calculator("Calculator");
		m1.setVisible(true);
		m1.setBackground(Color.pink);
		m1.setBounds(50, 100, 350, 465);
		
	}

}
