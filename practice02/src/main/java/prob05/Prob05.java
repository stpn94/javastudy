package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {
	/*
	 * 숨겨진 카드의 수를 맞추는 게임입니다. 1-100까지의 임의의 수를 가진 카드를 한 장 숨기고 이 카드의 수를 맞추는 게임입니다. 아래의
	 * 화면과 같이 카드 속의 수가 57인 경 우를 보면 수를 맞추는 사람이 40이라고 입력하면 "더 높게", 다시 75이라고 입력하면
	 * "더 낮게" 라는 식으로 범위를 좁혀가며 수를 맞추고 있습니다. 게임을 반복하기 위해 y/n이라고 묻고 n인 경우 종료됩니다..
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		// 범위
		int min = 1;
		int max = 100;

		// false가 되기전까지 계속 된다.
		boolean replay = true;

		// 랜덤으로 나온 값
		int solution = random.nextInt(max) + min;
		// 내가 입력한 값을 저장할 변수
		int result = 0;
		// 시도 횟수
		int tryNum = 0;

		System.out.println("수를 결정하였습니다. 맞추어 보세요");

		while (replay) {

			// 시도 횟수
			tryNum++;

			System.out.println(min + " 에서 ~ " + max + " 까지 ");
			System.out.print(tryNum + " 번째 시도 >> ");

			result = scanner.nextInt();

			// 정답과 응답이 같으면
			if (result == solution) {

				System.out.println(" 맞았습니다. 다시하겠슨니까?(y/n) ");

				String answer = scanner.next();

				// n을 입력하면
				if (answer.equals("n")) {
					// 종료하기위해 replay를 false로 한다.
					replay = false;
				} else {
					// 아니면 다시 랜덤함수 다시 시작.
					min = 1;
					max = 100;
					replay = true;
					result = 0;
					tryNum = 0;
					solution = random.nextInt(max) + min;
					System.out.println("수를 결정하였습니다. 맞추어 보세요");
				}
				// 응답이 정답보다 낮으면
			} else if (result > solution) {
				System.out.println("더 낮은 수");
				// 범위 재설정
				max = result;
				// 응답이 정답보다 높으면
			} else if (result < solution) {
				System.out.println("더 높은 수");
				// 범위 재설정
				min = result;
			}
		}
	}
}