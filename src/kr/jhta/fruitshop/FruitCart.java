package kr.jhta.fruitshop;

import java.util.Date;

public class FruitCart {
	private FruitCustomer customer;
	private Fruit fruit;
	private Date buyDate;
	private int Quantity;
	
	public FruitCart() {}

	public FruitCart(FruitCustomer customer, Fruit fruit, Date buyDate, int quantity) {
		super();
		this.customer = customer;
		this.fruit = fruit;
		this.buyDate = buyDate;
		Quantity = quantity;
	}

	public FruitCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(FruitCustomer customer) {
		this.customer = customer;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}