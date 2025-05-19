package board;

import java.util.Scanner;

public interface BoardInterface {
	/* 게시판 프로그램
	 * 1.게시글추가|2.게시글리스트|3.게시글상세|4.게시글수정|5.게시글삭제|6.게시글파일로전송
	 * */
	void addBoard(Scanner scan);
	void printBoard();
	void searchBoard(Scanner scan);
	void modifyBoard(Scanner scan);
	void removeBoard(Scanner scan);
	void fileBoard();

}