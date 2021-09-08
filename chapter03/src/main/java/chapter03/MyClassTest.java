package chapter03;

public class MyClassTest {
	public static void main(String[] args) {

		try {
			MyClass myClass = new MyClass();
			myClass.danger();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
