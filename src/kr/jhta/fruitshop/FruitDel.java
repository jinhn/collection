package kr.jhta.fruitshop;

import java.util.Date;
// 배송정보
public class FruitDel {
	private FruitCustomer fruitcustomer;
	private Fruit Fruit;
	private Date delDate;
	private boolean isDel;
	
	public FruitDel() {}

	public FruitDel(FruitCustomer fruitcustomer, Fruit fruit, Date delDate, boolean isDel) {
		super();
		this.fruitcustomer = fruitcustomer;
		Fruit = fruit;
		this.delDate = delDate;
		this.isDel = isDel;
	}

	public FruitCustomer getFruitcustomer() {
		return fruitcustomer;
	}

	public void setFruitcustomer(FruitCustomer fruitcustomer) {
		this.fruitcustomer = fruitcustomer;
	}

	public Fruit getFruit() {
		return Fruit;
	}

	public void setFruit(Fruit fruit) {
		Fruit = fruit;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public boolean isDel() {
		return isDel;
	}

	public void setDel(boolean isDel) {
		this.isDel = isDel;
	}
}