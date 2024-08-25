package task2;
import java.util.*;
public class Grade_Calculator {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Name : ");
		String Name=sc.next();
		
		System.out.println("Enter the Number of Subject : ");
		int NoSub=sc.nextInt();
		int i=1;
		int totalMarks=0;
		while(i<=NoSub) {
			System.out.println("Enter the Marks of Subject "+i+" : ");
			int marks=sc.nextInt();
			totalMarks+=marks;
			i++;
		}
		double Avg_percentage=(totalMarks/(double)NoSub);
		char Grade='F';
		if(Avg_percentage>=90) {
			Grade='A';
		}
		else if(Avg_percentage>=80) {
			Grade='B';
		}
		else if(Avg_percentage>=65) {
			Grade='C';
		}
		else if(Avg_percentage>=50) {
			Grade='D';
		}
		else if(Avg_percentage>=40) {
			Grade='E';
		}
		
		System.out.println("***************************************************");
		System.out.println("Score Card of "+Name);
		System.out.println("Total Marks: "+totalMarks);
		System.out.println("Average Percentage: "+Avg_percentage);
		System.out.println("Grade: "+Grade);
		System.out.println("***************************************************");
		
		
		sc.close();
	}
}
