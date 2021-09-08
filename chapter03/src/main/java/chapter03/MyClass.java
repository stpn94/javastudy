package chapter03;

public class MyClass {

	public void danger() throws IOException{
		System.out.println("Some code 1");
		System.out.println("Some code 2");
		
		if(5-5 == 0) {			
			throw new IOException();
		}
		
		System.out.println("Some code 3");
		System.out.println("Some code 4");
		
		
	}
}