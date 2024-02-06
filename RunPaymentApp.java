//package tmf.java.paymentapp.dp;
import java.util.*;
public class RunPaymentApp {
	
	public static User[] userList =  new  User[5];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int SelectedOption=0;
		
		while(true){
		System.out.println("Welcome to PaymentApp");
		System.out.println("1.User Registeration");
		System.out.println("2.Login");
		System.out.println("3.Add Bank Account");
		System.out.println("4.List Of Users");
		System.out.println("-1.EXIT");
		
		System.out.println("Please enter a option: ");
		Scanner sc = new Scanner(System.in);
		String opt = sc.next();
		//SelectedOption = Integer.parseInt(opt);
		try {
			SelectedOption = Integer.parseInt(opt);
		}catch(NumberFormatException e) {
			//e.printStackTrace();
			//e.getMessage();
			System.out.println("Number format error is occured please sort out it and try again!! \n");

		}catch(ArithmeticException e) {
			//e.printStackTrace();
			//e.getMessage();
			System.out.println("Arithmetic error is occured please sort out it and try again!! \n");
		}catch(Exception e){
			//e.printStackTrace();
			//e.getMessage();
			System.out.println("Some error is occured please sort out it and try again!! \n");
		}finally {
			//System.out
		}
		
		UserOperation uo = new UserOperation();
		
		System.out.println("User selected option : "+opt);
		
//--------------------------User Registeration----------------------------------------------------------
		if(opt.equalsIgnoreCase("1")) {
			System.out.println("User Registeration Enter your Details: ");
			
			System.out.println("First Name: ");
			String FName = sc.next();
			System.out.println("Last Name: ");
			String LName = sc.next();
			System.out.println("Date of Birth: ");
			String DoB = sc.next();
			System.out.println("Phone Number: ");
			long PhNum = sc.nextLong();
			System.out.println("Address: ");
			String Addr = sc.next();
			System.out.println("Password: ");
			String Pswd = sc.next();
			
			//System.out.println("UserId: ");
			User u =uo.doUserRegisteration(FName, LName, DoB, PhNum, Addr,Pswd);
			//userList[0]=u;

			for(int i=0;i<userList.length;i++) {
				if(userList[i] ==null) {
					userList[i]=u;
				}
			  }

		}
//--------------------------------User Login---------------------------------------------------------

		else if(opt.equalsIgnoreCase("2")) {
			System.out.println("Login");
		}
//------------------------------Add Bank Account------------------------------------------------------

		else if(opt.equalsIgnoreCase("3")) {
			System.out.println("Add Bank Account");
		}
//-------------------------------List of Users---------------------------------------------------------
		
		else if(opt.equalsIgnoreCase("4")) {
			System.out.println("List Of Users");
			uo.printUserDetails(userList);
		}
//------------------------------------Exit-------------------------------------------------------------
		
		else if(opt.equalsIgnoreCase("-1")) {
			System.out.println("EXITED");
			break;
		}else {
			System.out.println("Enter a valid option!!");
		}
	}
	}
}
