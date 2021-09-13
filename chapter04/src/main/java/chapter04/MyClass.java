package chapter04;

/*
Singletone + Factory Method Test
*/
public class MyClass {

	private static MyClass instance = null;

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