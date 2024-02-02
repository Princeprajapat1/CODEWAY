package GradeCalculater;

import java.util.Scanner;

public class Gradecalculator{
	public static void main(String args[]) {
		System.out.println("Wel come to Grade Calculater");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no. of your subjects");
		int n=sc.nextInt();
		boolean flag=false;
		String answer=calculate(n,sc,flag);
		System.out.println("your Grade is "+answer);
	}
	
	public static String calculate(int n,Scanner sc,boolean flag) {
		int sum=0;
		int k=0;
		for(int i=1;i<=n;i++) {
			System.out.println("Enter marks obtained in subject "+i);
			 k=sc.nextInt();
			sum=sum+k;
			if(k>100){
				System.out.println("invalid marks,please enter valid marks");
				calculate(n,sc,flag);
			}
			}if(k<33) {
				flag=true;
			}
		int percentage=sum/n;
		String s= calculategrade(percentage);
		if(s=="E"||flag==true) {
			System.out.println("Fail");
			System.out.println("your percentage is: "+percentage+"%");
		}else{
			System.out.println("your percentage is: "+percentage+"%");
			System.out.println("Pass");
		}
		return s;
	}
	public static String calculategrade(int p) {
		if(p>=90) {
			return "A+";
		}else if(p>=75&&p<90) {
			return "A";
		}else if(p>=60&&p<75){
			return "B";
		}else if(p>45&&p<60) {
			return "C";
		}else if(p>=35&&p<45) {
			return "D";
		}else {
			return "E";
		}
	}
}