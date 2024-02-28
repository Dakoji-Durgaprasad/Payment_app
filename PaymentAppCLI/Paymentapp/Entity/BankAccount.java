
public class BankAccount {

	String bankAcctNumber;
	String bankAcctIFSC;
	String bankAcctBankName;
	AcctType bankAcctType;
	String bankAcctPin;
	
	private int UserId;
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getBankAcctNumber() {
		return bankAcctNumber;
	}
	public void setBankAcctNumber(String bankAcctNumber) {
		this.bankAcctNumber = bankAcctNumber;
	}
	public String getBankAcctIFSC() {
		return bankAcctIFSC;
	}
	public void setBankAcctIFSC(String bankAcctIFSC) {
		this.bankAcctIFSC = bankAcctIFSC;
	}
	public String getBankAcctBankName() {
		return bankAcctBankName;
	}
	public void setBankAcctBankName(String bankAcctBankName) {
		this.bankAcctBankName = bankAcctBankName;
	}
	public AcctType getBankAcctType() {
		return bankAcctType;
	}
	public void setBankAcctType(AcctType selectedAcctType) {
		this.bankAcctType = selectedAcctType;
	}
	public String getBankAcctPin() {
		return bankAcctPin;
	}
	public void setBankAcctPin(String bankAcctPin) {
		this.bankAcctPin = bankAcctPin;
	}
	
	public String printBankAcctDetails(){
		return "["+this.bankAcctNumber+","+this.bankAcctIFSC+","+this.bankAcctBankName+","+this.bankAcctType+","+this.bankAcctPin+"]";
	}
}
