package studentManager;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		// 컨트롤러 객체 생성
		StudentController sc = new StudentController();
		//"1.학생등록 | 2.학생리스트출력 | 3.학생검색(학생정보,수강정보)"
		//"4.수강신청 | 5.수강철회 | 6.종료"
		int menu = 0;
        sc.addStudent();
		sc.addSubList();
		do {
			// 메뉴 넣기 
			menu = sc.menuPrint(scan);
			
			switch(menu) {
			case 1: sc.insertStudent(scan); break;
			case 2: sc.printStudent(); break;
			case 3: sc.searchStudent(scan); break;
			case 4: sc.insertSubject(scan); break;
			case 5: sc.deleteSubject(scan); break;
			case 6: 
				System.out.println("종료");
				break;
				default :
					System.out.println("잘못된 메뉴");
			}
			
		}while(menu != 6);
		
		scan.close();

	}

}
