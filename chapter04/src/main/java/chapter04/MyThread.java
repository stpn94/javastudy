package chapter04;

import java.util.List;

public class MyThread extends Thread {
	List list = null;

	public MyThread(List list) {
		this.list = list;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		// 멀티 쓰레드 환경에서 syncronize(){} --> ArrayList 사용 할때 쓰레드 블락킹 처리 필요.
		// 멀티 쓰레드 환경에서 vector 는 메소드 syncronize(){} 작업의 되어있다
	}

}