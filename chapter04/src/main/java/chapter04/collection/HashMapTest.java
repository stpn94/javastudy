package chapter04.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		map.put("one", 1); // auto boxing
		map.put("two", 2); // auto boxing
		map.put("three", 3); // auto boxing

		int i = map.get(new String("two")); // auto unboxing
		int j = map.get("one");

		System.out.println(i + ";" + j);

		map.put("three", 33333333); // auto boxing
		System.out.println(map.get("three"));

		Set<String> s = map.keySet();
		for (String key : s) {
			int value = map.get(key);
			System.out.println(value);
		}

	}
}