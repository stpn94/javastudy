package chapter04;

/*
Singletone + Factory Method Test
*/
public class MyClass {

	private static MyClass instance = null;
//Fractory는 싱클톤을 유지하기 위해 만들었음

	private MyClass() {
		int i = 10;
		final int j = 20;

	}

	public static MyClass getInstance() {
		if (instance == null) {
			instance = new MyClass();
		}

		return instance;
	}
}