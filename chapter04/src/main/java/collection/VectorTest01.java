package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();

		v.addElement("홍길동");
		v.addElement("이종윤");
		v.addElement("마이콜");
		// 순회 1
		int count = v.size();
		for (int i = 0; i < count; i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		// 삭제
		v.removeElementAt(2);

		// 순회2
		Enumeration<String> e = v.elements();
		
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}

	}
}
