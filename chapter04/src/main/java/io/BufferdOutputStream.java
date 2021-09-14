package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferdOutputStream {
	public static void main(String[] args) {
		BufferedOutputStream bos = null;

		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			bos = new BufferedOutputStream(fos);
			for (int i = 'a'; i <= 'z'; i++) {

				bos.write(i);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}