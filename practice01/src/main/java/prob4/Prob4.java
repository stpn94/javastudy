package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		System.out.println(a);

		for (int i = 1; i <= a.length(); i++) {
			System.out.println(a.substring(0, i));
		}

		
		scanner.close();
	}

}
