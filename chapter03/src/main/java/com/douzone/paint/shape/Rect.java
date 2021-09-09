package paint;

public class Rect extends Shape {
	
	int x1;
	int y1;
	int x2;
	int y2;
	
	
	@Override
	public void draw(){
		
		System.out.println("사각형을 그렸습니다.");
		
	}
	
	public int calcPerimeter() {
		
		return (x2-x1)*2 + (y2-y1)*2;
	}



}