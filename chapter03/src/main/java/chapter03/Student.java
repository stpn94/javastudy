package chapter03;

public class Student extends Person {

	public Student() {
		// 맨앞에 무조건 부조 생성자가 불린다. 명시하지 않으면 기본 생성자를 앞에 세팅
		// super();
		super("둘리");
		System.out.println("자식 호출");

	}

	public void test() {
		// name = "둘리"; 자식에서 private 필드,메소드 접근 불가
		height = 140;
		// 자식에서 protected 필드,메소드 접근 가능
		weight = 30;
		// 자식에서 public 필드, 메소드 접근 가능
	}
}