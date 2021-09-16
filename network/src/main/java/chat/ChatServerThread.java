package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ChatServerThread extends Thread {
	/*
	 * 스레드의 인스턴스 변수 - 통신을 위한 스트림을 얻어 오기 위해 Socket 객체를 저장해야 한다. - 연결된 클라이언트의 닉네임을
	 * 저장하고 있어야 한다.
	 */ 
	private Socket socket;
	private String nickname;
	private List<Writer> listWriters; 
	Scanner scanner = null;
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	/*
	 * 요청 처리를 위한 Loop 작성 - run 메소드 오버라이딩 - main thread로 부터 전달받은 socket를 통해 IO
	 * Stream을 받아오는데 문자 단위 처리와 라인 단위 읽기를 위해 보조 스트림 객체를 생성해서 사용한다.
	 */

	@Override
	public void run() {
		// 1. Remote Host Information(호스트 정보)
		//
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remotePort = inetRemoteSocketAddress.getPort();

		log("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		// 2. 스트림 얻기
	
		try {
			BufferedReader br = null;
			PrintWriter pw = null;
			// IOStream 생성(받아오기)
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // PrintWriter안에 버퍼가
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8")); // 버퍼리더는 개행이 있어야 보냄
																									// 차면 자동으로 flush

			// 3. 요청처리
			while (true) {
				log("요청처리 시작");
				
				// 데이터 읽자.
				String request = br.readLine();
				
				log(" 데이터 읽자");
				if (request == null) {
					// 응답없으면
					System.out.println("나감");
					log("[server]61 closed by client[" + remoteHostAddress + ":" + remotePort + "]");
					break;
				}

				// 4. 프로토콜 분석
				/*
				 * - chat 프로토콜 형식 - 요청명령: 파라미터1: 파라미터2: … \r\n - 각 요청을 구분하는 경계가 되는 것은 \r\n 이다. -
				 * 요청은 “:” 기준으로 요청명령과 파라미터로 분리한다. - 각 각의 요청명령을 처리하는 메서드를 구현하고 호출한다.
				 */
				// 토큰 생성
				String[] tokens = request.split(":");
				log("토큰생성");
				// 첫 번째 라인만 처리
				if ("JOIN".equals(tokens[0])) {
					log("74");
					doJoin(tokens[1], pw);
				} else if ("msg".equals(tokens[0])) {
					log("77");
					doMessages(tokens[1]);
				} else if ("exit".equals(tokens[0])) {
					System.out.println("나갔다");
					log("80");
					log("[server] \"" + request + "\" has left");
					doExit(pw);
					break;
				} else {
					log("[server85] error request:" + request);
				}
			}
		} catch (IOException e) {
			
			log("[server87] error:" + e);
		}
	}

	private void doExit(Writer writer) {
		removeWriter(writer);

		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);

	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}

	}

	private void doMessages(String mesg) {
		/* 잘 구현 해보기 */
		broadcast(nickname + ":" + mesg);
	}

	private void doJoin(String nickname, PrintWriter pw) {
		/*
		 * - 프로토콜 “join:nickname \r\n” - 1번째 파라미터 nickname을 thread 객체 변수로 저장한다. - writer
		 * pool에 현재 스레드의 writer 인 printWriter를 저장해야 한다.
		 * 
		 */

		/*
		 * - doJoin은 한 사용자가 채팅 방에 참여 했을 때, 다른 사용자들에게 “OOO님이 입장하셨습니다.” 라는 메세지를
		 * 브로드캐스팅해야한다. - ack를 보내 방 참여가 성공했다는 것을 클라이언트에게 알려 줘야 한다.
		 */
		this.nickname = nickname;


		String data = nickname + "님이 참여하였습니다.";
		broadcast(data);
		// writer pool에 저장
		addWriter(pw);

		// ack
		pw.println("join:ok");

	}

	private void addWriter(Writer writer) {
		/*- addWriter 메소드의 구현 예시
		  - List인  Writer Pool 에  파라미터로  받은 Writer를 추가한다.
		  - synchronized  키워드는  여러 스레드가  하나의 공유 객체에 접근할  때,  동기화를 보장 해준다. 
		*/
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void broadcast(String data) {
		/*
		 * - 서버에 연결된 모든 클라이언트에 메시지를 보내는(브로드캐스트) 메소드 - 스레드간 공유 객체인 listWriters 에 접근 하기
		 * 때문에 동기화 처리를 해 주어야 한다. - PrintWriter의 메서드를 사용해야 하기 때문에 다운 캐스팅을 명시적으로 해주었다.
		 */
		synchronized (listWriters) {
			log("broadcast 통과");
			for (Writer writer : listWriters) {
				PrintWriter pw = (PrintWriter) writer;
				pw.println(data);

			}
		}
	}

	static void log(String log) {
		System.out.println("[Server]" + log);
	}
}
