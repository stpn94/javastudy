package paint;

import java.awt.Point;
import java.awt.Shape;

public class Main {
	public static void main(String[] args) {
		int x = 100;
		int y = 200;

		Point point1 = new Point();
		point1.setX(x);
		point1.setY(y);

		Point point2 = new Point(50, 50);

		draw(point1);
		draw(point2);
		point1.show(false);

		System.out.println("=================");

		Point point3 = new ColorPoint();
		point3.setX(30);
		point3.setY(50);
		((ColorPoint) point3).setColor("blue");

		draw(point3);

		Point point4 = new ColorPoint(10, 20, "yellow");
		draw(point4);
		System.out.println("=================");

		draw(new Rect());

		System.out.println("=================");

		draw(new Triangle());

		System.out.println("=================");

		draw(new Circle());

		System.out.println("=================");
		draw(new GraphicText("Hi~"));

		System.out.println("========instanceof=========");

		Circle Circle = new Circle();
		System.out.println(Circle instanceof Circle);
		System.out.println(Circle instanceof Shape);
		System.out.println(Circle instanceof Object);
		System.out.println(Circle instanceof Drawable);
		// System.out.println(Circle instanceof Triangle);
		// 오류 class는 hierachy 구조에서 상위, 하위 클래스만 instanceof 연산자를 사용할수잇따.
		// System.out.println(circle instanceof rect);

		System.out.println("========instanceof2=========");
		Shape s = new Circle();
		System.out.println(s instanceof Circle);
		System.out.println(s instanceof Shape);
		System.out.println(s instanceof Object);
		System.out.println(s instanceof Drawable);
		System.out.println(s instanceof Triangle);

		System.out.println("========instanceof3=========");
		// Interface Tpye 이면 Hierachy 구조 상관없이다 확인 할수 있다
		Drawable d = new Triangle();
		System.out.println(d instanceof Circle);
		System.out.println(d instanceof Shape);
		System.out.println(d instanceof Object);
		System.out.println(d instanceof Drawable);
		System.out.println(d instanceof Triangle);
		System.out.println(d instanceof Runnable);

	}

	public static void draw(Drawable draw) {

		draw.draw();
	}

}
