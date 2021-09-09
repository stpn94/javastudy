package prob04;

public class Prob04 {
	/* 다음은 Employee클래스를 상속받아 Depart클래스를 구현합니다. Depart클래스를 구현할 때 실행결과를 참조합니다.
	<<주의사항>>
	1	Employee.java 와 Prob04.java클래스는 수정하지 않습니다.
	2	Depart클래스에 멤버변수를 String department변수외에 추가하지 않습니다.
	3	Depart클래스에서 생성자를  구현하지 않으면 감점, getInformation()메서드를 구현하지 않으면 감점.  감점요소가 2개면 오답으로 처리됩니다.
	4	컴파일이 안되거나 Exception이 발생하는 경우도 무조건 오답으로 처리됩니다.
	*/
	public static void main(String[] args) {
		Employee pt = new Depart("홍길동", 3000, "개발부");
		pt.getInformation();
	}
}