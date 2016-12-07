package kr.jhta.fruitshop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import kr.jhta.bookstore.Customer;

// 메소드 정의
public class FruitShop {

	Scanner sc = new Scanner(System.in);

	ArrayList<FruitCustomer> customerList = new ArrayList<>();
	ArrayList<Fruit> fruitList = new ArrayList<>();
	ArrayList<FruitCart> fruitCart = new ArrayList<>();
	ArrayList<FruitDel> fruitDel = new ArrayList<>();

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
		
		FruitCustomer cus = new FruitCustomer();
		
		cus.setName("홍길동");
		cus.setId("hong");
		cus.setPwd("hong1111");
		cus.setTel("010-1234-1234");

		customerList.add(cus);
		
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
		
		int totalPrice = 0;
		FruitCart customer = new FruitCart();
		
		System.out.println("-------과일정보-------");
		for (Fruit fruit : fruitList) {
			System.out.printf("%d\t%s\t%d원\n", fruit.getNo(), fruit.getName(), fruit.getPrice());
		}
		System.out.println("----------------------");
		System.out.print("구매하실 과일번호를 적어주세요: ");
		String fruitNo = sc.nextLine();
		System.out.print("수량을 적어주세요: ");
		int fruitQuantity = Integer.parseInt(sc.nextLine());
		
		customer.setCustomer(loginedUser);
		for (Fruit fruit : fruitList) {
			if (fruitNo.equals(String.valueOf(fruit.getNo()))) {
				totalPrice = fruit.getPrice()*fruitQuantity;
				customer.setFruit(fruit);
				customer.setQuantity(fruitQuantity);
				System.out.printf("%s %d개 구매, %d원 입니다.\n", fruit.getName(), fruitQuantity, totalPrice);
			}
		}
		customer.setBuyDate(new Date());
		
		fruitCart.add(customer);
	}

	// 구매목록조회
	public void buyList() {
		System.out.println("===================구매목록===================");
		for (FruitCart fruit : fruitCart) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			System.out.printf("%s %s %d개 구매\n", sdf.format(fruit.getBuyDate()), fruit.getFruit().getName(), fruit.getQuantity());
		}
	}

	// 배송신청
	public void delivery() {
		
		FruitDel fDel = new FruitDel();
		
		System.out.println("========구매목록========");
		for (FruitCart fruit : fruitCart) {
			System.out.printf("%d\t%s\t%d개\n", fruit.getFruit().getNo(), fruit.getFruit().getName(), fruit.getQuantity());
		}
		System.out.print("배송신청하실 과일번호를 적어주세요: ");
		String fruitNo = sc.nextLine();
		
		fDel.setFruitcustomer(loginedUser);
		for (FruitCart fruit : fruitCart) {
			if (fruitNo.equals(String.valueOf(fruit.getFruit().getNo()))) {
				fDel.setFruit(fruit.getFruit());
				System.out.printf("%s의 배송신청이 완료되었습니다.\n", fruit.getFruit().getName());
			}
		}
		fDel.setDelDate(new Date());
		
		fruitDel.add(fDel);
	}

	// 배송신청조회
	public void deliveryList() {
		System.out.println("==========배송목록==========");
		for (FruitDel del : fruitDel) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			System.out.printf("%s %s\n", sdf.format(del.getDelDate()), del.getFruit().getName());
		}
	}
}