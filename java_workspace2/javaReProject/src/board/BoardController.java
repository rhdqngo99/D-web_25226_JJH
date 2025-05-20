package board;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardController implements BoardInterface{
	//1.게시글추가|2.게시글리스트|3.게시글상세|
	//4.게시글수정|5.게시글삭제|6.게시글파일로전송
	List<Board> list = new ArrayList<>();

	@Override
	public void addBoard(Scanner scan) {
		// title, writer, content 
		System.out.println("title:");
		// 메뉴에서 입력한 enter를 처리하기 위한 
		scan.nextLine();
		String title = scan.nextLine();  //공백포함
		System.out.println("writer:");
		String writer = scan.nextLine();
		System.out.println("content:");
		String content = scan.nextLine();
		
		Board b = new Board(title, content, writer);
		list.add(b);
		
	}

	@Override
	public void printBoard() {
		// toString 이용
		for(Board b : list) {
			System.out.println(b);
		}
		
	}

	@Override
	public void searchBoard(Scanner scan) {
		// num를 입력받아 전체 내용을 확인
		System.out.println("num>");
		int num = scan.nextInt();
		// 해당 객체가 있는 번지를 리턴 없으면 -1리턴
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			list.get(index).print();
			return;
		}
		System.out.println("일치하는 게시글이 없습니다.");
		
	}

	@Override
	public void modifyBoard(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("num>");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			// 데이터 받기
			System.out.println("title:");
			// 위에서 입력한 enter를 처리하기 위한 
			scan.nextLine();
			String title = scan.nextLine();  //공백포함
			
			System.out.println("content:");
			String content = scan.nextLine();
			
			Board tmp = list.get(index);
			tmp.setTitle(title);
			tmp.setContent(content);
			// 수정 확인용으로 출력
			tmp.print();
			System.out.println("수정완료");
			return;
		}
		System.out.println("일치하는 게시글이 없습니다.");
		
	}

	@Override
	public void removeBoard(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("num>");
		int num = scan.nextInt();
		
		int index = list.indexOf(new Board(num));
		if(index != -1) {
			list.remove(index); // 삭제
			System.out.println("삭제완료!!");
			return;
		}
		System.out.println("일치하는 게시글이 없습니다.");
		
	}

	@Override
	public void fileBoard() {
		// 파일로 전송
		try {
			FileWriter fw = new FileWriter("word.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			StringBuffer sb = new StringBuffer();
			
			String data="";
			int cnt = 0;
			
			while(cnt < list.size()) {
				sb.append(list.get(cnt).toString());
				sb.append("\r\n");
				cnt++;
			}
			// StringBuffer 객체를 String으로 변환
			data = sb.toString();  
			System.out.println(data);
			fw.write(data);
			bw.close();
			fw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void printMenu() {
		
		System.out.println("--게시판--");
		System.out.println("1.등록|2.리스트|3.조회");
		System.out.println("4.수정|5.삭제|6.파일로전송|7.종료");
		System.out.println("메뉴>");
		
	}

}
