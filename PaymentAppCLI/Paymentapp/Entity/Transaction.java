import java.time.LocalDate;

public class Transaction {

	private String txnId;
	private LocalDate dateTime;
	private String Limit;
	private TxnType txnSource;
	private TxnType txnDestination;
	private TxnType transactionType;
	private double txnAmount;
	private String statement;
	
	private int userId;
	
	Wallet srcWallet;
	Wallet destWallet;
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public LocalDate getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}
	public String getLimit() {
		return Limit;
	}
	public void setLimit(String limit) {
		Limit = limit;
	}
	public TxnType getTxnSource() {
		return txnSource;
	}
	public void setTxnSource(TxnType txnSource) {
		this.txnSource = txnSource;
	}
	public TxnType getTxnDestination() {
		return txnDestination;
	}
	public void setTxnDestination(TxnType txnDestination) {
		this.txnDestination = txnDestination;
	}
	public TxnType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TxnType transactionType) {
		this.transactionType = transactionType;
	}
	public double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(double txnAmount) {
		this.txnAmount = txnAmount;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Wallet getSrcWallet() {
		return srcWallet;
	}
	public void setSrcWallet(Wallet srcWallet) {
		this.srcWallet = srcWallet;
	}
	public Wallet getDestWallet() {
		return destWallet;
	}
	public void setDestWallet(Wallet destWallet) {
		this.destWallet = destWallet;
	}

	public String toString(){
		
		return "---" +": Transaction ID: " + txnId + " Date: " + dateTime 
				+ " Amount: "+txnAmount + " Source Type: " + txnSource
				+" Amount sent to UserId: "+ userId + " Destination Type: "
				+ txnDestination ;
	}
}





