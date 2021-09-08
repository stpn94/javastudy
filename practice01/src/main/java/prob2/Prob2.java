package prob2;

public class Prob2 {
		public static void main(String[] args) {
			
			/* 출력 값이 다음과 같도록 Prob2 클래스의 main 메쏘드를 완성하십시오. */
			/*1 2 3 4 5 6 7 8 9 10
              2 3 4 5 6 7 8 9 10 11
              3 4 5 6 7 8 9 10 11 12
              4 5 6 7 8 9 10 11 12 13
              5 6 7 8 9 10 11 12 13 14
              6 7 8 9 10 11 12 13 14 15
              7 8 9 10 11 12 13 14 15 16
              8 9 10 11 12 13 14 15 16 17
              9 10 11 12 13 14 15 16 17 18
            */
			for(int i=1; i<11; i++ ) {
				
				System.out.print(i+" ");
				for(int j=i+1; j<10+i;j++) {
					System.out.print(j+" ");
					
				}
				System.out.println();
		}
	}
}
