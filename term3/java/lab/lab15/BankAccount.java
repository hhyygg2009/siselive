package lab15;

//BankAccount.java
public class BankAccount {
	private String bankNo; // �����˺�
	private double balance; // �������
	public BankAccount(String bankNo, double balance) {
		this.bankNo = bankNo;
		this.balance = balance;
	}
	public String getBankNo( ) {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public double getBalance( ) {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}

