
public class Wallet {
	
	private int UserId;
	public double balance =0;
	private double currentBalance;
	private double walletAmountLimit =10000;
	private double deposit;
	private double withdraw;
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public double getWalletAmountLimit() {
		return walletAmountLimit;
	}
	public void setWalletAmountLimit(double walletAmountLimit) {
		this.walletAmountLimit = walletAmountLimit;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}
	
}
