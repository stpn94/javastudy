package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;

		try {
			is = new FileInputStream("hello.txt");
			int data = is.read();
			System.out.println((char) data);
		} catch (FileNotFoundException e) {
			System.out.println("error:"+e);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error:"+e);
//			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}