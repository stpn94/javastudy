package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {
//로컬호스트 == 컴퓨터
	public static void main(String[] args) {
		//InetAddress = IpAddress"0,0,0,0"
		//InetSoketAddress = port(+제어정보) + IpAddress
		try {
			//InetAddress 클래스 생성..
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			
			//컴퓨터(호스트)의 이름
			System.out.println(inetAddress.getHostName());
			//IP주소
			System.out.println(inetAddress.getHostAddress());
			
			byte[] addresses = inetAddress.getAddress();
			
			for(byte address : addresses ) {
//				System.out.println((int)address);
				System.out.println(address & 0x000000ff);
				System.out.print('.');
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
