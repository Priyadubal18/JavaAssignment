import java.util.Scanner;

class Student{
public int roll;
public String sname;
public String course;
public double mark;
Scanner input = new Scanner(System.in);


/*  
Method getData defined to get user input using Scanner class
*/

public void getData(){
System.out.println("Enter the studnet roll number");
roll = input.nextInt();
System.out.println("Enter the student name");
input.nextLine();
sname = input.nextLine();
System.out.println("Enter the course");
course = input.nextLine();
System.out.println("Enter the marks obtained");
mark = input.nextDoubled();

} // end of getData() method


/* Method showData defined to display user input*/
public void showData(){

System.out.println("The student " +sname +" having roll no " +roll+ " enrolled in course " +course+ " has scored " +mark+ " marks");

} // end of showData() method

} // end of Student class


class Main{

public static void main(String args[]){

Student[] studentdata = new Student[5];
int sum=0;
double average;

for(int i=0; i<studentdata.length; i++){

studentdata[i] = new Student();
studentdata[i].getData();
//studentdata[i].showData();
sum+= studentdata[i].mark;

}// end for loop

for(int i=0; i<studentdata.length; i++){
 studentdata[i].showData();
}// end for loop

/* Calculates the average marks obtained by all students */
average = (sum/studentdata.length);
System.out.println("The average marks obtained by all students " +average);


} // end main method




}// end Main classs which is active class