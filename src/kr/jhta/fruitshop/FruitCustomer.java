package kr.jhta.fruitshop;
// 고객정보
public class FruitCustomer {
	private String name; // 이름
	private String id; // 아이디
	private String pwd; // 비밀번호
	private String tel; // 연락처

	public FruitCustomer() {}

	public FruitCustomer(String name, String id, String pwd, String tel) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


}