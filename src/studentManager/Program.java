package studentManager;

import java.util.Scanner;

public interface Program {
/* 1. 학생등록 | => void insertStudent(Scanner scan);
 * 2. 학생리스트 출력 | => void printStudent();
 * 3. 학생검색(학생정보, 수강정보) | => void searchStudent(Scanner scan);
 * 4. 수강신청(한 학생에 대한) | => void insertSubject(Scanner scan);
 * 5. 수강철회(한 학생에 대한) | => void deleteSubject(Scanner scan);
 * 6. 종료
 * */
	
	void insertStudent(Scanner scan);
	void printStudent();
	void searchStudent(Scanner scan);
	void insertSubject(Scanner scan);
	void deleteSubject(Scanner scan);
		
}

