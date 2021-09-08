package chapter03;

public class SwapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Value a = new Value(10);

		Value b = new Value(20);

		System.out.println(a.val + ":" + b.val);
		swap(a, b);
		System.out.println(a.val + ":" + b.val);

	}

	public static void swap(Value m, Value n) {

		int temp = m.val;
		m.val = n.val;
		n.val = temp;

	}
	

}