package kr.jhta.fruitshop;

import java.util.ArrayList;
import java.util.Scanner;

// 메소드 정의
public class FruitShop {

	Scanner sc = new Scanner(System.in);

	ArrayList<FruitCustomer> customerList = new ArrayList<>();
	ArrayList<Fruit> fruitList = new ArrayList<>();
	ArrayList<Fruit> fruitCart = new ArrayList<>();

	private FruitCustomer loginedUser = null;

	// 아이디 중복체크
	private boolean isExistId(String id) {
		boolean isExistId = false;
		for (FruitCustomer fruitCustomer : customerList) {
			if (fruitCustomer.getId().equals(id)) {
				isExistId = true;
				break;
			}
		}
		return isExistId;
	}

	// 과일정의
	public FruitShop() {
		fruitList.add(new Fruit(1, "사과", 1000));
		fruitList.add(new Fruit(2, "배", 1500));
		fruitList.add(new Fruit(3, "귤", 3000));
		fruitList.add(new Fruit(4, "딸기", 5000));
		fruitList.add(new Fruit(5, "바나나", 2000));
		fruitList.add(new Fruit(6, "감", 1500));
		fruitList.add(new Fruit(7, "수박", 15000));
		fruitList.add(new Fruit(8, "메론", 20000));
		fruitList.add(new Fruit(9, "포도", 10000));
		fruitList.add(new Fruit(10, "키위", 7000));
	}

	// 회원가입
	public void register() {

		FruitCustomer cus = new FruitCustomer();

		System.out.print("아이디 입력: ");
		String id = sc.nextLine();
		if (isExistId(id)) {
			System.out.println("이미 사용중인 아이디입니다.");
			return;
		}
		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		System.out.print("비밀번호 입력: ");
		String pwd = sc.nextLine();
		System.out.print("연락처 입력: ");
		String tel = sc.nextLine();
		System.out.println("회원가입이 완료되었습니다.");

		cus.setId(id);
		cus.setName(name);
		cus.setPwd(pwd);
		cus.setTel(tel);

		customerList.add(cus);
	}

	// 로그인
	public void login() {

		if (loginedUser != null) {
			System.out.print("이미 로그인되어있습니다.");
		}

		FruitCustomer loginId = null;

		System.out.print("아이디 입력: ");
		String id = sc.nextLine();
		System.out.print("비밀번호 입력: ");
		String pwd = sc.nextLine();

		for (FruitCustomer fruitCustomer : customerList) {
			if (id.equals(fruitCustomer.getId())) {
				if (pwd.equals(fruitCustomer.getPwd())) {
					System.out.printf("%s님 환영합니다.\n", fruitCustomer.getId());
					loginId = fruitCustomer;
				}
			}

			if (loginId == null) {
				System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
			}
		}
	}

	// 과일정보조회
	public void fruitInfo() {
		System.out.println("-------과일정보-------");
		for (Fruit fruit : fruitList) {
			System.out.printf("%d\t%s\t%d원\n", fruit.getNo(), fruit.getName(), fruit.getPrice());
		}
		System.out.println("----------------------");
	}

	// 과일구매
	public void buyFruit() {
		System.out.println("구매하실 과일이름을 적어주세요: ");
		String fruitName = sc.nextLine();
		for (Fruit fruit : fruitList) {
			if (fruitName.equals(fruit.getName())) {
				System.out.printf("%s를 구매하였습니다.", fruit.getName());
			}
			// FruitCart 클래스만들기!! 여기부터 시작
		}
	}

	// 구매목록조회
	public void buyList() {

	}

	// 배송신청
	public void delivery() {

	}

	// 배송신청조회
	public void deliveryList() {

	}
}