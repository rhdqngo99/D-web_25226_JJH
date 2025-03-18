package day14;

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
        WordController cont = new WordController();
        
        cont.add("Apple(사과)", "빨간색, 녹색 또는 노란색인 과일");
        cont.add("Banana(바나나)", "보통 노란색, 덜익은건 녹색인 과일");
        cont.add("Cherry(체리)", "적갈색인 과일");
        cont.add("Durin(두리안)", "연녹색, 냄새가 심한 과일");
        cont.add("Eggplant(가지)", "보라색, 채소류로 오해 하지만 과일(열매채소)");
        
        while (true) {
        	System.out.println("1. 단어 등록");
        	System.out.println("2. 단어 검색");
        	System.out.println("3. 단어 수정");
        	System.out.println("4. 단어 출력");
        	System.out.println("5. 단어 삭제");
        	System.out.println("6. 종료");
        	System.out.print("메뉴선택");
        
        	int choice = scan.nextInt();
        	scan.nextLine();

        switch (choice) {
            case 1:
                System.out.print("단어 입력: ");
                String wordToAdd = scan.nextLine();
                System.out.print("단어의 의미 입력: ");
                String meaningToAdd = scan.nextLine();
                cont.add(wordToAdd, meaningToAdd);
                break;

            case 2:
                System.out.print("검색할 단어 입력: ");
                String wordToSearch = scan.nextLine();
                cont.searchWord(wordToSearch);
                break;

            case 3:
                System.out.print("수정할 단어 입력: ");
                String wordToUpdate = scan.nextLine();
                System.out.print("새로운 의미 입력: ");
                String newMeaning = scan.nextLine();
                cont.updateWord(wordToUpdate, newMeaning);
                break;

            case 4:
                cont.printWords(); break;

            case 5:
                System.out.print("삭제할 단어를 입력: ");
                String wordToDelete = scan.nextLine();
                cont.deleteWord(wordToDelete);
                break;

            case 6:
                System.out.println("종료");
                scan.close();
                return;

            default:
                System.out.println("잘못된 입력");
        }
       }
	}

}
