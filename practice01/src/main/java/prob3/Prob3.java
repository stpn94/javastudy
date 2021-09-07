package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

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
