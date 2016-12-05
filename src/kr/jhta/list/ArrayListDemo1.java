package kr.jhta.list;

import java.util.ArrayList;

public class ArrayListDemo1 {

	public static void main(String[] args) {
		// 방문자 이름을 저장하는 ArrayList를 생성하고
		// 방문자 이름을 여러개 입력하기
		// 출력은 "김"씨 성을 가진 사람만 화면에 출력하기

		ArrayList<String> names = new ArrayList<String>();

		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		names.add("김사랑");
		names.add("이순신");
		names.add("김구");

		for (String name : names) {
			String Lastname = name.substring(0, 1);
			// 정해진 문자열이 있으면 그 값을 앞에 적음!!
			if ("김".equals(Lastname)) {
				System.out.println(name);
			}
		}

	}
}