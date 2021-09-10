package exception;

public class UncheckedException {
	/*
	 * Arithmetic, NullPoint, OutofBound 와 같은 예외는 try ~ catch를 하지 않아도 된다. 이 예외는
	 * 논리에러일 경우가 많기 때문에 발생하면 오류를 수정해야 한다.
	 */
	public static void main(String[] args) {
		int[] a = { 10, 20, 30, 40 };

		for (int i = 0; i < a.length + 1; i++) {

			System.out.println(a[i]);
		}

	}
}
