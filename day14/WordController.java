package day14;

import java.util.HashMap;
import java.util.Map;

public class WordController {
	
	private Map<String, String> dio = new HashMap<>();
	
	public WordController() {
		dio.put("Apple(사과)", "빨간색, 녹색 또는 노란색인 과일");
		dio.put("Banana(바나나)", "보통 노란색, 덜익은건 녹색인 과일");
		dio.put("Cherry(체리)", "적갈색인 과일");
		dio.put("Durin(두리안)", "연녹색, 냄새가 심한 과일");
		dio.put("Eggplant(가지)", "보라색, 채소류로 오해 하지만 과일(열매채소)");
		
	}
	
	public void add(String word, String meaning) {
		dio.put(word, meaning);
		System.out.println(word + "단어추가.");
	}
	public void searchWord(String word) {
        if (dio.containsKey(word)) {
            System.out.println(word + ": " + dio.get(word));
        } else {
            System.out.println("단어 : " + word + "없는 단어 입니다.");
        }
    }
	public void updateWord(String word, String newMeaning) {
		if(dio.isEmpty()) {
			System.out.println("내용이 비어있음");
		}else{
			
		}
	}

	

}
