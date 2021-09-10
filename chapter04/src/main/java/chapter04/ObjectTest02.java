package chapter04;

public class ObjectTest02 {
	public static void main(String[] args) {

		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p2;

		/*
		 * ==: 두 객체의 동일성 비교 equal: 두 객체의 동질성 비교(내용 비교), but! object의 기본 구현은 동일성 비교와 같다.
		 */

		System.out.println(p1 == p2);
		System.out.println(p1 == p3);
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));

	}
}
