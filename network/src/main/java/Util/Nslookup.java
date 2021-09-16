package Util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Nslookup {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		while (true) {

			try {

				System.out.print(">> ");
				String line = scanner.nextLine();

				// 이름으로 아이피를 물어볼수있다
				if ("exit".equals(line)) {
					break;
				}
				// 이 안에 ip address가 들어있

				// named에 ㄹ
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);

				for (InetAddress inetAddress : inetAddresses) {
					System.out.println(line + ":" + inetAddress.getHostAddress());
				}

			} catch (UnknownHostException ex) {
				System.out.println("unknown host");

			}

		}
		scanner.close();
	}
}
