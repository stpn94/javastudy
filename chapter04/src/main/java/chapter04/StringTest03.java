package chapter04;

public class StringTest03 {
	public static void main(String[] args) {

		// String str = "Hello" + "World" + "Java" + 1000;
		String str = new StringBuffer("Hello").append("World").append("Java").append(1000).toString();

		System.out.println(str);

		// 주의 문자열 + 연산
		String str2 = "";
		// for(int i = 0; i < 100000; i++) {
		// str2 = str2 + i;
		// str2 = new StringBuffer(str2).append(i).toString();
		// }

		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 1000000; i++) {
			sb.append(i);
		}

		str2 = sb.toString();
		System.out.println(str2.length());
	}

}