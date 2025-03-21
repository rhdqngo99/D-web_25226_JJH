package word;

import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		/* map을 이용한 단어장 프로그램 작성
		 * 1.단어등록|2.단어검색|3.단어수정|
		 * 4.단어출력|5.단어삭제|6.종료
		 * WordController를 생성하여 메서드 구현
		 * 기본단어 5가지 등록 
		 * */
		
		Scanner scan = new Scanner(System.in);
		WordController wc = new WordController();
		
		wc.addWord();
		
		int menu = 0;
		do {
			System.out.println("1.단어등록|2.단어검색|3.단어수정|\r\n"
					+ "4.단어출력|5.단어삭제|6.종료");
			System.out.println("선택 > ");
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: wc.insertWord(scan); break;
			case 2: wc.searchWord(scan); break;
			case 3: wc.modifyWord(scan); break;
			case 4: wc.printWord(); break;
			case 5: wc.deleteWord(scan); break;
			case 6: System.out.println("종료"); break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}while(menu != 6);
		
		scan.close();

	}

}
