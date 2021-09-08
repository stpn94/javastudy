package chapter03;

public class StaticMethod {

	int n;
	static int m;

	void f1() {
		System.out.println(StaticMethod.m);
		System.out.println(n);
	}

	static void s1() {
		System.out.println(StaticMethod.m);

		System.out.println(m);
		// 같은 클래스 접근시에는 생략의 가능하다
		// System.out.println(n);
		// n 오류 static method 에서는 인스턴스 변수 접급 불가
	}

	void f2() {

		StaticMethod.s1();
		f1();
		s1(); // 같은 클래스 접근시에는 생략의 가능하다

	}

	static void s2() { // 유틸리티, 순수함수 만들때 많이 쓴다 대표적으로 math 클래스, parseint

		StaticMethod.s1();
		// f1();
		s1(); // 같은 클래스 접근시에는 생략의 가능하다

	}

}