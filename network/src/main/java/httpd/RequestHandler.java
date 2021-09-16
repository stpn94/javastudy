package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENTROOT = "./webapp";
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// Output 다리 만들기
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8")); // input 다리
																												// 만들고
																												// 버퍼리더
																												// 붇이기

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog(
					"연결됨 1 : " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort());

			// 리퀘스트
			String request = null;

			while (true) {
				String line = br.readLine();

				// 브라우저가 연결을 끊으면,
				if (line == null) {
					break;
				}

				// Request Header만 읽음
				if ("".equals(line)) {
					break;
				}

				// 첫 번째 라인만 처리
				if (request == null) {
					request = line;
					break;
				}
			}

			// 요청 처리

			String[] tokens = request.split(" ");

			// GET 이면
			if ("GET".equals(tokens[0])) {
				consoleLog("리퀘스트 2 : " + tokens[1]);
				consoleLog("리퀘스트 3 : " + tokens[2]);
				
				responseStaticResource(os, tokens[1], tokens[2]); // 아웃풋 스트림에 담아서 보낸다.
			} else {

				// methods: POST, PUT, DELETE, HEAD, CONNECT
				// Simple Http Server 에서는 무시
				response400Error(os, tokens[1], tokens[2]); // 400에러를 보낸다.
			}
		} catch (Exception ex) {
			consoleLog("오류났다 4 : " + ex);
		} finally {
			// clean-up 소켓닫자
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException ex) {
				consoleLog("오류났다 5 :" + ex);
			}
		}
	}

	private void responseStaticResource(OutputStream os, String url, String protocol) throws IOException {
		// os= 다리, 토큰1= url, 토큰2 =프로토콜
		// 웰컴 파일 셋
		// 슬라이스와 URI가 똑같으면(아무것도 안적으면)
		if ("/".equals(url)) {
			url = "/index.html";
		}
		//웹엡에있는 url을 file에 담는다
		File file = new File(DOCUMENTROOT + url);
		
		if (file.exists() == false) {
			response404Error(os, url, protocol);
			return;
		}

		// nio
		// 바디에 파일 정보 들을 담는다
		byte[] body = Files.readAllBytes(file.toPath());
		consoleLog("바디 9 : ");
		// 바디에 파일 정보 들을 담는다
		String contentType = Files.probeContentType(file.toPath());
		
		os.write((protocol + " 200 OK\r\n").getBytes("UTF-8")); //HTTP/1.1 + 200 OK
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
	}

	private void response400Error(OutputStream os, String url, String protocol) throws IOException {
		//웹엡의 에러의 400html을 연다
		File file = new File(DOCUMENTROOT + "/error/400.html");
		// 없으면
		if (file.exists() == false) {
			// 404 에러
			response404Error(os, url, protocol);
			return;
		}
		
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		os.write((protocol + " 400 Bad Request\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
	}

	private void response404Error(OutputStream os, String url, String protocol) throws IOException {

		File file = new File(DOCUMENTROOT + "/error/404.html");
		if (file.exists() == false) {
			response404Error(os, url, protocol);
			return;
		}

		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		os.write((protocol + " 404 File Not Found\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}