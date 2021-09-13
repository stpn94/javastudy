package chapter04.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

		public static void main(String[] args) {
			Queue<String> q = new LinkedList<>();

			q.offer("둘리");
			q.offer("마이콜");
			q.offer("또치");

			while (!q.isEmpty()) {

				String s = q.poll();
				System.out.println(s+" 1");

			}

			// 비어있는 경우, null을 리턴
			System.out.println(q.poll()+"  2");

			q.offer("둘리");
			q.offer("마이콜");
			q.offer("또치");
			System.out.println(q.poll()+"   3");
			System.out.println(q.poll()+"     5");
			System.out.println(q.peek()+"    4");

		}
}
