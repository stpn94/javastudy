package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
//	http://220.119.26.29/ 선생님아이피
	// 127.0.0.1 = 내 아이피
	// 친구아이피 적으면 친구껄로 간다.
//	private static final String SERVER_IP = "127.0.0.1";
	private static final String FRIEND_IP = "210.113.134.216";

	public static void main(String[] args) {
		Socket socket = null;
		// 스케너 선언
		Scanner scanner = null;
		try {
			// 1. Scanner 생성(표준입력, 키보드 연결)
			scanner = new Scanner(System.in);

			// 2. 소켓 생성
			socket = new Socket();

			// 3. 서버 연결dk
			socket.connect(new InetSocketAddress(FRIEND_IP, EchoServer.PORT));
			log("[Client] connected!");

			// 4. IOStream 생성(받아오기) 파이프라인
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));// 버퍼는 개행이
																											// 있어야 보냄
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"),
					true/* PrintWriter안에 버퍼가 차면 자동으로 flush */);

			while (true) {
				// 5. 쓰기
				System.out.print(">>");
				String line = scanner.nextLine();

				// 탈출 조건 만들기
				if ("quit".equals(line)) {
					break;
				}

				// 6. 소켓쓰기
				pw.println(line);

				// 7. 읽기
				String data = br.readLine();

				if (data == null) {
					// Client가 소켓을 정상 종료
					System.out.println("[client] closed by client");
					break;
				}

				System.out.println("<<" + data);
			}
		} catch (IOException e) {
			log("[Client] error:"+ e +" ");
		} finally {
			try {
				// 스캐너가 널이 아니면 닫는다
				if (scanner != null) {
					scanner.close();
				}
				// 소켓이 널이 아니고 소켓이 닫혀있는게 아니면 소케을 닫는다.
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void log(String log) {
		System.out.println("[EchoClient]" + log);
	}
}
