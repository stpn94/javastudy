package com.douzone.paint.shape;

public class Circle extends Shape {

	private int x1;
	private int y1;
	private int radius;

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("원을 그렷씁니다.");
	}

	public int calcPerimeter() {

		return (int) ((radius) * (2) * Math.PI);
	}

}