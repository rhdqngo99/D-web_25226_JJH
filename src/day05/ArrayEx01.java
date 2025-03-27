package day05;

import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		/* 파일명을 저장하고 있는 배열이 주어졌을때
		 * 검색어를 입력하면 해당 검색어를 포함하는 파일을 출력
		 * 만약 검색결과가 없으면 => 검색결과가 없습니다. 출력
		 * */
		
		String[] fileName = {"이것이자바자.java","java의 정석.java"
				,"Array.txt", "array.java", "String Method.txt"
				,"Array Method.jpg", "java Method.java"};
		// 1.검색어 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("검색어 입력>");
		String s = scan.next();
		
		int cnt=0;
		
		//2. 파일명 배열안에 검색어가 있는지 확인
		//java의 정석.java => java
		//문자열 속에 해당 단어가 포함되어있는지 확인 => contains
		for (int i = 0; i < fileName.length; i++) {
//			System.out.println(fileName[i].contains(s));
			if(fileName[i].toLowerCase().contains(s)) {
				System.out.println(fileName[i]);
				cnt++;
			}
		}
		
		//3.모든 파일명을 검색 후 조건에 맞는 값이 없다면...
		//검색결과가 없습니다.
		if(cnt == 0) {
			System.out.println("검색결과가 없습니다.");
		}
		System.out.println("---------------");
		System.out.println("검색결과 "+cnt+"개");
		
		
		// CRUD
		/* Create (생성)
		 * Read (읽기 검색)
		 * Update (수정)
		 * Delete (삭제)
		 * */
		scan.close();
	}

}
