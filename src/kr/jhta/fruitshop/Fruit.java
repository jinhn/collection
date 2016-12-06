package kr.jhta.fruitshop;
// 과일정보
public class Fruit {
	private int no; // 과일번호
	private String name; // 과일이름
	private int price; // 과일가격

	public Fruit() {}

	public Fruit(int no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}