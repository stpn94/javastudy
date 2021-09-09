package prob02;

/*	1.	멤버변수는 다음과 같으며 모든 멤버 변수는 초기값을 지정하지 않습니다.
		int bookNo: 번호
		String title: 제목
		String author: 작가
		int stateCode: 상태코드(대여유무를 나타내는 상태코드)
	2.	생성자는 BookShop의 main메소드를 참고하여 각 멤버변수를 초기화할 수 있도록 작업합니다. 단, stateCode는 생성자 호출 시에 1로 세팅 되도록 설정합니다.
	3.	각각의 메소드는 아래의 기능을 구현하도록 작성합니다.
		-	모든 메소드는 public으로 작성합니다.
		-	bookNum, title, genre에 대해서는 모든 setter/getter메소드를 추가하세요.
		-	rent() : 대여기능을 수행하는 메소드로 
			Book클래스의 stateCode를 0으로 변경하며  “_______이(가) 대여 됐습니다.”메시지가 출력되도록 작성합니다.이때 ______는 책제목이 출력되도록 작성합니다.
		-	print(): 책의 정보가 출력형태와 같이 출력될 수 있도록 작성합니다. 이때 대여 유무는 Book클래스의 stateCode가 1이면 “재고있음”으로 0이면 “대여중”으로 출력되도록 설정합니다.
	
	BookShop클래스
	주어진 소스에 표시된 (1)과 (2)에 해당하는 내용을 아래의 조건에 맞게 작성합니다.
	1.	(1)의 부분은 BookShop.java에서 입력받은 책 번호에 해당 책을 배열에서 찾아 rent메소드가 호출되도록 작성합니다.
	2.	(2)의 부분은 메소드의 매개변수로 전달된 배열에 저장된 모든 Book 객체의 정보를 출력할 수 있도록 작성합니다.
	
	<<주의사항>>
	1.	주어진  BookShop.java는 수정하지 않습니다.
	2.	멤버변수에 초기값을 지정하지 마십시오
	3.	Book클래스의 rent메소드에서 stateCode를 변경해야 합나다.
	4.	Book클래스의 print메소드의 실행결과가 주어진 조건과 맞게 출력하도록 하세요
*/
public class Book {
	private int bookNo;
	private String title;
	private String author;
	/* stateCode는 생성자 호출 시에 1로 세팅 되도록 설정합니다. */
	private int stateCode;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookNo, String title, String author) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = stateCode + 1;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void rent() {
		if (this.stateCode == 0) {
			System.out.println(this.title + "이(가) 재고가 없습니다.");
		} else {
			this.stateCode = 0;
			System.out.println(this.title + "이(가) 대여 됐습니다.");
		}
	}

	public void print() {
		System.out
				.println(String.format("[책 제목=%s, 작가=%s, 대여 유무=%s]", title, author, (stateCode == 1 ? "재고있음" : "대여중")));
	}

}
