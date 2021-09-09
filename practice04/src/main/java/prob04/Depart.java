package prob04;

public class Depart extends Employee{
	private String department;

	Depart(String name, int salary, String department) {
		super(name,salary);
		this.department = department;
	}
	

	public void getInformation() {
		super.getInformation();
		System.out.println(" 부서 : "+ department);
	}

}
