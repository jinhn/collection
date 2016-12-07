package kr.jhta.bookstore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * <p>도서 대여점의 주요 기능을 구현한 클래스
 * 
 * <p>도서 대여점의 회원가입, 로그인, 로그아웃, 대여, 반납, 조회기능을 구현
 * @author 홍길동
 *
 */
public class BookStore {

	Scanner sc = new Scanner(System.in);

	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Book> bookList = new ArrayList<>();
	ArrayList<Rental> rentalList = new ArrayList<>();

	// 로그인된 고객정보
	private Customer loginedUser = null;

	/**
	 * <p>도서대여점의 기본 생성자
	 * 
	 * <p>객체 생성시 기본적으로 고객 한명의 정보와 책 10권을 각각 등록한다.
	 */
	public BookStore() {
		Customer cus = new Customer();
		cus.setId("hong");
		cus.setPwd("hong1111");
		cus.setName("홍길동");
		cus.setTel("010-1234-1234");
		cus.setRegdate(new Date());
		cus.setPoint(0);

		customerList.add(cus);

		bookList.add(new Book(1, "설민석의 조선왕조 실록", 20000));
		bookList.add(new Book(2, "해리포터와 저주받은 아이", 15000));
		bookList.add(new Book(3, "그럴 때 있으시죠?", 15000));
		bookList.add(new Book(4, "그릿 GRIT", 16000));
		bookList.add(new Book(5, "대통령의 글쓰기", 17000));
		bookList.add(new Book(6, "트랜드 코리아", 18000));
		bookList.add(new Book(7, "브루클린의 소녀", 13500));
		bookList.add(new Book(8, "강성태 66 공부법", 12500));
		bookList.add(new Book(9, "지대넓얕", 17000));
		bookList.add(new Book(10, "미움받을 용기", 13000));
	}

	// 아이디 중복체크
	private boolean isExistId(String id) {
		boolean isExist = false;

		for (Customer customer : customerList) {
			if (customer.getId().equals(id)) {
				isExist = true;
				break;
			}
		}
		return isExist;
	}

	/**
	 * <p>회원가입
	 */
	// 고객정보 입력받기
	public void register() { // 2
		// 고객정보를 customer객체에 담기
		Customer customer = new Customer();

		System.out.print("아이디를 입력하세요 > ");
		String id = sc.nextLine();
		if (isExistId(id)) {
			System.out.println("이미 사용중인 아이디입니다.");
			return;
		}
		System.out.print("이름을 입력하세요 > ");
		String name = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 > ");
		String pwd = sc.nextLine();
		System.out.print("연락처를 입력하세요 > ");
		String tel = sc.nextLine();
		System.out.print("이메일을 입력하세요 > ");
		String email = sc.nextLine();

		customer.setName(name);
		customer.setId(id);
		customer.setPwd(pwd);
		customer.setTel(tel);
		customer.setEmail(email);
		customer.setRegdate(new Date()); // 현재시간
		customer.setPoint(0);
		// customer객체를 collection에 저장하기
		customerList.add(customer);
	}

	// 로그인의 목적
	// 사용자의 식별정보를 담아두기위해서(로그인의 중복 방지)
	
	/**
	 * <p>로그인 기능
	 */
	// 로그인 기능
	public void login() { // 1
		// 중복 로그인 금지
		if (loginedUser != null) {
			System.out.println("이미 로그인되었습니다.");
			return;
		}
		// 아이디가 동일한 고객의 정보를 담기위한 변수
		Customer c = null;

		System.out.print("아이디 입력 > ");
		String id = sc.nextLine();
		// 아이디 비교
		for (Customer customer : customerList) {
			if (id.equals(customer.getId())) {
				c = customer;
			}
		}
		// c가 null이면 아이디 없음
		if (c == null) {
			System.out.println("아이디가 존재하지 않습니다.");
			return;
		}

		System.out.print("비밀번호 입력 > ");
		String pwd = sc.nextLine();
		// c의 비밀번호와 입력받은 비밀번호 비교
		if (pwd.equals(c.getPwd())) {
			loginedUser = c; // c를 로그인된 고객정보에 저장
			System.out.println("로그인 되었습니다.");
		}
	}

	/**
	 * <p>로그아웃 기능
	 */
	public void logout() { // 7
		if (loginedUser != null) {
			System.out.println("로그아웃되었습니다.");
			loginedUser = null;
		}
	}

	/**
	 * <p>도서조회 기능
	 */
	public void displayBooks() { // 3
		System.out.printf("%s\t%-30s%-8s\n", "번호", "제목", "가격");
		System.out.printf("------------------------------------------------\n");
		for (Book book : bookList) {
			System.out.printf("%d\t%-30s%-4d\n", book.getNo(), book.getTitle(), book.getPrice());
		}
	}
	
	/**
	 * <p>대여 기능
	 */
	public void rental() { // 4

		if (loginedUser == null) {
			System.out.println("먼저 로그인해주세요.");
			return;
		}

		System.out.print("대여할 책번호를 입력하세요 > ");
		String rentBookNo = sc.nextLine();

		Rental rent = new Rental();

		rent.setCustomer(loginedUser);
		for (Book book : bookList) {
			if (rentBookNo.equals(String.valueOf(book.getNo()))) {
				rent.setBook(book);
				System.out.printf("%s(을)를 대여하셨습니다.\n", book.getTitle());
			}
		}
		rent.setRentDate(new Date());
		rent.setBack(false);

		rentalList.add(rent);
	}
	
	/**
	 * <p>대여내역조회 기능
	 */
	public void rentalList() { // 6

		if (loginedUser == null) {
			System.out.println("먼저 로그인해주세요.");
			return;
		}

		System.out.printf("%s님의 대여내역\n", loginedUser.getId());
		System.out.printf("--------------------------------\n");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		String isBack = null;
		
		for (Rental rent : rentalList) {
			if (rent.isBack()) {
				isBack = "반납완료";
			} else {
				isBack = "대여중";
			}
			System.out.printf(" > %s %s %s\n", sdf.format(rent.getRentDate()), rent.getBook().getTitle(), isBack);
		}
	}
	
	/**
	 * <p>반납 기능
	 */
	public void rentalBack() { // 5

		if (loginedUser == null) {
			System.out.println("먼저 로그인해주세요.");
			return;
		}

		System.out.print("반납할 책의 번호를 입력하세요 > ");
		String bookNo = sc.nextLine();

		for (Rental rent : rentalList) {
			if (!rent.isBack()) {
				if (bookNo.equals(String.valueOf(rent.getBook().getNo()))) {
					System.out.printf("%s 반납완료 되었습니다.\n", rent.getBook().getTitle());
					rent.setBack(true);
				}
			}
		}
	}
}