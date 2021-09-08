package prob02;

import java.util.Scanner;

public class GoodsApp {
	/*
	 * java.util.Scanner 클래스를 이용하여 상품을 입력받아 Goods 객체를 생성하고 이들을 Goods 객체 배열에 저장하세요.
	 * 상품 즉, Goods 객체를 3개 입력 받으면 이들을 모두 화면에 출력하세요.
	 */
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < COUNT_GOODS; i++) {
			String line = scanner.nextLine();
			String[] index = line.split(" ");
			String name = index[0];
			int price = Integer.parseInt(index[1]);
			int stock = Integer.parseInt(index[2]);
			goods[i] = new Goods(name, price, stock);
			System.out.println(i);
		}
		
		// 상품 출력
		for(int i =0; i<COUNT_GOODS;i++) {
			System.out.println(goods[i].getName()+ "(가격:" + goods[i].getPrice() +"원)이" + goods[i].getStock()+"개 입고 되었습니다.");
		}

		// 자원정리
		scanner.close();
	}
}
