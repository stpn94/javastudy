package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient { 
	//private static final String SERVER_IP = "192.168.26.247";
	
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		//1. 키보드 연결
		//2. 소켓 생성 
		Socket socket = null;
		Scanner scanner = null;

		try {
			//1. 키보드 연결
			//2. 소켓 생성
			socket = new Socket();
			scanner = new Scanner(System.in);

			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, 6000));

			//4. reader/writer 생성
			PrintWriter pw = new PrintWriter((new OutputStreamWriter(socket.getOutputStream(), "UTF-8")), true);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			
			String join = "JOIN:";
			System.out.print("닉네임?");
			String nickname = scanner.nextLine();
			pw.println(join+nickname);
			
			//6. ChatClienReceiveThread 시작
			Thread chatClientThread = new ChatClientThread(br,nickname);
			chatClientThread.start();

			//7. 키보드 입력 처리
			while (true) {
				
				System.out.print( ">>" );
				String input = scanner.nextLine();

				//대소분자 상관없이 exit 치면 나감
				if ("exit".equals(input) || "EXIT".equals(input)) {
					// 8. quit 프로토콜 처리
					pw.println("exit:" + nickname);
					break;
				} else {
					//타자 치면 입력됨
					// 9. 메시지 처리
					pw.println("msg:" + input);
					ChatServerThread.log("msg:"+input);
				} 
			}
		} catch (IOException e) {
			System.out.println("[client] error 66 :" + e);
		} finally {
			//10. 자원정리
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				System.out.println("[client] error:" + e);
			}
		}
	}
}
