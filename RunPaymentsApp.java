//package com.sat.tmf.paymentscli;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//import com.sat.tmf.paymentscli.entity.AcctType;
//import com.sat.tmf.paymentscli.entity.BankAccount;
//import com.sat.tmf.paymentscli.entity.User;

public class RunPaymentsApp {
	//Driver class

//	static int x=10;
//	public static User[] usersList = new User[5];
	public static List<User> usersList =new ArrayList<User>();
	public static ArrayList<BankAccount> bankAcctList = new ArrayList<BankAccount>();
	public static int currUserId = -1;

	public static void main(String[] args) {
		
		int selectedOption=0;		
		Scanner opt = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Payments App Actions:");
			System.out.println("1. Register New User");
			System.out.println("2. Login");
			System.out.println("3. ADD Bank Account");
			System.out.println("4. ADD Money To Wallet");
			System.out.println("5. List of Users");
			System.out.println("6. Current User");
			System.out.println("7. List All User Bank Accounts");
			System.out.println("8. Delete Bank Account");
			System.out.println("-1. Quit/ Logout");
			System.out.println("Choose an Option:");
			
			String optStr = opt.next();
			try {
				selectedOption = Integer.parseInt(optStr);
				
			}catch(NumberFormatException e) {
				e.printStackTrace();
				e.getMessage();
				System.out.println("Number format Error Occured Please choose another option.");
				
			}catch(ArithmeticException e) {
				e.printStackTrace();
				e.getMessage();
				System.out.println("arithmetic Error Occured Please choose another option.");
				
			}catch(Exception e) {
				e.printStackTrace();
				e.getMessage();
				System.out.println("Some Error Occured Please choose another option.");
			}finally{
				System.out.println();
			}
			
			System.out.println("User selected "+selectedOption);
			UserOperations ops = new UserOperations();
//			if(optStr.equalsIgnoreCase("1")) {
//				registerUser();
//			}else if(optStr.equalsIgnoreCase("2")) {
//				if(!loginUser()) {
//					break;
//				}
//			}else if(optStr.equalsIgnoreCase("3")) {
//				if(validateCurrentUser()) {
//					addBankAccount();
//				}
//			}else if(optStr.equalsIgnoreCase("4")) {
//				if(validateCurrentUser()) {
//				AddMoneyToWallet();
//				}
//			}else if(optStr.equalsIgnoreCase("5")) {
//				ops.printUserList(usersList);
//			}else if(optStr.equalsIgnoreCase("6")) {
//				if(currUserId != -1) {
//					ops.printCurrUserDetails(currUserId);
//				}
//			}else if(optStr.equalsIgnoreCase("7")) {
//				if(currUserId != -1) {
//					printUserBAnkAcctsList();
//				}
//			}else if(optStr.equalsIgnoreCase("8")) {
//				if(currUserId != -1) {
//					delBankAccount();
//				}
//			}else if(optStr.equalsIgnoreCase("-1")) {
//				break;
//			}else {
//				System.out.println("Enter a valid option.");
//			}
			switch(optStr) {
			case "1":
				registerUser();
				break;
			case "2":
				if(!loginUser()) {
					break;
				}
					break;
			case "3":
				if(validateCurrentUser()) {
					addBankAccount();
				}
				break;
			case "4":
				if(validateCurrentUser()) {
				AddMoneyToWallet();
				}
				break;
			case "5":
				ops.printUserList(usersList);
				break;
			case "6":
				if(currUserId != -1) {
					ops.printCurrUserDetails(currUserId);
				}
				break;
			case "7":
				if(currUserId != -1) {
					printUserBAnkAcctsList();
				}
				break;
			case "8":
				if(currUserId != -1) {
					delBankAccount();
				}
				break;
			case "-1":
				break;
			default:
				//System.out.println("Enter a valid option.");
			}
		}
	}
	

	public static void registerUser() {
		Scanner opt = new Scanner(System.in);
		UserOperations ops = new UserOperations();
		
		System.out.println("Please do provide user details as asked:");
		System.out.println("First Name:");
		String fName = opt.next();
		System.out.println("Last Name:");
		String lName = opt.next();
		System.out.println("Phone Number:");
		long phNo = Long.parseLong(opt.next());
		System.out.println("Date Of Birth:");
		String dob = opt.next();
		System.out.println("Address:");
		String addr = opt.next();
		System.out.println("Password:");
		String password = opt.next();
		
		User u;
		try {
			
			u = ops.doUserRegistration(fName, lName, password, phNo, dob, addr);
			
			usersList.add(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean loginUser() {
		Scanner opt = new Scanner(System.in);
		UserOperations ops = new UserOperations();
		
		System.out.println("UserId:");
		String uId = opt.next();
		System.out.println("Password:");
		String password = opt.next();
		if(ops.verifyUserLogin(uId, password)) {
			currUserId = Integer.parseInt(uId);
			return true;
		}else {
			System.out.println("Login Failed, Please Choose an Option:");
			//break;
			return false;
		}
	}
	
	public static boolean validateCurrentUser() {
		if(currUserId != -1) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void addBankAccount() {
		Scanner opt = new Scanner(System.in);
		
		System.out.println("Enter Bank Account Number:");
		String acctNum = opt.next();
		
		System.out.println("IFSC Code:");
		String ifscCode = opt.next();
		
		System.out.println("Bank Name:");
		String bankName = opt.next();
		
		System.out.println("Account Type: from List : ");
		System.out.println("SA: SAVINGS");
		System.out.println("CU: CURRENT");
		System.out.println("LN: LOAN");
		System.out.println("SL: SALARY");
		String acctType = opt.next();
		
		System.out.println("Account PIN:");
		String acctPin = opt.next();
		
		BankAccount ba = new BankAccount();
		ba.setBankAcctNumber(acctNum);
		ba.setBankAcctIFSC(ifscCode);
		ba.setBankAcctBankName(bankName);
		ba.setBankAcctAcctType(AcctType.SAVINGS);
		ba.setBankAcctPin(acctPin);
		ba.setUserId(currUserId);
		
		for(User u:usersList) {
			if(u.getUserId() == currUserId) {
				u.getBaList().add(ba);
			}
		}
		
		bankAcctList.add(ba);
		
	}
	
	public static void printUserBAnkAcctsList() {
		UserOperations ops = new UserOperations();
		Map<User,List<BankAccount>> mapItems = ops.getUserBankAccounts();

		for(User u:mapItems.keySet()) {
			List<BankAccount> //baList = new ArrayList<BankAccount>();
					baList = mapItems.get(u);
			System.out.println(u);
			if(baList != null) {
				for(BankAccount ba: baList) {
					System.out.println("--"+ba.printBankAccountDetails());
				}
			}
			
		}
	}
	
	public static void delBankAccount() {
		Scanner opt = new Scanner(System.in);
		BankAccount b = new BankAccount();
		
		
		System.out.println("Enter Bank Account Number: ");
		String acNum = opt.next();
		
		String AcctNumToDel = acNum;
		removeUserBankAcct(AcctNumToDel);
		
		boolean accountFound = false;
		for(int i=0;i<bankAcctList.size();i++) {
			BankAccount banAcct = bankAcctList.get(i);
			if(banAcct.getBankAcctNumber().equals(AcctNumToDel)) {
				bankAcctList.remove(i);
				accountFound= true;
				System.out.println("User Bank account is deleted successfully");
				break;
			}
			
		}
		if(!accountFound )
		{
			System.out.println("Account not found.");
		}
	}
		
     public static void removeUserBankAcct(String acctNumToDel) {
		List<BankAccount> AcctToRemove = new ArrayList<>();
		for(BankAccount Acct:bankAcctList) {
			if(Acct.getBankAcctNumber().equals(acctNumToDel)) {
				AcctToRemove.add(Acct);
			}
		}
		bankAcctList.remove(AcctToRemove);
	}


	public static void AddMoneyToWallet() {
		
		
	}
}
