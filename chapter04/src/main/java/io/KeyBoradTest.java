package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyBoradTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		// 기반 스트림 (표쥰 입력, stdio, system.in or out)
		InputStreamReader isr;
		try {
			// 보조 스트림 (byte|byte|byte - > char)
			isr = new InputStreamReader(System.in, "utf-8");
			// 보조스트림2(char|char|char|\n -> "char char char"
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if ("exit".equals(line)) {
					break;
				}
				System.out.println(line);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}