package kr.jhta.map;

import java.util.Date;
import java.util.HashMap;

public class HashMapDemo4 {

	public static void main(String[] args) {

		/*
		 * 서로 다른 타입의 값을 담는 Map객체 만들기
		 * 값의 타입이 String,Integer,Double, Date 혹은 객체
		 */
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "홍길동");			// <String, String>
		map.put("age", 30);					// <String, Integer>
		map.put("weight", 68.9);			// <String, Double>
		map.put("birth", new Date());		// <String, Date>
		
		// 담을때 Object타입으로 담았기 때문에 값을 뽑을땐 형변환해야한다.
		String value1 = (String) map.get("name");
		System.out.println(value1);

		//Integer value2 = (Integer) map.get("age");
		int value2 = (Integer) map.get("age");
		System.out.println(value2);
		
		//Double value3 = (double) map.get("weight");
		double value3 = (double) map.get("weight");
		System.out.println(value3);
		
		//String value4 = (String) map.get("birth"); // ClassCastException
		// key에 해당하는 값을 꺼낼 때 적합하지 않은 데이터타입을 지정해도
		// 컴파일 과정에서 에러가 표시되지 않는다.
		Date value4 = (Date) map.get("birth");
		System.out.println(value4);
	}
}