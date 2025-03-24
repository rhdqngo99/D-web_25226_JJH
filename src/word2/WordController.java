package word2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordController {
	
	private List<Word> wordBook = new ArrayList<Word>();

	public void addWord() {
		// 기본 단어 5개 추가
		// 리스트에 추가될 객체는 Word객체. String, List
		Word w = new Word("dog");
		List<String> wList = new ArrayList<>();
		wList.add("강아지");
		wList.add("멍멍이");
		wList.add("개");
		wList.add("뽀삐");
		w.setMean(wList);
		wordBook.add(w);
		
		Word w1 = new Word("cat");
		List<String> w1List = new ArrayList<>();
		w1List.add("고양이");
		w1List.add("야옹이");
		w1List.add("나비");
		w1.setMean(w1List);
		wordBook.add(w1);
		
		Word w2 = new Word("pig");
		List<String> w2List = new ArrayList<>();
		w2List.add("돼지");
		w2List.add("꿀꿀이");
		w2List.add("뚱땡이");
		w2.setMean(w2List);
		wordBook.add(w2);
		
	}

	public void insertWord(Scanner scan) {
		// 단어 추가
		System.out.println("단어>");
		String word = scan.next();
		List<String> wList = new ArrayList<>();
		
		String end = "a"; // y를 입력하면 종료
		
		while(!end.equals("y")) {
			scan.nextLine(); //공백 없애기
			System.out.println("뜻>");
			wList.add(scan.nextLine());
			System.out.println("종료(y) > ");
			end = scan.next();
		}
		wordBook.add(new Word(word, wList));
		System.out.println("등록완료");
	}

	public void searchWord(Scanner scan) {
		// 단어 검색
		System.out.println("검색 단어>");
		String word = scan.next();
		
		//indexOf(Object) : 해당 객체가 리스트의 몇번지에 있는지 리턴
		int index = wordBook.indexOf(new Word(word));
		if(index == -1) {
			System.out.println("검색 단어가 없습니다.");
			return;
		}
		System.out.println(wordBook.get(index));
	}

	public void modifyWord(Scanner scan) {
		// 단어 수정
		System.out.println("수정 단어>");
		String word = scan.next();
		
		int index = wordBook.indexOf(new Word(word)); 
		List<String> mean = wordBook.get(index).getMean();
		System.out.println(mean);
		System.out.println("몇번째 뜻 수정?(1,2,3...)");
		int i = scan.nextInt();
		scan.nextLine();
		System.out.println("뜻>");
		String modifyMean = scan.nextLine();
		mean.set(i-1, modifyMean);
		wordBook.set(index, new Word(word, mean));
		System.out.println("수정완료");
	}

	public void printWord() {
		// 단어 출력
		for(Word w : wordBook) {
			System.out.println(w);
		}
		
	}

	public void deleteWord(Scanner scan) {
		// 단어 삭제
		System.out.println("삭제 단어>");
		String word = scan.next();
		if(!wordBook.remove(new Word(word))) {
			System.out.println("삭제할 단어가 없습니다.");
			return;
		}
		System.out.println("삭제완료");
	}

	public void fileWord(Scanner scan) throws IOException {
		// 파일로 출력
		// StringBuffer 객체를 사용
		// .append : 기존 String 객체에 데이터를 추가
		
		FileWriter fw = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuffer sb = new StringBuffer();
		
		String data = null;
		sb.append("---단어장---\r\n");
		
		for(Word w : wordBook) {
			sb.append(w);
			sb.append("\r\n"); //줄바꿈
		}
		
		//객체를 저장할 때는 String 객체로만 저장이 가능.
		//StringBuffer 객체는 저장이 안됨. 
		//StringBuffer => String으로 변환
		data = sb.toString();
		System.out.println(data);
		bw.write(data);
		
		bw.close();
		fw.close();
		
	}

}