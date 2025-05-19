package re01;

import java.util.HashMap;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		// 단어장
		/* 단어 : 의미
		 * map으로 생성
		 * 입력받을 단어의 개수를 입력 => 개수만큼 map에 추가
		 * 콘솔에 출력 
		 * */
		HashMap<String, String> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		System.out.println("단어개수>");
		int size = scan.nextInt();
		
		while(map.size() < size) {
			System.out.println("단어>");
			String word = scan.next();
			System.out.println("뜻>");
			String mean = scan.next();
			
			map.put(word, mean);
		}
		
		for(String key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
		scan.close();
		
	} // main

} // class
