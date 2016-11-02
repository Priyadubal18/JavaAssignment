import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import javax.management.RuntimeErrorException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**
 * The following code outlines the basic structure for reading from a spreadsheet and writing it to an xml file. 
 * extend the program so that it performs the tasks listed below.  Make your code flexible enough to handle 
 * spreadsheets with different data sets (columns and rows).  The included project contains the libraries 
 * that you should use to read from the spreadsheet (apache poi) and create/write to the xml file (jdom2).    
 *  
 *  Program Tasks:
 *  1. Read data in from the second worksheet in the datafile1.xlsx spreadsheet
 *  2. Sort the data by the first_name field 
 *  3. Using the data from the spreadsheet, build a xml Document with jdom2 library
 *  4. Write the xml document to the dataFiles folder as a 'pretty' xml file named datafile1_output1.xml 
 *  5. Extract a list of unique area codes from the data and save to a text file named datafile1_output2.txt
 *  6. Extract the names (first and last) for each entry that has a phone number with an exchange that 
 *     starts with a number between 1 and 5 and save to a text file named datafile1_output3.txt
 *  7. Perform the same operations, with first worksheet in the datafile2.xls spreadsheet (save to files with the name datafile2_...)
 *    
 *  Notes:  Pay attention to error handling.   
 *   
 * @author selliott
 *
 */

public class Test1 {

	public static void main(String[] args) {
		
			File file = new File("E:/Consultant/New folder/JuniorProgrammerTest/dataFiles/datafile1.xlsx");
			File file2 = new File("E:/Consultant/New folder/JuniorProgrammerTest/dataFiles/datafile2.xls");
			
			FileInputStream fis, fis2;
			try {
				fis = new FileInputStream(file); 
				fis2 = new FileInputStream(file2);							
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				HSSFWorkbook wb2 = new HSSFWorkbook(fis2);
				Sheet sheet = wb.getSheet("Sheet2");
				Sheet sheet2 = wb2.getSheet("Sheet1");
				
				//get the sheet from the workbook
				int rowno = sheet.getLastRowNum() +1 ;
				int colno = sheet.getRow(0).getLastCellNum();
				int rowno2 = sheet2.getLastRowNum() +1 ;
				int colno2 = sheet2.getRow(0).getLastCellNum();
				System.out.println("Total no of row "+ rowno2+ " Total no of coloumn"+ colno2);
				//Define variables for storing data - SomeDataType is a placeholder for an appropriate variable type for storing 
				// the data pulled from the excel file.
				String[][] data = new String[rowno][colno]; 
				String[][] data2 = new String[rowno2][colno2]; 
				//iterate through the workseet
				//collect data for each cell in each row, using data in the first row as the field names
						
				for(int i=0; i<rowno; i++){
				Row row = sheet.getRow(i); 
				  for(int j=0;j<colno; j++){
					  Cell cell = row.getCell(j);	
					  if(cell == null){
						  
					  }
					  else{
					  String value = getCellValue(cell);
					  data[i][j] = value;					  
				      		}		  
					  
				  } // end of inner for loop;
					
				}// end of row for loop
										
				for(int i=0; i<rowno2; i++){				  
				 Row row2 = sheet2.getRow(i);				 
				  for(int j=0;j<colno2; j++){					  
					  Cell cell2 = row2.getCell(j);
					  if(cell2 == null){
								
					  }
					  else{
					  String value2 = getCellValue(cell2);				 
					  data2[i][j] = value2;
					// System.out.println("the value is "+value2); 
					  }	
					  
					 } // end of inner for loop;
					
				}// end of row for loop
				
			/*
				for(int i=0; i<rowno2; i++){
					 for(int j=0;j<colno2-1; j++){
						 System.out.print(data2[i][j]+ " ");		 
					 }
					 System.out.println();
					 }*/
				
			/*Sorting of elements */	
				ArrayList<ExcelFiled> al=new ArrayList<ExcelFiled>(); 
				ArrayList<ExcelFiled2> al2=new ArrayList<ExcelFiled2>(); 
				for(int j=1; j<rowno; j++){					
						 al.add(new ExcelFiled(data[j][0],data[j][1], data[j][2], data[j][3], data[j][4], data[j][5],data[j][6], data[j][7], data[j][8], data[j][9]));
									
				}	// end for  loop for adding data in arraylist
				System.out.println("Sorting excel 1 by Name...");  
				Collections.sort(al,new ThisComparator());  
				Iterator itr=al.iterator();  
				while(itr.hasNext()){  
					ExcelFiled st=(ExcelFiled)itr.next();  
				System.out.println(st.getFirst_name()+" "+st.getLast_name()+" "+st.getCompany_name()+ " "+st.getAddress()+" "+st.getCity()+" "+st.getCounty()+ " "+st.getState()+ " "+st.getZip()+" "+st.getPhone1()+" "+st.getPhone2());  
				}  
				
				for(int i=1; i<rowno2; i++){					
					 al2.add(new ExcelFiled2(data2[i][0],data2[i][1], data2[i][2], data2[i][3], data2[i][4], data2[i][5],data2[i][6], data2[i][7], data2[i][8], data2[i][10]));
								
			}			
				
				System.out.println("Sorting excel 2 by Name");  
				Collections.sort(al2,new ThisComparator2());  
				Iterator itr2=al2.iterator();  
				while(itr2.hasNext()){  
					ExcelFiled2 st2=(ExcelFiled2)itr2.next();  
			      System.out.println(st2.getFirst_name()+" "+st2.getLast_name()+" "+st2.getCompany_name()+ " "+st2.getAddress()+" "+st2.getCity()+" "+st2.getCounty()+ " "+st2.getState()+ " "+st2.getZip()+" "+st2.getPhone1()+" "+st2.getPhone2());  
				} 
			
				// Creating xml file and io exception already handled //
				//Basically you need to load an existing xml file and make a Docoment of it by parsing it and get the root element from it.
				// If the file does not exist than create a new document and a new root element. After that you can go on with the code you have shown.
				  Document document = null;
		          Element root = null;
		          File xmlFile = new File("E:\\datafile1_output1.xml");		        
		          
		       if(xmlFile.exists()){
		    	 //  try to load document from xml file if it exists create a file input stream
		              FileInputStream fis1 = new FileInputStream(xmlFile);
		           // create a sax builder to parse the document
		              SAXBuilder sb = new SAXBuilder();
		              document = sb.build(fis1); // mention the path of xml  // parse the xml content provided by the file input stream and create a Document object
		              root = document.getRootElement();
		              fis.close();
		          }else{
		              document = new Document();
		              root = new Element("company");
		          }
				
		   for(int i=1; i<rowno; i++){			 
			    Element staff= new Element("staff");  // creates a new element 
			   	staff.setAttribute(new Attribute("id"," "+i)); // set id 
				staff.addContent(new Element("firstname").setText(data[i][0])); // adds child element
				staff.addContent(new Element("lastname").setText(data[i][1]));
				staff.addContent(new Element("companyname").setText(data[i][2]));
				staff.addContent(new Element("address").setText(data[i][3]));
				staff.addContent(new Element("city").setText(data[i][4]));
				staff.addContent(new Element("county").setText(data[i][5]));
				staff.addContent(new Element("state").setText(data[i][6]));
				staff.addContent(new Element("zip").setText(data[i][7].replaceAll("\\.0*$", "")));
				staff.addContent(new Element("phone1").setText(data[i][8]));
				staff.addContent(new Element("phone2").setText(data[i][9]));
				root.addContent(staff);
		        

			   
		   } // end for loop
		   document.setContent(root); // sets the root
		   FileWriter writer = new FileWriter("E:\\datafile1_output1.xml");
           XMLOutputter outputter = new XMLOutputter(); // serialze the xml to write in file
           outputter.setFormat(Format.getPrettyFormat()); // format the xml
           outputter.output(document, writer); // will print the document to given input stream
           //outputter.output(document, System.out);
           writer.close(); // close writer          
           
           
           // Creating xml2 file and io2 exception already handled*/
			  Document document2 = null;
	          Element root2 = null;	         
	          File xmlFile2 = new File("E:\\datafile2_output2.xml");
	          
	       if(xmlFile2.exists()){
	              FileInputStream fis5 = new FileInputStream(xmlFile2);
	              SAXBuilder sb2 = new SAXBuilder();
	              document2 = sb2.build(fis5);
	              root2 = document2.getRootElement();
	              fis5.close();
	          }else{
	              document2 = new Document();
	              root2 = new Element("company");
	          }
			
	   for(int i=1; i<rowno2; i++){			 
		    Element staff2= new Element("staff");
		   	staff2.setAttribute(new Attribute("id"," "+i));
			staff2.addContent(new Element("firstname").setText(data2[i][0]));
			staff2.addContent(new Element("lastname").setText(data2[i][1]));
			staff2.addContent(new Element("companyname").setText(data2[i][2]));
			staff2.addContent(new Element("address").setText(data2[i][3]));
			staff2.addContent(new Element("city").setText(data2[i][4]));
			staff2.addContent(new Element("county").setText(data2[i][5]));
			staff2.addContent(new Element("state").setText(data2[i][6]));
			staff2.addContent(new Element("zip").setText(data2[i][8].replaceAll("\\.0*$", "")));
			staff2.addContent(new Element("phone1").setText(data2[i][7]));
			staff2.addContent(new Element("phone2").setText(data2[i][10]));
			root2.addContent(staff2);
	        
		   
	   } // end for loop
	   
	   document2.setContent(root2);
	   FileWriter writer2 = new FileWriter("E:\\datafile2_output2.xml");
	   XMLOutputter outputter2 = new XMLOutputter();
	   outputter2.setFormat(Format.getPrettyFormat());
	   outputter2.output(document2, writer2);
	   //outputter.output(document, System.out);
	   writer2.close(); // close writer	
           
           
           /* Extract a list of unique area codes from the data and save to a text
				file named datafile1_output2.txt*/
                      
           HashSet<String> zipcode=new HashSet<String>();  
           int count=0;
           for(int i=1; i<rowno; i++){
        	   zipcode.add(data[i][7].replaceAll("\\.0*$", ""));      	   
           } 
           File filezip = new File("E:\\datafile1_output2.txt");           
           Iterator<String> itrzip=zipcode.iterator();  
           if (!filezip.exists()) {
           	filezip.createNewFile();
			}
           FileWriter fw = new FileWriter(filezip.getAbsoluteFile());
		   BufferedWriter bw = new BufferedWriter(fw);
           while(itrzip.hasNext()){  
           // System.out.println(itrzip.next());    
            String zip = (itrzip.next());
           // System.out.println(zip);
			bw.write(zip);
			bw.newLine();
			count++;            
           }  
            bw.close();
           System.out.println("Unique zip code count File1 "+count); 	
           System.out.println("The text file successfully created");           
           
               
           /* Extract a list of unique area codes from the data and save to a text
			file named datafile1_output2.txt*/
                 
      HashSet<String> zipcode2=new HashSet<String>();  
      int count7=0;
      for(int i=1; i<rowno2; i++){
   	   zipcode2.add(data2[i][8].replaceAll("\\.0*$", ""));      	   
      } 
      File filezip2 = new File("E:\\datafile2_output2.txt");           
      Iterator<String> itrzip2=zipcode2.iterator();  
      if (!filezip2.exists()) {
      	filezip2.createNewFile();
		}
      	FileWriter fw2 = new FileWriter(filezip2.getAbsoluteFile());
	   BufferedWriter bw7 = new BufferedWriter(fw2);
      while(itrzip2.hasNext()){  
       
       String zip5 = (itrzip2.next());
      	bw7.write(zip5);
		bw7.newLine();
		count7++;            
      }  
       bw7.close();
      System.out.println("Unique zip code count File2 "+count7); 	
      System.out.println("The text file successfully created");   
    
    
           
           
           
           
          /* Extract the names (first and last) for each entry that has a phone
           number with an exchange that starts with a number between 1 and 5 and
           save to a text file named datafile1_output3.txt*/
           
           File filephone = new File("E:\\datafile1_output3.txt");
           String s=" ";
           int count1=0;
           if (!filephone.exists()) {
        	   filephone.createNewFile();
   			}
           FileWriter fw1 = new FileWriter(filephone.getAbsoluteFile());
		   BufferedWriter bw1 = new BufferedWriter(fw1);
		   for(int i=1;i<rowno; i++){
			   char phone1 = (char)data[i][8].trim().charAt(0);
			   int phone11 = Character.getNumericValue(phone1);
			   char phone2 = (char)data[i][8].trim().charAt(0);
			   int phone12 = Character.getNumericValue(phone2);
			  // System.out.println(phone11);
			   if(((phone11 >=1)&&(phone11<= 5)) && ((phone12 >=1)&&(phone12<= 5))){				
				  // System.out.println(phone11);
				   s = "The first name of employee is "+data[i][0]+ " and the last name is " +data[i][1];
				   bw1.write(s);
				   bw1.newLine();
				   count1++;				   
				   } // end if
				   
			   } // end for
		   bw1.close();
		   System.out.println("Total first name & Last name file1 "+count1);  
		   
		   
		   /* Extract the names (first and last) for each entry that has a phone
           number with an exchange that starts with a number between 1 and 5 and
           save to a text file named datafile1_output3.txt*/
           
           File filephone2 = new File("E:\\datafile2_output3.txt");
           String s2=" ";
           int count9=0;
           if (!filephone2.exists()) {
        	   filephone2.createNewFile();
   			}
           FileWriter fw6 = new FileWriter(filephone2.getAbsoluteFile());
		   BufferedWriter bw6 = new BufferedWriter(fw6);
		   for(int i=1;i<rowno2; i++){
			   char phone14 = (char)data[i][7].trim().charAt(0);
			   char phone15 = (char)data[i][9].trim().charAt(0);
			   int phone111 = Character.getNumericValue(phone14);
			   int phone222 = Character.getNumericValue(phone15);
			  // System.out.println(phone11);
			   if(((phone111 >=1)&&(phone111<= 5))&&((phone222 >=1)&&(phone222<= 5))){				
				//   System.out.println("Phone1 :"+phone111);
				//   System.out.println("Phone2 :"+phone222);
				   s2 = "The first name of employee is "+data2[i][0]+ " and the last name is " +data2[i][1];
				   bw6.write(s2);
				   bw6.newLine();
				   count9++;				   
				   } // end if
				   
			   } // end for
		   bw6.close();
		   System.out.println("Total first name & Last name file2 "+count9);  		   
	      
	      

		}// end try
			
			catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end catch
		
			
	}	 // end main
	
	/**
	 * A comparator class for sorting data.  Should allow for sorting by a specified field
	 * 
	 * @author selliott
	 *
	 */
	
	
	
	private static class ThisComparator implements Comparator<ExcelFiled>{
		
		
		public ThisComparator(){
		}
		
		@Override
		public int compare(ExcelFiled o1, ExcelFiled o2) {
			return o1.getFirst_name().compareTo(o2.getFirst_name());
		}
		
	}
	
private static class ThisComparator2 implements Comparator<ExcelFiled2>{
		
		
		public ThisComparator2(){
		}
		
		@Override
		public int compare(ExcelFiled2 o1, ExcelFiled2 o2) {
			return o1.getFirst_name().compareTo(o2.getFirst_name());
		}
		
	}
	
	
	
	/**
	 * Given a Cell, return the value contained in that cell as a string
	 * @param c
	 * @return the value of the Cell
	 */
private static String getCellValue(Cell cell){
	int type;
	Object result;
	type = cell.getCellType(); // gets the type og cell content numeric or string
	
	switch(type){
	
	case 0:
		result=cell.getNumericCellValue();
		break;
	case 1:
		result= cell.getStringCellValue();
		break;
	default:
		throw new RuntimeException("Not supported format");
	
	} // end switch statement
	return result.toString();
}// end celltostring method 	
} // end Test Class
