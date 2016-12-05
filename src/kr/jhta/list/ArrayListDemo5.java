package kr.jhta.list;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListDemo5 {

	// 콜렉션과 제목을 전달받아서 제목이 포함된 책 정보를 반환하는 메소드
	public static ArrayList<Book> infoByTitle(ArrayList<Book> books, String keyword) {
		ArrayList<Book> result = new ArrayList<>();
		// 소문자로 변환
		String lowerCasekeyword = keyword.toLowerCase();
		
		for (Book b : books) {
			String lowerCaseTitle = b.getTitle().toLowerCase();
			if (lowerCaseTitle.contains(lowerCasekeyword)) {
				result.add(b);
			}
		}
		return result;
	}

	// 콜렉션과 최소가격, 최대가격을 전달받아서 그 가격범위에 포함된 책 정보를 반환하는 메소드
	public static ArrayList<Book> infoByPrice(ArrayList<Book> books, int min, int max) {
		ArrayList<Book> result = new ArrayList<>();
		for (Book b : books) {
			if (b.getPrice() >= min && b.getPrice() <= max) {
				result.add(b);
			}
		}
		return result;
	}

	// 콜렉션과 출판사를 전달받아서 그 출판사에서 출판한 책 정보를 반환하는 메소드
	public static ArrayList<Book> infoByPublisher(ArrayList<Book> books, String pub) {
		ArrayList<Book> result = new ArrayList<>();
		for (Book b : books) {
			if (b.getPublisher().contains(pub)) {
				result.add(b);
			}
		}
		return result;
	}
	
	// 콜렉션을 전달받아서 출판사 정보를 반환하는 메소드
	public static HashSet<String> collectPub(ArrayList<Book> books) {
		HashSet<String> pubSet = new HashSet<>();
		for (Book pub : books) {
			pubSet.add(pub.getPublisher());
		}
		return pubSet;
	}

	public static void main(String[] args) {
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("이것이 자바다", "신용권", "한빛미디어", 30000));
		books.add(new Book("점프 투 파이썬", "박응용", "이지스퍼블리싱", 18000));
		books.add(new Book("열혈 C 프로그래밍", "윤성우", "오렌지미디어", 25000));
		books.add(new Book("파이썬 웹 크롤러", "한선용", "한빛미디어", 24000));
		books.add(new Book("텐서플로 첫걸음", "박해선", "한빛미디어", 16000));
		books.add(new Book("자바의 정석", "남궁성", "도우출판사", 30000));
		books.add(new Book("AngularJS 2 프로그래밍", "정진욱", "위키북스", 27000));
		books.add(new Book("모두의 파이썬", "이승찬", "길벗", 12000));
		books.add(new Book("자바8 인 액션", "우정은", "한빛미디어", 28000));
		books.add(new Book("자바스크립트 패턴과 테스트", "이일웅", "길벗", 38000));

		System.out.println("====제목별 검색결과====");
		ArrayList<Book> result1 = infoByTitle(books, "자바");
		for (Book bk : result1) {
			System.out.println(bk.getTitle() + ", " + bk.getAuthor() + ", " + bk.getPublisher() + ", " + bk.getPrice());
		}

		System.out.println();

		System.out.println("====가격별 검색결과====");
		ArrayList<Book> result2 = infoByPrice(books, 25000, 30000);
		for (Book bk : result2) {
			System.out.println(bk.getTitle() + ", " + bk.getAuthor() + ", " + bk.getPublisher() + ", " + bk.getPrice());
		}

		System.out.println();

		System.out.println("====출판사별 검색결과====");
		ArrayList<Book> result3 = infoByPublisher(books, "길벗");
		for (Book bk : result3) {
			System.out.println(bk.getTitle() + ", " + bk.getAuthor() + ", " + bk.getPublisher() + ", " + bk.getPrice());
		}
		
		System.out.println();
		
		System.out.println("====출판사 검색결과====");
		HashSet<String> result4 = collectPub(books);
		for (String pub : result4) {
			System.out.println(pub);
		}
	}

	public static class Book {
		private String title;
		private String author;
		private String publisher;
		private int price;

		public Book() {}

		public Book(String title, String author, String publisher, int price) {
			super();
			this.title = title;
			this.author = author;
			this.publisher = publisher;
			this.price = price;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
	}
}