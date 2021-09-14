package collection;

import java.util.HashSet;
import java.util.Set;

/*문제 힌트 및 제한 :  
1.	문제식은 구구단의 곱셈 중에 랜덤하게 출력되어야 한다.
2.	답을 포함 81보다 작은 9개의 정수가 그림과 같은 형태로 출력되어야 한다.
3.	사용자의 답을 입력 받아야 한다.
4.	결과“정답” 또는 “오답”을 출력하여야 한다.
5.	문제에서 주어진 코드의 주석으로 처리된 부분을 완성해서 오류를 모두 수정해야 하고 출력결과도 문제가 원하는 출력결과가 나와야 한다.
*/
public class HashSetTest02 {
	public static void main(String[] args) {
		// 아무 수 x
		// 구구단 객체
		// 결과값이 같으면 안됨
		// 이꼴 조건을
		Set<Gugudan> s = new HashSet<>();

		s.add(new Gugudan(2, 3));
		s.add(new Gugudan(9, 9));
		// 못 들어가게
		s.add(new Gugudan(3, 2));

		// 순회
		for (Gugudan d : s) {
			System.out.println(d);
		}

	}
}
