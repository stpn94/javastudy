package chapter03;

public class GoodApp {
	public static int i = 0;

	public static void test() {

	}

	public static void main(String[] args) {
		// Goods 클래스를 정의하고 GoodsApp 에서  Goods 클래스를 테스트 하세요.
		//1) Goods 객체를 하나 생성하고 이 객체에 대한 레퍼런스 변수를 camera 로 합니다.
		//2) 이 객체의 데이터인 각 각의 인스턴스 변수는 다음과 같은 값을 가지도록 합니다. 
		//상품이름 : “nikon”,   가격: 400,000, 재고개수: 30, 팔린 개수: 50
		//3) 값을 세팅 한 후,  객체의 값을 출력해 보세요.


		Goods camera = new Goods();

		camera.setCountSold(50);
		camera.setCountStock(30);
		camera.setName("Nikon");
		camera.setPrice(400000);

		System.out.println(camera);

		//제품 정보
		camera.showInfo();
		//Goods 클래스에 파라미터로 할인율을 입력 받고 반환 값으로 할인 가격을 반환하는 메소드를 구현하고 테스트 합니다.
		System.out.println(camera.calculateDiscountPrice(50)+"만원");

	}
}
