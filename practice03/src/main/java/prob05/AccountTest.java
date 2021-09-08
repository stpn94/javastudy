package prob05;

public class AccountTest {

	/*
	 * 계좌(Account) 클래스는
	 * 
	 * 1. 계좌 번호를 나타내는 accountNo 2. 잔고를 나타내는 balance
	 * 
	 * 2개의 데이터를 가지고 있습니다.
	 * 
	 * 
	 * 메소드는 
	 * 1. 입금을 의미하는 save 
	 * 2. 출금을 의미하는 deposit 
	 * 3. getter / setter 를 가지고 있습니다.
	 * 
	 * AccountTest 클래스를 이용하여 Account 클래스의 함수를 호출시켰을 때 콘솔에 출력되는 결과는 다음과 같습니다.
	 * 
	 * 
	 * 
	 * << TestAccount 실행결과 >> 
	 * 078-3762-293 계좌가 개설되었습니다. 
	 * 078-3762-293 계좌의 잔고는 0만원입니다.
	 * 078-3762-293 계좌에 100만원이 입금되었습니다. 
	 * 078-3762-293 계좌의 잔고는 100만원입니다. 
	 * 078-3762-293	* 계좌에 30만원이 출금되었습니다. 
	 * 078-3762-293 계좌의 잔고는 70만원입니다.
	 */
	public static void main(String[] args) {

		Account account = new Account("078-3762-293");
		System.out.println(account.getAccountNo() + "계좌의 잔고는 " + account.getBalance() + "만원입니다.");

		account.save(100);
		System.out.println(account.getAccountNo() + "계좌의 잔고는 " + account.getBalance() + "만원입니다.");

		account.deposit(30);
		System.out.println(account.getAccountNo() + "계좌의 잔고는 " + account.getBalance() + "만원입니다.");

	}

}
