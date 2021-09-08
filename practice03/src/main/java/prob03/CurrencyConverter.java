package prob03;

public class CurrencyConverter {
	/* static 필드와 메소드를 이용하여 달러와 우리나라 원화 사이의 변환을 해주는 환율 계산기를 만들어 보세요 */

	private static double rate;

	public static double getRate() {
		return rate;
	}

	public static void setRate(double rate) {
		CurrencyConverter.rate = rate;
	}


	public static double toDollar(double d) {
		// 한국 원화를 달러로 변환
		return d*rate;
	}

	public static double toKRW(double d) {
		// 달러를 한국 원화로 변환
		return d*rate;
	}

}
