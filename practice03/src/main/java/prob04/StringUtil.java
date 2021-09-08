package prob04;

/*
 * 아래와 같은 출력이 나오도록 StringUtil 클래스를 완성하세요. 문자열 배열을 입력받아 하나 의 문자열로 연결하는 메소드를
 * 작성하십시오.
 * 
 * << 출력 결과 >> 결과 문자열 : SuperManBatManSpiderMan
 * 
 * 문제 설명 : 
 * 1 제시된 소스 코드에 주석으로 된 부분을 채워서 프로그램을 완성합니다. 
 * 2 String 배열 타입의 파라미터를 받습니다.
 * 3 인자로 받은 문자열 배열 요소를 하나의 문자열로 결합하고, 결과 문자열을 리턴 합니다.
 * 
 * 답안 작성 : 
 * - 본 문제는 prob1 패키지의 StringUtil.java 파일에 만들어 작성합니다. 
 * - 클래스명과 메소드 시그니쳐는 다음과 같으며 임의 변경 시 오답처리 됩니다.
 */
public class StringUtil {

	public static String concatenate(String[] strArr) {
		// 문자열을 결합하여 리턴 하는 메소드 구현
		String str = "";

		for (int i = 0; i < strArr.length; i++) {
			str += strArr[i];
		}
		return str;
	}

}
