
package httpd;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	private static final int PORT = 8888;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			// 1. 서버 소켓 만든다.
			serverSocket = new ServerSocket();
			   
			// 2. 서버소켓의 바인드기능을 사용해 PORT번호와 주소를 묶어준다.
			serverSocket.bind(new InetSocketAddress( "0.0.0.0", PORT ));
			consolLog("starts... [port:" + PORT + "]");

			//시작
			
			while (true) {
				// 3. 접촉을 기다린다.( accept )
				Socket socket = serverSocket.accept();

				// 4. 리퀘스트 핸들러에 소켓을 위임해서  Processing Request
				new RequestHandler(socket).start();
			}

		} catch (IOException ex) {
			consolLog("error:" + ex);
		} finally {
			// 5. 자원정리
			try {
				//소켓이 널이 아니고 소켓이 닫혀 있으면 소켓을 닫는다
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				consolLog("error:" + ex);
			}
		}
	}

	public static void consolLog(String message) {
		System.out.println("[HttpServer#" + Thread.currentThread().getId()  + "] " + message);
	}
}