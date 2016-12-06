package kr.jhta.map;

import java.util.HashMap;

public class HashMapDemo2 {

	public static void main(String[] args) {
		
		HashMap<String, Product> products = new HashMap<>();
		
		products.put("노트북", new Product("노트북", 1000000));
		products.put("연필", new Product("연필", 1000));
		products.put("책상", new Product("책상", 50000));
		products.put("컵", new Product("컵", 6000));
	}
	
	public static class Product {
		private String name;
		private int price;
		
		public Product() {}

		public Product(String name, int price) {
			super();
			this.name = name;
			this.price = price;
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
}