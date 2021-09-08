package paint;

public class ColorPoint extends Point {

	private String Color;

	public ColorPoint() {

	}

	public ColorPoint(int x, int y, String Color) {
		// TODO Auto-generated constructor stub
		super(x, y);
		this.Color = Color;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("점[x=" + getX() + ", y=" + getY() + ", color= " + Color + "]을 그렸씁니다.");
	}

}
