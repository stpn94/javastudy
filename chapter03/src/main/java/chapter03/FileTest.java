package chapter03;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is =null;
		
		try {
			is = new FileInputStream("./hello.txt");
			is.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}