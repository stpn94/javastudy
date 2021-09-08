package chapter03;

public class ArrayUtil {

	// int 배열을 double 배열로 변환
	public static double[] intToDouble(int[] a) {
		double[] d = new double[a.length];

		for (int i = 0; i < d.length; i++) {
			d[i] = a[i];
		}

		return d;
	}

	// double 배열을 int 배열로 변환
	public static int[] doubleToInt(double[] d) {
		int[] a = new int[d.length];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) d[i];
		}

		return a;
	}

	// int 배열 두 개를 연결한 새로운 배열 리턴
	public static int[] concat(int[] a, int[] b) {
		// TODO Auto-generated method stub

		int[] result = new int[a.length + b.length];

		int index = 0;
		for (int i = 0; i < a.length; i++) {
			result[index++] = a[i];
		}

		for (int i = 0; i < b.length; i++) {
			result[index++] = b[i];
		}
		return result;
	}

}