package kr.jhta.fruitshop;

import java.util.Date;
// 배송정보
public class FruitDel {
	private FruitCustomer fruitcustomer;
	private Fruit fruit;
	private Date delDate;
	
	public FruitDel() {}

	public FruitDel(FruitCustomer fruitcustomer, Fruit fruit, Date delDate, boolean isDel) {
		super();
		this.fruitcustomer = fruitcustomer;
		this.fruit = fruit;
		this.delDate = delDate;
	}

	public FruitCustomer getFruitcustomer() {
		return fruitcustomer;
	}

	public void setFruitcustomer(FruitCustomer fruitcustomer) {
		this.fruitcustomer = fruitcustomer;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
}