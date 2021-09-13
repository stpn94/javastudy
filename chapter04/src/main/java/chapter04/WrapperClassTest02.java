package chapter04;

public class WrapperClassTest02 {
	
	public static void main(String[] args) {
		
		String s = "123456";
		int i = Integer.parseInt(s);
		
		//cf
		String s2 =String.valueOf(i);
		
		System.out.println(s + ":" + s2);
		
		int a = Character.getNumericValue('F');
		
		System.out.println(a);
		
	}

}