package chapter03;

public class StaticMethodTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = Math.abs(-1);
		int b = Math.max(10, 10);

		StaticMethod.s1();

		System.out.println(a + ":" + b);
	}
}
