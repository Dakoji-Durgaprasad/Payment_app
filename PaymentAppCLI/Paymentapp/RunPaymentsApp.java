import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunPaymentsApp {
	
	public static List<User> userList = new ArrayList<User>();
	public static int currUserId=-1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int SelectedOption = 0;
		
		while (true) {
			System.out.println("Please choose an option from below: ");
			System.out.println("1.Registration");
			System.out.println("2.Login");
			System.out.println("3.Add bank account");
			System.out.println("4.Add money to wallet");
			System.out.println("5.List of users");
			System.out.println("6.Current user");
			System.out.println("7.List of users bank accounts");
			System.out.println("8.Delete bank account");
			System.out.println("-1.Exit");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter an option");
			String op = sc.next();

			try {
				SelectedOption = Integer.parseInt(op);
			} catch (NumberFormatException ne) {
				// ne.printStackTrace();
				System.out.println("This is number format exception");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("This is unknown exception");
			} finally {
				System.out.println();
			}
			
			UserOperations uop = new UserOperations();
			
			if (op.equalsIgnoreCase("1")) {
				System.out.println("User selected registartion");
				Registration();
			} 
			else if (op.equalsIgnoreCase("2")) {
				System.out.println("Login");
				Login();
			} 
			else if (op.equalsIgnoreCase("3")) {
				System.out.println("Add bank account");
			} else if (op.equalsIgnoreCase("4")) {
				System.out.println("Add money to wallet");
			} else if (op.equalsIgnoreCase("5")) {
				System.out.println("List of users");
				uop.printUsersList(userList);
			} 
			else if (op.equalsIgnoreCase("6")) {
				System.out.println("Current users");
				if(currUserId!=-1) {
				uop.printCurrUserDetails(currUserId);
				}
			} 
			else if (op.equalsIgnoreCase("7")) {
				System.out.println("List of users bank accounts");
			} else if (op.equalsIgnoreCase("8")) {
				System.out.println("Delete bank account");
			} else if (op.equalsIgnoreCase("-1")) {
				System.out.println("Exit");
				break;
			} else {
				System.out.println("Enter a valid Option!!! \n");

			}
		}
	}
	
	public static void Registration() {
		Scanner sc = new Scanner(System.in);
		UserOperations uop = new UserOperations();
		System.out.println("First Name: ");
		String fname=sc.next();
		System.out.println("Last Name: ");
		String lname=sc.next();
		System.out.println("Phone Number: ");
		long phnum=sc.nextLong();
		System.out.println("Date of Birth: ");
		String dob=sc.next();
		System.out.println("Address: ");
		String addr=sc.next();
		System.out.println("Password: ");
		String pswd=sc.next();
		
		User u;
		try {
		u= uop.doUserRegistration(fname, lname, phnum, dob, addr,pswd);
		userList.add(u);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean Login() {
		Scanner sc = new Scanner(System.in);
		UserOperations uop = new UserOperations();
		
		System.out.println("Enter Your User ID: ");
		String uId = sc.next();
		System.out.println("Enter Your Password: ");
		String pswd = sc.next();
		
		if(uop.verifyUserLogin(uId, pswd)) {
			currUserId =Integer.parseInt(uId);
			return true;
		}else {
			System.out.println("Login Failed, please try again!!");
			return false;
		}
		
	}
	
	public static boolean validateCurrUser() {
		if(currUserId!=-1) {
			return true;
		}else {
			return false;
		}
	}
}
