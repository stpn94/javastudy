package chapter04.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new LinkedList<>();

		list.add("둘리");
		list.add("마이콜");
		list.add("도우넛");

		int count = list.size();
		for (int i = 0; i < count; i++) {
			String s = list.get(i);
			System.out.println(s);

		}
		list.remove(1);
		// 순회 2
		Iterator<String> it = list.iterator();

		while (it.hasNext()) {

			String s = it.next();
			System.out.println(s);
		}
		while (it.hasNext()) {

			String s = it.next();
			System.out.println(s);
		}

		// 순회 3 (for ~ each)
		for (String s : list) {
			System.out.println(s);

		}
	}

}