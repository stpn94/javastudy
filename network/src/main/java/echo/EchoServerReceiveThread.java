package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;

	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remotePort = inetRemoteSocketAddress.getPort();

		System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		try {
			// 1. IOStream 생성(받아오기)
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));// 버퍼리더는 개행이
																											// 있어야 보냄
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"),
					true/* PrintWriter안에 버퍼가 차면 자동으로 flush */);

			while (true) {
				// 2. 데이터 읽기
				String data = br.readLine();

				if (data == null) {
					// Client가 소켓을 정상 종료
					System.out.println("[server] closed by client");
					break;
				}

				System.out.println("[server] received:" + data);
			}

		} catch (SocketException e) { // IOException의 자식
			// server 비정상 종료
			System.out.println("[server] suddenly closed by client");
		} catch (IOException e) {
			System.out.println("[server] error:" + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
