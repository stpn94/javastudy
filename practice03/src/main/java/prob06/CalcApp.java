package prob06;

import java.util.Scanner;

public class CalcApp {

	/*
	 * 다수의 클래스를 정의해보고 활용하는 연습입니다.
	 * 
	 * 사칙연산 (+, -, *, /)만 가능하고 2개의 피연산자만 입력 받는 정수 계산기를 만드세요.
	 * 
	 * 각 사칙연산을 수행하는 각 연산 클래스 Add, Sub, Mul, Div 클래스를 만들고 각 클래스는 다음의 필드와 메소드를 가집니다.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			/* 코드를 완성 합니다 */
			System.out.print(">> ");
			String expression = scanner.nextLine();

			if ("quit".equals(expression)) {
				break;
			}

			String[] tokens = expression.split(" ");

			if (tokens.length != 3) {
				System.out.println(">> 알 수 없는 식입니다.");
				continue;
			}

			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);

			switch (tokens[1]) {
			case "+": {
				Add add = new Add();
				add.setValue(lValue, rValue);
				add.calculate();

				break;
			}
			case "-": {
				Sub sub = new Sub();
				sub.setValue(lValue, rValue);
				sub.calculate();

				break;
			}
			case "*": {
				Mul mul = new Mul();
				mul.setValue(lValue, rValue);
				mul.calculate();

				break;
			}
			case "/": {
				Div div = new Div();
				div.setValue(lValue, rValue);
				div.calculate();

				break;
			}
			default: {
				System.out.println(">> 알 수 없는 연산입니다.");
			}
			}
		}

		scanner.close();

	}

}
