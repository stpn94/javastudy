package chapter04;


public class ObjectTest01 {
	public static void main(String[] args) {
		
		Point p = new Point(1,2);
		
		System.out.println(p.getClass()); //reflection -> 객체의 정보, 설계도룰 가져오는거
		System.out.println(p.hashCode()); //reference value -> X, address 기반의 해싱 값 -> 0
		
		System.out.println(p);
		System.out.println(p.toString()); //getclass() "@" + hashcode() 16진수값
	}
}
