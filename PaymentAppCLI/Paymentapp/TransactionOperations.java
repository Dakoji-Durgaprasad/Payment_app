import java.util.Scanner;

public class TransactionOperations {

	public static void showTransactionsOptions() {

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
				break;

			case 2:
				System.out.println("bank to wallet");
				break;

			case 3:
				System.out.println("bank to bank");
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

	public static void sendMoneyWalletToWallet() {
		
	}

	public static void sendMoneyBankToWallet() {

	}

	public static void sendMoneyBankToBank() {

	}
	

}
