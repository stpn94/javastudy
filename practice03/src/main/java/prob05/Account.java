package prob05;

public class Account {
	private String accountNo;
	private int balance;

	public Account() {
	}

	public Account(String accountNo) {
		this.accountNo = accountNo;
		System.out.println(accountNo+" 계좌가 개설되었습니다.");
	}

	public Account(String accountNo, int balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void save(int i) {
		// TODO Auto-generated method stub
		balance += i;
		System.out.println(accountNo + "계좌에" + i + "만원 입금되습니다.");
	}

	public void deposit(int i) {
		// TODO Auto-generated method stub
		balance -= i;
		System.out.println(accountNo + "계좌에" + i + "만원 출금되습니다.");

	}
}
