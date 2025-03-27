package day14;

import java.util.HashMap;
import java.util.Scanner;

public class WordController {
	
	// 단어는 map을 사용하여 저장
	private HashMap<String, String> map = new HashMap<>();

	public void addWord() {
		// 기본 단어 5개 추가
		map.put("apple", "사과");
		map.put("banana", "바나나");
		map.put("kiwi", "키위");
		map.put("orange", "오렌지");
		map.put("dog", "강아지");
		map.put("cat", "고양이");
		
	}

	public void insertWord(Scanner scan) {
		// 단어등록
		System.out.println("단어>");
		String word = scan.next();
		System.out.println("뜻>");
		String mean = scan.next();
		
		map.put(word, mean);
		System.out.println("--단어추가 완료");
	}

	public void searchWord(Scanner scan) {
		// 단어검색
		System.out.println("검색 단어>");
		String word = scan.next();
		// key에 값이 존재하는지 확인 : true / false
		if(map.containsKey(word)) {  
			System.out.println("--검색결과--");
			System.out.println(word+":"+map.get(word));
			return;
		}
		System.out.println("검색결과가 없습니다.");
		
	}

	public void modifyWord(Scanner scan) {
		// 단어수정
		// set이 없음. => 삭제 후 추가
		System.out.println("수정할 단어>");
		String word = scan.next();
		// 삭제 값이 없으면 = null / 삭제 값이 있으면 value return
		if(map.remove(word) == null) {
			System.out.println("수정할 단어가 없습니다.");
			return;
		}
		System.out.println("뜻>");
		String mean = scan.next();
		map.put(word, mean);
		System.out.println("--수정완료");
	}

	public void printWord() {
		// 단어출력
		int cnt=0;
		System.out.println("--단어장--");
		for(String s : map.keySet()) {
			cnt++;
			System.out.println(cnt+"."+s+":"+map.get(s));
		}
		System.out.println("--------------");
		
	}

	public void deleteWord(Scanner scan) {
		// 단어삭제
		System.out.println("삭제할 단어>");
		String word = scan.next();
		// 삭제 값이 없으면 = null / 삭제 값이 있으면 value return
		if(map.remove(word) == null) {
			System.out.println("삭제할 단어가 없습니다.");
			return;
		}
		System.out.println("--삭제완료");
	}

}
