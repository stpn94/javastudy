package chapter03;

public class Goods {
	
	//정보은닉을 위해 보통 클래스의 필드들은 private으로 지정합니다. Goods클래스의 필드들을 private으로 지정하고 생성된
	//객체의 인스탄스 변수의 값을 세팅하기 위한 setter getter 메소드들을 작성하고 테스트 합니다.

	private int price;
	private int countSold;
	private int countStock;
	private String name;
	
	//Goods 에 클래스 변수 countOfGoods를 추가 하고  공유변수로 사용하는 실습을 합니다.
	//생성자에서 증가 시키고  새 객체를 생성할 때 마다 값 변화를 확인합니다.
	//인스턴스 변수였을 때와 차이를 생각해 보고 이해하도록 합니다.  

	public static int countofGoods = 0;
		
	public Goods(int price, int countSold, int countStock, String name) {
		this();
		this.price = price;
		this.countSold = countSold;
		this.countStock = countStock;
		this.name = name;
	}

	public Goods() {
		countofGoods = countofGoods + 10;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Goods의 정보를 화면에 출력하는 public void showInfo() 메서드를 작성하고 테스트 합니다.
	public void showInfo() {
		
		System.out.println(
				"상품이름 : " + name +
				", 가격 : " + price +
				", 재고개수 : " + countStock +
				", 팔린 갯수 : " + countSold
				);
		
	}
	//Goods 클래스에 파라미터로 할인율을 입력 받고 반환 값으로 할인 가격을 반환하는 메소드를 구현하고 테스트 합니다.
	public int calculateDiscountPrice(double percentage) {
		return (int)(price * percentage/100);
	}
	
}