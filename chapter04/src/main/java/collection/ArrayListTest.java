package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ArrayListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("홍길동");
		list.add("이종윤");
		list.add("마이콜");

		int count = list.size();
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		list.remove(1);
		// 순화 2
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		//순회 3(FOR-EACH)
		for(String s : list) {
			System.out.println(s);
		}
	}
}
