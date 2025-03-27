package studentManager;

import java.util.Scanner;

//학교입장

public class StudentController implements Program{
	
	//학생 배열
	private Student[] student = new Student[10];
	private int cnt;  //student index 처리하기 위한 변수
	
	//과목 목록 배열 : 수강신청 가능한 모든 과목의 목록
	private Subject[] subList = new Subject[5];
	
	public void addStudent() {
		Student s = new Student("111", "김순이", "20", "010-1111-1111", "서울 강남구");
		student[cnt] = s;
		cnt++;
		Student s1 = new Student("222", "박철수", "20", "010-1111-2222", "수원 영통구");
		student[cnt] = s1;
		cnt++;
		Student s2 = new Student("333", "황순이", "20", "010-1111-3333", "서울 강서구");
		student[cnt] = s2;
		cnt++;
	}
	
	public void addSubList() {
		subList[0] = new Subject("1111", "java", 3, 2, "홍길동", "화목/2시~4시", "1강의장");
		subList[1] = new Subject("2222", "DB", 3, 2, "이순신", "월수/2시~4시", "2강의장");
		subList[2] = new Subject("3333", "HTML", 2, 3, "김영이", "화금/2시~4시", "3강의장");
		subList[3] = new Subject("4444", "CSS", 2, 3, "황기동", "월목/2시~4시", "4강의장");
		subList[4] = new Subject("5555", "javascript", 3, 3, "박순철", "수목/2시~4시", "5강의장");
	}
	
	public void subListPrint() {
		System.out.println("--수강 과목 목록--");
		for(Subject s : subList) {
			System.out.println(s);
		}
		System.out.println("----------------");
	}
	
	// 메뉴를 출력하는 메서드
	//리턴타입 : 내가고른 메뉴리턴 / 매개변수 : 없음.
	public int menuPrint(Scanner scan) {
		System.out.println("--menu--");
		System.out.println("1.학생등록 | 2.학생리스트출력 | 3.학생검색(학생정보,수강정보)");
		System.out.println("4.수강신청 | 5.수강철회 | 6.종료");
		System.out.println("메뉴선택 >");
		return scan.nextInt();
	}

	@Override
	public void insertStudent(Scanner scan) {
		// 학생 등록하는 메서드 (수강정보는 별개)
		// 학번, 이름, 나이, 전화번호, 주소
		System.out.println("학번>");
		String num = scan.next();
		System.out.println("이름>");
		String name = scan.next();
		System.out.println("나이>");
		String age = scan.next();
		System.out.println("전화번호>");
		String phone = scan.next();
		scan.nextLine(); //공백처리용
		System.out.println("주소>");
		String address = scan.nextLine();
		
		//학생 객체 생성
		Student s = new Student(num, name, age, phone, address);
		student[cnt] = s;
		cnt++;
	}

	@Override
	public void printStudent() {
		// 학생배열 출력.
		System.out.println("--학생명단--");
		for(int i=0; i<cnt; i++) {
			System.out.println(student[i]);
		}
	}

	@Override
	public void searchStudent(Scanner scan) {
		// 학생 검색
		// 검색할 학생의 학번을 받아 출력
		System.out.println("검색할 학번>");
		String searchNum = scan.next();
		
		// 학생 배열에서 학번이 있는지 검색
		for(int i=0; i<cnt; i++) {
			if(student[i].getStdNum().equals(searchNum)) {
				System.out.println(student[i]);
				return;
			}
		}
		System.out.println("검색한 학생이 없습니다.");
		
	}

	@Override
	public void insertSubject(Scanner scan) {
		// 수강신청
		// 누가? (학생) 무슨과목을 추가할지 설정
		System.out.println("수강신청 학번>");
		String stdNum = scan.next();
		int index = -1; //학생의 번지를 저장하기 위한 변수
		
		//학생위치 탐색
		for(int i=0; i<cnt; i++) {
			if(student[i].getStdNum().equals(stdNum)) {
				index = i;
				break;
			}
		}
		
		// 학생을 못찾았다면...  -1
		if(index == -1) {
			System.out.println("학생정보가 없습니다.");
			return;
		}
		
		// 학생을 찾았다면... 수강신청 목록 보여주기
		// 과목목록 보여주기
		subListPrint();
		int subIndex = -1;
		System.out.println("선택과목 번호>");
		String subNum = scan.next();
		for(int i=0; i<subList.length; i++) {
			if(subList[i].getSubNum().equals(subNum)) {
				subIndex = i;
				break;
			}
		}
		// 수강과목을 못찾았다면... -1
		if(subIndex == -1) {
			System.out.println("과목이 없습니다.");
			return;
		}
		
		// 수강신청 학생의 subject배열에 신청과목 추가 
		student[index].insertSubject(subList[subIndex]);
		
	}

	@Override
	public void deleteSubject(Scanner scan) {
		// 수강삭제
		// 수강신청
		// 누가? (학생) 무슨과목을 취소할지 설정
		System.out.println("수강취소 학번>");
		String stdNum = scan.next();
		int index = -1; //학생의 번지를 저장하기 위한 변수
		
		//학생위치 탐색
		for(int i=0; i<cnt; i++) {
			if(student[i].getStdNum().equals(stdNum)) {
				index = i;
				break;
			}
		}
		
		// 학생을 못찾았다면...  -1
		if(index == -1) {
			System.out.println("학생정보가 없습니다.");
			return;
		}
		// 내 수강정보 출력 후 취소할 번호 선택
		System.out.println(student[index]);
		
		System.out.println("수강삭제 번호>");
		String subNum = scan.next();
		
		student[index].deleteSubject(subNum);
		
	}

}
