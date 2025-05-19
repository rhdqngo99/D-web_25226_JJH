package board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		// Board
		BoardController bc = new BoardController();
		Scanner scan = new Scanner(System.in);
		
		int menu = -1;
		
		do {
			bc.printMenu();
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: bc.addBoard(scan); break;
			case 2: bc.printBoard(); break;
			case 3: bc.searchBoard(scan); break;
			case 4: bc.modifyBoard(scan); break;
			case 5: bc.removeBoard(scan); break;
			case 6: bc.fileBoard(); break;
			case 7: System.out.println("종료"); break;
			default: System.out.println("잘못된 메뉴");
			}
		}while(menu != 7);
		
		scan.close();

	}

}
