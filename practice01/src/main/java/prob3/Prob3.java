package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		/*
		 * 숫자를 입력 받아서 아래와 같은 실행결과가 나타나도록 Prob3 클래스의 main 메쏘드를 완성하세요 a. 입력 받은 숫자가 홀수인
		 * 경우에는, 0 부터 입력 값까지 홀수의 합을 출력합니다. - 예제 : 입력이 7 이면 16을 출력 ( 1 + 3 + 5 + 7 = 16 )
		 * b. 입력 받은 숫자가 짝수인 경우에는, 0 부터 입력 값까지 짝수의 합을 출력합니다. - 예제 : 입력이 10 이면 30을 출력 ( 2
		 * + 4 + 6 + 8 + 10 = 30 )
		 */
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int sum = 0;
		int ssum = 0;
		if (num % 2 == 1) {
			for (int i = 1; i <= (num / 2) + 1; i++) {
				sum = 2 * i - 1;
				ssum += sum;
				System.out.println(ssum);
			}
		} else {
			for (int i = 1; i <= (num / 2); i++) {
				sum = 2 * i;
				ssum += sum;
				System.out.println(ssum);
			}
		}
		scanner.close();
	}
}
