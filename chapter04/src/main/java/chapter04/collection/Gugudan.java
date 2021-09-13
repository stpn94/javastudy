package chapter04.collection;

import java.util.Objects;

public class Gugudan {

	private int left;
	private int right;

	public Gugudan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gugudan(int left, int right) {
		super();
		this.left = left;
		this.right = right;
	}

//헤시 코드를 만들어서 비교해야한다.
	// 해시 코드를 보려면 left와 right를 비교한 값을 만든다.
	@Override
	public int hashCode() {
		return Objects.hash(left * right);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gugudan other = (Gugudan) obj;
		return left * right == other.left * other.right;
	}

	@Override
	public String toString() {
		return "Gugudan [left=" + left + ", right=" + right + "]";
	}

}
