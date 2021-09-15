package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static final int PORT = 6000;

	public static void main(String[] args) {
		// 서버 소켓은 바깥에 클로즈()땜에
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(binding)
			// Socket Address(IP Address + Port)
			// 0.0.0.0 가능
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));
			// 로그 남기자
			log("started.. [port:" + PORT + "]");

			// 3. accept
//			while (true) {

			// 대기 상태 커넥트 하길 기다린다.
			Socket socket = serverSocket.accept(); // blocking

			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			// 도착
			// 보내주자

			// true하면 자동 플러시
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

//				new EchoServerReceiveThread(socket).start();

			while (true) {
				String data = br.readLine();
				if (data == null) {
					log("closed by client");
					// 조용히 빠져나온다
					break;
				}
				log("received : " + data);

				pw.println(data);
			}

		} catch (IOException e) {
			// 에러나면
			System.out.print("[server] error:" + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[EchoServer]" + log);
	}
}
