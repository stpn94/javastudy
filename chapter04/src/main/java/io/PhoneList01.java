package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			File file = new File("pom.xml");

			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}
			System.out.println("=====================파일 정보==========================");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			long timestamp = file.lastModified();
			System.out.println(new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(timestamp));

			// 기반 스트림
			FileInputStream fis = new FileInputStream(file);
			// 보조스트림 바이트 -> 캐릭터
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			// q보조스트림 라인단위 입력
			br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) {
				//tap과 spacebar썼기 때문에 토클라이져를 써야한다.
				StringTokenizer st = new StringTokenizer(line, "\t ");
				int index = 0;

				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if (index == 0) { // 이름 뒤
						System.out.print(token + ":");
					} else if (index == 1) { // 전번 1 
						System.out.print(token + "-");
					} else if (index == 2) { // 전번 2
						System.out.print(token + "-");
					} else if (index == 3) { // 전번 3
						System.out.print(token);
					}
					index++;
				}
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {

			try {
				if (br != null) {

					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}