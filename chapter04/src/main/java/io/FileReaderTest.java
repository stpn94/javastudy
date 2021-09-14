package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader in = null;
		InputStream is = null;
		try {
			in = new FileReader("1234.txt");
			is = new FileInputStream("1234.txt");
			int data = -1;
			int count = 0;
			while ((data = in.read()) != -1) {
				System.out.print((char) data);
				count++;
			}
			System.out.println();
			System.out.println(count);
			System.out.println("=================================================");
			count = 0;
			while ((data = is.read()) != -1) {
				System.out.print((char)data+" ");
				count++;
			}
			System.out.println();
			System.out.println(count);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("에러");

		} finally {

			try {
				if (in != null) {
					in.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Aut0.o-generated catch block
				e.printStackTrace();
			}
		}
	}
}