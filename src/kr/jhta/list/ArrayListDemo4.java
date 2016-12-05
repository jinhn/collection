package kr.jhta.list;

import java.util.ArrayList;

public class ArrayListDemo4 {

	// 정적메소드 정의하기
	// ArrayList와 "성씨"를 전달받아서 그 "성씨" 해당하는 이름을 출력하는 메소드
	public static void displayLastName(ArrayList<String> list, String familyName) {
		for (String name : list) {
			String firstLetter = name.substring(0, familyName.length());
			if (familyName.equals(firstLetter)) {
				System.out.println(name);
			}
		}
	}

	// 정적메소드 정의하기
	// ArrayList와 "성씨"를 전달받아서
	// 그 "성씨"에 해당하는 이름을 ArrayList에 담아서 반환하는 메소드
	public static ArrayList<String> getNamesByLastName(ArrayList<String> list, String familyName) {
		// ArrayList는 null값을 채우면 안된다.
		ArrayList<String> result = new ArrayList<String>();
		for (String name : list) {
			String firstLetter = name.substring(0, familyName.length());
			if (familyName.equals(firstLetter)) {
				result.add(name);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("김구");
		names.add("윤봉길");
		names.add("이동욱");
		names.add("독고탁");
		names.add("유관순");
		names.add("이성경");

		displayLastName(names, "이");
		System.out.println(getNamesByLastName(names, "김"));
	}
}