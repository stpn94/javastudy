package prob06;

public abstract class Cal {
	private int a;
	private int b;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public abstract void calculate();
}
