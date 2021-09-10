package chapter04;

import java.util.HashSet;

public class ObjectTest03 {

	public static void main(String[] args) {

		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);

		HashSet<Point> set = new HashSet<Point>();

		set.add(p1);
		System.out.println(set.size());

		set.add(p2);
		System.out.println(set.size());

	}

}
