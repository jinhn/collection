package kr.jhta.bookstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookStore {

	Scanner sc = new Scanner(System.in);

	ArrayList<Customer> customerList = new ArrayList<Customer>();
	// 로그인된 고객정보
	private Customer loginedUser = null;
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

	// 고객정보 입력받기
	public void register() {
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
		System.out.println("이메일을 입력하세요 > ");
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

	// 로그인 기능
	public void login() {
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
}