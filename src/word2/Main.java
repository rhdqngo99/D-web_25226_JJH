package word2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* 단어장 프로그램
		 * 하나의 단어에 뜻이 여러개 등록
		 * class 활용. 
		 * Map<String, ArrayList<String>> map
		 * 
		 * 1.단어등록|2.단어검색|3.단어수정|
		 * 4.단어출력|5.단어삭제|6.단어를파일로출력 |7.종료
		 * WordController를 생성하여 메서드 구현
		 * 기본단어 5가지 등록 
		 * 
		 * class 활용
		 * 단어, 뜻 (ArrayList) / equals() 사용 : 단어가 같으면 같은 객체
		 * */
		
		Scanner scan = new Scanner(System.in);
		WordController wc = new WordController();
		
		wc.addWord();
		
		int menu = 0;
		do {
			System.out.println("1.단어등록| 2.단어검색| 3.단어수정|\r\n"
					+ "4.단어출력| 5.단어삭제| 6.파일출력 | 7.종료");
			System.out.println("선택 > ");
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: wc.insertWord(scan); break;
			case 2: wc.searchWord(scan); break;
			case 3: wc.modifyWord(scan); break;
			case 4: wc.printWord(); break;
			case 5: wc.deleteWord(scan); break;
			case 6: try {
					wc.fileWord(scan);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} break;
			case 7: System.out.println("종료"); break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}while(menu != 7);
		
		scan.close();

	}

}

