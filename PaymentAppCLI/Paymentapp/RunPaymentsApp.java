import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RunPaymentsApp {

	public static List<User> userList = new ArrayList<User>();
	public static int currUserId = -1;
	public static List<BankAccount> baAcctList = new ArrayList<BankAccount>();
	public static Map<Integer, Wallet> walletList = new HashMap<Integer, Wallet>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int SelectedOption = 0;

		while (true) {
			System.out.println("Please choose an option from below: ");
			System.out.println("1.Registration");
			System.out.println("2.Login");
			System.out.println("3.Add bank account");
			System.out.println("4.Wallet");
			System.out.println("5.List of users");
			System.out.println("6.Current user");
			System.out.println("7.List of users bank accounts");
			System.out.println("8.Delete bank account");
			System.out.println("9.Do Transaction");
			System.out.println("-1.Exit");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter an option: ");
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
			} else if (op.equalsIgnoreCase("2")) {
				System.out.println("Login");
				Login();
			} else if (op.equalsIgnoreCase("3")) {
				if (validateCurrUser()) {
					System.out.println("Please Enter bank account details: ");
					AddBankAccount();
				}
			} else if (op.equalsIgnoreCase("4")) {
				if (validateCurrUser()) {
					System.out.println("Wallet");
					WalletOperation();
				}
			} else if (op.equalsIgnoreCase("5")) {
				System.out.println("List of users");
				uop.printUsersList(userList);
			} else if (op.equalsIgnoreCase("6")) {
				if (currUserId != -1) {
					System.out.println("Current users");
					uop.printCurrUserDetails(currUserId);
				}
			} else if (op.equalsIgnoreCase("7")) {
				if (currUserId != -1) {
					System.out.println("List of users bank accounts");
					printUserBankAccounts();
				}
			} else if (op.equalsIgnoreCase("8")) {
				if (currUserId != -1) {
					System.out.println("Delete bank account");
					System.out.println("Enter Bank Account Number: ");
					String accNum = sc.next();
					deleteUserBankAccount(currUserId, accNum, userList);
				} else {
					System.out.println("please login to delete bank accounts");
				}
			} else if (op.equalsIgnoreCase("9")) {
				if (currUserId != -1) {
					System.out.println("DO TRANSACTION");
					showTransactionsOptions();
				}
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
		String fname = sc.next();
		System.out.println("Last Name: ");
		String lname = sc.next();
		System.out.println("Phone Number: ");
		long phnum = sc.nextLong();
		System.out.println("Date of Birth: ");
		String dob = sc.next();
		System.out.println("Address: ");
		String addr = sc.next();
		System.out.println("Password: ");
		String pswd = sc.next();

		User u;
//		try {
		u = uop.doUserRegistration(fname, lname, phnum, dob, addr, pswd);
		userList.add(u);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		Wallet wallet = new Wallet();
		int userId = u.getUserId();
		walletList.put(userId, wallet);

	}

	public static boolean Login() {
		Scanner sc = new Scanner(System.in);
		UserOperations uop = new UserOperations();

		System.out.println("Enter Your User ID: ");
		String uId = sc.next();
		System.out.println("Enter Your Password: ");
		String pswd = sc.next();

		if (uop.verifyUserLogin(uId, pswd)) {
			currUserId = Integer.parseInt(uId);
			return true;
		} else {
			System.out.println("Login Failed, please try again!!");
			return false;
		}

	}

	public static boolean validateCurrUser() {
		if (currUserId != -1) {
			return true;
		} else {
			return false;
		}
	}

	public static void AddBankAccount() {
		AcctType selectedAcctType = null;
		Scanner sc = new Scanner(System.in);
		UserOperations uop = new UserOperations();

		System.out.println("Bank Account Number: ");
		String baAcctNum = sc.next();
		System.out.println("Bank IFSC Code: ");
		String baIFSCCode = sc.next();
		System.out.println("Bank Name: ");
		String baName = sc.next();
		System.out.println("Bank Account Type: ");
		System.out.println("SA: SAVINGS");
		System.out.println("CA: CURRENT");
		System.out.println("LA: LOAN");
		System.out.println("SL: SALARY");
		String baAcctType = sc.next();

		if (baAcctType.equalsIgnoreCase("SA")) {
			// System.out.println(AcctType.SAVINGS);
			selectedAcctType = AcctType.SAVINGS;

		} else if (baAcctType.equalsIgnoreCase("CA")) {
			// System.out.println(AcctType.CURRENT);
			selectedAcctType = AcctType.CURRENT;
		} else if (baAcctType.equalsIgnoreCase("LA")) {
			// System.out.println(AcctType.LOAN);
			selectedAcctType = AcctType.LOAN;
		} else if (baAcctType.equalsIgnoreCase("SL")) {
			// System.out.println(AcctType.SALARY);
			selectedAcctType = AcctType.SALARY;
		} else {
			System.out.println("Enter Valid Account Type Option");
		}

		System.out.println("Bank Account Pin: ");
		String baAcctPin = sc.next();

		BankAccount ba = new BankAccount();
		ba.setBankAcctNumber(baAcctNum);
		ba.setBankAcctIFSC(baIFSCCode);
		ba.setBankAcctBankName(baName);
		ba.setBankAcctType(selectedAcctType);
		ba.setBankAcctPin(baAcctPin);
		ba.setUserId(currUserId);

		for (User u : userList) {
			if (u.getUserId() == currUserId) {
				u.getBaList().add(ba);
			}
		}
		baAcctList.add(ba);
	}

	public static void printUserBankAccounts() {
		UserOperations uop = new UserOperations();
		Map<User, List<BankAccount>> mapItems = uop.getUsersBankAccount();

		for (User u : mapItems.keySet()) {
			List<BankAccount> baList = mapItems.get(u);
			System.out.println(u);
			if (baList != null) {
				for (BankAccount ba : baList) {
					System.out.println("--" + ba.printBankAcctDetails());
				}
			}

		}
	}

	public static void deleteUserBankAccount(int UserId, String accNum, List<User> userlist) {
		for (User u : userlist) {
			if (u.getUserId() == UserId) {
				List<BankAccount> baAcctList = u.getBaList();
				Iterator<BankAccount> iterator = baAcctList.iterator();
				while (iterator.hasNext()) {
					BankAccount acct = iterator.next();
					if (acct.getBankAcctNumber().equals(accNum)) {
						iterator.remove();
						System.out.println("BankAccount deleted successfully");
						return;
					}
				}
			}
		}
		System.out.println("Bank Account has Not matched");
	}

	public static void WalletOperation() {
		while (true) {
			System.out.println("1. Add money to Wallet");
			System.out.println("2. Check wallet balance");
			System.out.println("3. Back");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter an Option: ");
			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				System.out.println("Add money to Wallet");
				if (currUserId != -1) {
					Wallet wa = new Wallet();
					// System.out.println("Wallet Balance: " + wa.getBalance());

					Scanner scan = new Scanner(System.in);
					System.out.println("Enter an amount: ");
					double amount = scan.nextDouble();
					wa.setBalance(wa.getBalance() + amount);
					if (amount <= wa.getWalletAmountLimit()) {
						UserOperations uop = new UserOperations();
						uop.addMoneyToWallet(amount);
					} else {
						System.out.println("Out of the Wallet Limit!!");
					}
					// System.out.println("Current Wallet Balance: " + wa.getBalance());
					System.out.println();
				} else {
					System.out.println("Please check whether user is login or not!!");
				}

				break;

			case 2:
				if (currUserId != -1) {
					UserOperations uop = new UserOperations();
					try {
						System.out.println("Current Wallet Balance: " + uop.checkWalletBalance());
					} catch (NullPointerException ne) {
						ne.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;

			case 3:
				System.out.println("Thanks You!! \n");
				break;

			default:
				System.out.println("Enter valid Option!!");
			}
			if (opt == 3) {
				break;
			}
		}

	}
	
	public static void showTransactionsOptions() {
		UserOperations uop = new UserOperations();

		while (true) {
			System.out.println("1. Wallet to Wallet");
			System.out.println("2. Bank to Wallet");
			System.out.println("3. Bank to Bank");
			System.out.println("4. Transaction Statement");
			System.out.println("5. Back");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter an Option: ");
			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				System.out.println("Wallet to Wallet");
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter UserID To Send Money: ");
				String uId = scan.next();
				for(User u : userList) {
					
				}
				uop.sendMoneyWalletToWallet();
				break;

			case 2:
				System.out.println("bank to wallet");
				uop.sendMoneyBankToWallet();
				break;

			case 3:
				System.out.println("bank to bank");
				uop.sendMoneyBankToBank();
				break;

			case 4:
				System.out.println("transaction statement");
				break;
			case 5:
				System.out.println("Thanks You!! \n");
				break;

			default:
				System.out.println("Enter valid Option!!");
			}
			if (opt == 5) {
				break;
			}
		}
	}


}
