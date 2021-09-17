package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {

	// 포트 충돌은 프로토콜이 같을 때에 일어남 ㅇㅇ
	public static final int PORT = 7000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		// 1. 소켓 생성
		try {
			socket = new DatagramSocket(PORT);

			// 2. 데이터 수신
			// Receive packet
			// 데이터가 도착하게 되면 여기로 복사됌!!

			while (true) {

				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket);

				byte[] receiveData = receivePacket.getData();
				int length = receivePacket.getLength();
				String message = new String(receiveData, 0, length, "utf-8");
				
				System.out.println("[server] : " + message);
				
				
				// 3. 에코니깐 데이터 송신도 해야지 
				
				byte[] sendData = message.getBytes("utf-8");
				DatagramPacket sendPacket = new DatagramPacket(
						sendData, 
						sendData.length, 
						receivePacket.getAddress(),
						receivePacket.getPort());
				
				socket.send(sendPacket);
				

			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
	}

}
