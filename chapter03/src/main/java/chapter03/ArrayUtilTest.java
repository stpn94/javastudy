package chapter03;

import java.util.Arrays;

/*다음 2개의 static 메소드를 가진 ArrayUtils 클래스를 만드세요.
ArrayUtils 클래스 이용하는 ArrayUtilsTestApp 프로그램도 만드세요.
*/
public class ArrayUtilTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = { 10, 20, 30 };
		System.out.println(Arrays.toString(a));
		
		double[] a1 = ArrayUtil.intToDouble(a);
		System.out.println(Arrays.toString(a1));
		int[] a2 = ArrayUtil.doubleToInt(a1);
		System.out.println(Arrays.toString(a2));
		
		int[] b = { 100, 200, 300 };
		int[] c = ArrayUtil.concat(a, b);
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));

		if (c.length == a.length + b.length) {

			System.out.println("OK");
		} else {

			System.out.println("No");
		}
	}
}
