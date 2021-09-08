package chapter03;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();

		Person p = s; /// upcasting. 암시적
		Student s2 = (Student) p; // 다운 캐스팅 , explictity
	}

}