package Atm;
import java.sql.*;
import java.util.Scanner;
public class AtmInterface{
	
	private static final String url="jdbc:mysql://localhost:3306/atm";
	private static final String usr="root";
	private static final String pass="The cow1@";
	public static void main(String args[]) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
		try {
		Connection con=DriverManager.getConnection(url,usr,pass);
		Statement stmt=con.createStatement();
		System.out.println("                     *Welcome*");
	    System.out.println("Choose an option");
				System.out.println("1.Withdraw Amount");
				System.out.println("2.Deposite Amount");
				System.out.println("3.CheckBalance");
				Scanner sc= new Scanner(System.in);
				int opt=sc.nextInt();
				go(sc,opt,con,stmt);
	}catch(Exception e){
		e.printStackTrace();
	}
}
	
	public static void go(Scanner sc,int opt,Connection con,Statement stmt) {
		switch(opt){
		case 1:
			withdraw(sc,con,stmt);
			break;
		
	case 2:
		Deposite(sc,con);
		break;
	
case 3:
check(sc,con,stmt);
	break;
}
}
	
	public static void withdraw(Scanner sc,Connection con,Statement stmt) {
		System.out.println("Enter the amount you want to withdraw:");
		
        int ea=sc.nextInt();
        System.out.println("Enter id");
        int id=sc.nextInt();
        String c_balance="";
        int balance=0;
        try{
        	String sql="select c_balance from atm where c_id="+id;
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
		 c_balance=rs.getString(1);
			balance=Integer.parseInt(c_balance);
							
		}catch(SQLException e){
			e.printStackTrace();
		}
		 if(balance<ea) {
			 System.out.println("Insuffiecent Balance!");
			
		 }else {
        String sql="update atm SET c_balance=c_balance-"+ea+" "+"where c_id="+id;
		 
        try{
        	 int affectedRows=stmt.executeUpdate(sql);
        	 
			 if(affectedRows>0){
				 System.out.println(" Amount withdraw Successfully");
				 
			 }
        }   catch(SQLException e) {
            e.printStackTrace();
    	}
		 }
	
         }


	public static void Deposite(Scanner sc,Connection con) {
		System.out.println("Enter amount that you want to Deposite:");
		int ea=sc.nextInt();
		System.out.println("Enter id ");
		int id= sc.nextInt();
		String c_balance="";
		int balance=0;
	
		 String sql="Update atm SET c_balance=c_balance+"+ea+" "+"WHERE c_id="+id;

		 try(Statement stmt=con.createStatement()) {
			 
			 int affectedRows=stmt.executeUpdate(sql);
			 String s="select c_balance from atm where c_id="+id;
				ResultSet rs=stmt.executeQuery (s);
				rs.next();
			 c_balance=rs.getString(1);
				balance=Integer.parseInt(c_balance);
			 
			 if(affectedRows>0) {
				 System.out.println(" Amount Deposited Successfully");						
				 System.out.println("Your current balance is="+(balance+ea));
			 }else {
				 System.out.println("Amount Not Deposited ");
			 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
	
}
	public static void check(Scanner sc,Connection con,Statement stmt) {
		
		System.out.println("Enter your id");
		int id=sc.nextInt();
		
		String sql="select c_balance from atm where c_id="+id;
		
		try{
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			String c_balance=rs.getString(1);
			
			System.out.println("Your Current Account Balance is "+c_balance);
			
			
			con.close();
					
		}catch(SQLException e){
			e.printStackTrace();
		}
		}  
	
}

	