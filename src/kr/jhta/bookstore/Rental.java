package kr.jhta.bookstore;

import java.util.Date;

public class Rental {

	private Customer customer;
	private Book book;
	private Date rentDate;
	private boolean isBack;

	public Rental() {}

	public Rental(Customer customer, Book book, Date rentDate, boolean isBack) {
		super();
		this.customer = customer;
		this.book = book;
		this.rentDate = rentDate;
		this.isBack = isBack;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public boolean isBack() {
		return isBack;
	}

	public void setBack(boolean isBack) {
		this.isBack = isBack;
	}
}