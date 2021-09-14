package collection;

import java.util.Stack;

public class StackTest {

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Stack<String> s = new Stack<>();
			
			s.push("둘리");
			s.push("마이콜");
			s.push("또치");
			
			while(!s.isEmpty()) {
				String str = s.pop();
				System.out.println(str);
				
			}
			
		//	s.pop(); -- 비어있는 겨우 예외 발생
			
			s.push("둘리");
			s.push("마이콜");
			s.push("또치");
			
			System.out.println(s.pop());
			System.out.println(s.peek());
			System.out.println(s.pop());
		}

}
