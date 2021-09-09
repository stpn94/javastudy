package paint;

public class Point implements Drawable {
	private int x;
	private int y;

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		show(true);
	}

	public Point(int x, int y) {
		// TODO Auto-generated constructor stub

		this.x = x;
		this.y = y;
	}

	public Point() {
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void show() {

		System.out.println("점[x=" + x + ", y" + y + "]을 그렸씁니다.");

	}

	public void show(boolean visible) {
		if (visible) {
			show();

		} else {
			System.out.println("점[x=" + x + ", y" + y + "]을 지웟씁니다.");

		}

	}
}