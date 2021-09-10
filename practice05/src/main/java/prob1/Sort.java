package prob1;

public class Sort {

	public static void main(String[] arg) {

		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int temp = 0;
		int count = array.length;

		System.out.println("Before sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}

		//
		// 정렬 알고리즘이 적용된 코드를 여기에 작성합니다.
		//
		for (int j = 0; j < array.length; j++) {
			for (int i = 1; i < array.length; i++) {
				if (array[i - 1] < array[i]) {
					temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
				}
			}
		}
		// 결과 출력
		System.out.println("\nAfter Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}
}