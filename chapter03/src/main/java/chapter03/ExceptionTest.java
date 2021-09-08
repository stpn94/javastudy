package chapter03;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
			1. 예외 실행 : 코드 -> try -> catch(에외 처리) -> finally(지원 정리)
			2. 정살 실행 : 코드 -> try -> finally(자원 정리) -> 코드
		
		
		*/
		
		int a = 10;
		int b = 10 - a;

		try {

			System.out.println("some codes1....");
			//int result = (1 + 2 + 3)/b;
			System.out.println("some codes2....");
		} catch (ArithmeticException e) {
			// TODO: handle exception
			//1. 사과
			System.out.println("죄송합니다. 프로그램이 비정상 종료합니다. 다시 실행해주세요.");
			
			//2. 로그 남기기(파일, DB) - ★
			System.out.println(e);
			System.out.println("0으로 나눌수가 없습니다");
			
			//3. 정상 종료
			return;
			
		} finally {
			
			System.out.println("ㅃ2");
		
		}
		
		System.out.println("wprlf");
	}

}