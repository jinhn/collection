package kr.jhta.set;

import java.util.HashSet;
//import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {

		// 이름을 저장하는 HashSet객체 생성하기
		//Set<String> names = new HashSet<>();
		HashSet<String> names = new HashSet<>();

		names.add("홍길동");
		names.add("김구");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("유관순");
		
		int len = names.size();
		System.out.println("갯수: " + len);
		
		for (String name : names) {
			System.out.println(name);
		}
	}
}