package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PhoneList02 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			File file = new File("pom.xml");

			if (!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}
			System.out.println("=====================파일 정보==========================");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length());
			long timestamp = file.lastModified();
			System.out.println(new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(timestamp));

			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {

				String name = scanner.next();
				String phone1 = scanner.next();
				String phone2 = scanner.next();
				String phone3 = scanner.next();

				System.out.println(name + " : " + phone1 + "-" + phone2 + "-" + phone3);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("에러:" + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}