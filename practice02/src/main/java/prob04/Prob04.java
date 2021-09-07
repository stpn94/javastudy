package prob04;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);
		System.out.println("--------------------------------------------");
		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	//
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] result = str.toCharArray();

		// String 문자열의 길이의 반만큼 반복해서 자리 교체
		for (int i = 0; i < result.length / 2; i++) {
			// i번째 문자를 임시문자 temp로 저장
			char temp = result[i];
			// i번째 문자는 배열 제일 끝으로 간다.(전체 길이(0번째 부터 시작이니 -1 해줘야함)의 i번째 만큼 빼면 재일 마지막 인덱스)
			result[i] = result[result.length - i - 1];
			// 제일 마지막 인덱스에는 임시로 저장된 temp가 들어 온다.
			result[result.length - i - 1] = temp;
		}
		return result;
	}

	public static void printCharArray(char[] array) {
		/* 코드를 완성합니다 */
		//문자 하나하나씩 받아서 출력
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
		//
		System.out.println(array);
	}
}