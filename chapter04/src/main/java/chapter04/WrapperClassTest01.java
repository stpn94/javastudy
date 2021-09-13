package chapter04;

public class WrapperClassTest01 {
	public static void main(String[] args) {
		/*
		 * 정수형 변수 int i = 0; 이건 객체가 아님
		 * 마찬가지로
		 * 문자형 char a = 'a';
		 * 실수형 float a = 1.5f (f는 float를 썻기때문에 1.5숫자 다음에 f 를 붙여준다)
		 * 논리형 boolean t = true;
		 * 실수형 double b = 1.05d (double은 실수여도 숫자끝에 d를 붙여도 되고 안붙여도 된다)
		 * long(긴 숫자를 표현하는 정수형),short(작을떄 쓰는 변수),byte 까지 총 8가지변수가 기본형 변수 이다.
		 * 이것들은 객체를 생성하지않아도 쓸수 있다.
		 * 
		 * 하지만 자바는 객체지향형 언어이기 때문에 위의 변수들도 객체로 만들고싶었나보다.
		 * 그래서
		 * Integer, Character, Boolean, Double, Long, Short, Byte, Float 클래스를 만들었다.
		 * 이것들을 호출하기위해 다름 참조형 객체와 같이
		 * 객체 생성을 해주어야 한다. ex(Integer i = new Integer(10);) <---이렇게
		 * 
		 * 그럼 왜 굳이 기본형 변수 int i = 9; 쓰면되지
		 * 귀찮게 객체로 만들어서 생성해서 호출할까?
		 * 
		 *
		 * */
		Integer i = new Integer(10);
		Character c = new Character('A');
		Boolean b = new Boolean(true);

		System.out.println(i);
		System.out.println(b);
		System.out.println(c);

		// Auto Boxing

		Integer j1 = 10;
		Integer j2 = 10;

		System.out.println(j1 + j2);
		System.out.println(j1 == j2);

		// Auto UnBoxing
		// int j3 = j2.intValue();
		int j3 = j2;
		System.out.println(j3 == 10);
		System.out.println(j3);
		
	}
	
}