package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer { 
	private static final int PORT = 6000;

	public static void main(String[] args) {
		ChatServerThread.log("시작");
		List<Writer> listWriters = new ArrayList<>();
		ServerSocket serverSocket = null;
		/*
		 * - Main Thread의 주요코드 - 클라이언트로 부터 연결 요청을 기다린다. - 클라이언트와 연결된 후, 클라이언트와 채팅 데이터
		 * 통신은 ChatServerTread가 한다.
		 */

		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(binding) : Socket Address(IP Address + Port)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));

			// 3. accept 요청대기
			while (true) {
				Socket socket = serverSocket.accept(); // blocking
				ChatServerThread.log("쓰레드시작");
				new ChatServerThread(socket,listWriters).start();
			}
		} catch (IOException e) {
			System.out.print("[server]35 error:" + e);
		} finally { 
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
