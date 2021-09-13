package prob5;

public class MyStack {
	private String[] stringArr;
	private int top = -1;

	public MyStack(int i) {
		stringArr = new String[i];
	}

	// 넣는 것
	public void push(String string) {
		if (stringArr.length - 1 <= top) {
			System.out.println("꽉참");
			String[] newArr;
			newArr = new String[stringArr.length * 2];
			for (int i = 0; i < stringArr.length; i++) {
				newArr[i] = stringArr[i];
			}
			this.stringArr = newArr;
		}
		stringArr[++top]=string;
	}

	// 뽑아 내는 것
	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException("is empty");
		}
		return stringArr[top--];
	}

	public boolean isEmpty() {
		return top<0;
	}
}