package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	private String nickname;

	/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
	public ChatClientThread(BufferedReader br, String nickname) {
		this.br = br;
		this.nickname = nickname;
	}

	@Override
	public void run() {
		while (true) {
			String data = null;
			try {
				data = br.readLine();

				if ("join:ok".equals(data)) {
					System.out.println("[client] connnect complete");
					continue;
				}
				System.out.println(data);

			} catch (IOException e) {
				System.out.println("\r\n[client] closed by client");
				break;
			}
		}
	}
}
