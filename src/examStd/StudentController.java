package examStd;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
	// 학생 리스트
	private ArrayList<Student> studentList = new ArrayList<>();  
	
	// 과목 리스트
	private ArrayList<Subject> subjectList = new  ArrayList<>();
	// 현 컨트롤러 하위 모든메서드에서 Scanner 객체 사용가능.
	Scanner scan = new Scanner(System.in);
	
	// 학생리스트에 데이터 넣기, 빼기, 수정, 출력
	// 과목리스트에 데이터 넣기, 빼기, 수정, 출력
	public void addStudent() {
		//학생데이터 미리 추가
		// 리스트에 들어있는 값이 객체 형태이기 때문에 
		// 객체를 생성해서 추가
		studentList.add(new Student("111", "홍길동", "20", "010-1111-1111", "서울시"));
		studentList.add(new Student("222", "김순이", "20", "010-1111-2222", "서울시"));
		studentList.add(new Student("333", "박철수", "21", "010-1111-3333", "경기도"));
		studentList.add(new Student("444", "이영철", "20", "010-1111-4444", "서울시"));
		studentList.add(new Student("555", "신짱구", "21", "010-1111-5555", "경기도"));
	}
	public void addSubject() {
		//수강가능과목 미리 추가
		subjectList.add(new Subject("1111", "java", 3, 2, "홍길동", "화목/2시~4시", "1강의장", 0));
		subjectList.add(new Subject("2222", "DB", 3, 2, "이순신", "월수/2시~4시", "2강의장", 0));
		subjectList.add(new Subject("3333", "HTML", 2, 3, "김영이", "화금/2시~4시", "3강의장", 0));
		subjectList.add(new Subject("4444", "CSS", 2, 3, "황기동", "월목/2시~4시", "4강의장", 0));
		subjectList.add(new Subject("5555", "javascript", 3, 3, "박순철", "수목/2시~4시", "5강의장", 0));
	}

	public int menuPrint() {
		// TODO Auto-generated method stub
		System.out.println("--menu--");
		System.out.println("1.학생등록 | 2.학생리스트출력 | 3.학생검색(학생정보)");
		System.out.println("4.학생정보수정 | 5.학생삭제");
		System.out.println("6.수강신청 | 7.수강철회");
		System.out.println("8.과목별 신청자리스트 (학생정보)");
		System.out.println("9.학생별 성적 등록(교수님전용)");
		System.out.println("10.학생별 성적표 출력 (학생의 수강정보+성적)");
		System.out.println("11.종료");
		System.out.println("> menu >");
		return scan.nextInt();
	}

	public void insertStudent() {
		// 학생 추가
		System.out.println("학번>");
		String num = scan.next();
		System.out.println("이름>");
		String name = scan.next();
		System.out.println("나이>");
		String age = scan.next();
		System.out.println("전화번호>");
		String phone = scan.next();
		scan.nextLine();//공백처리용 nextLine();
		System.out.println("주소>");
		//nextLine() 은 공백을 처리하기 때문에 
		//nextLine() 메서드 전에 Enter의 입력이 존재한다면
		//공백처리용 nextLine()이 하나더 필요함.
		String address = scan.nextLine();
		
		//학생 객체 생성
		Student s = new Student(num, name, age, phone, address);
		studentList.add(s);
		System.out.println("학생등록완료");
	}

	public void printStudent() {
		// 학생 리스트 출력
		System.out.println("--학생전체목록--");
		for(Student s : studentList) {
			System.out.println(s);
		}
		System.out.println("----------------");
		
	}
	//수강신청시 목록에서 확인가능한 용도
	public void printSubjectList() {
		System.out.println("--수강신청과목 목록--");
		for(Subject s : subjectList) {
			System.out.println(s);
		}
		System.out.println("---------------------");
	}

	public void searchStudent() {
		// 학생검색
		System.out.println("검색 학번>");
		String num = scan.next();
		// 학생리스트에서 해당 학번을 가지는 학생이 있는지 확인후 출력
//		for(Student s : studentList) {
//			if(s.getStdNum().equals(num)) { // equals() 사용X 경우
//				System.out.println(s);
//				//수강신청 목록도 출력
//				s.subjectPrint();
//				return;
//			}
//		}
//		System.out.println("학번이 없습니다.");
		for(Student s : studentList) {
			if(s.equals(new Student(num))) { //equals() 사용
				System.out.println(s);
				//수강신청 목록도 출력
				s.subjectPrint();
				return;
			}
		}
		System.out.println("학번이 없습니다.");
	}

	public void modifyStudent() {
		// 학생수정 => 삭제 후 다시 추가
	}

	public void removeStudent() {
		// 학생삭제
		System.out.println("삭제 학번>");
		String num = scan.next();
		if(studentList.remove(new Student(num))) {
			System.out.println("삭제완료");
			return;
		}
		System.out.println("학번이 없습니다.");
	}

	public void insertSubject() {
		// 수강신청
		// 누가? 학번을 받아, 
		// 어떤과목? Student class method => 매개변수 전달
		// 그 학생 객체의 subject 리스트에 값을 추가
		System.out.println("수강신청 학번>");
		String num = scan.next();
		// 해당 학번이 있는지 검색
		for(int i=0; i<studentList.size(); i++) {
			if(studentList.get(i).equals(new Student(num))){
				// 수강신청이 가능한 과목리스트 출력
				printSubjectList(); 
				System.out.println("수강신청 과목번호>");
				String subNum = scan.next();
				// 해당 과목의 정보를 가져와서 객체로 전달
				for(Subject s : subjectList) {
					if(s.equals(new Subject(subNum))) {
						Subject tmp = new Subject(s); // 생성자추가
						// Student 클래스에서 추가
						studentList.get(i).insertSub(tmp);
						return;
					}
				}
				System.out.println("신청과목이 없습니다.");
				return;
			}
		}
		System.out.println("검색 학번이 없습니다.");
	}

	public void removeSubject() {
		// 수강취소
		// 누가?  무슨과목 ?
		System.out.println("학번>");
		String num = scan.next();
		for(int i=0; i<studentList.size(); i++) {
			if(studentList.get(i).equals(new Student(num))) {
				//내가 수강신청한 목록 출력
				studentList.get(i).subjectPrint();
				System.out.println("삭제 과목>");
				String subNum = scan.next();
				studentList.get(i).deleteSub(subNum);
				return;
			}
		}
		System.out.println("검색학번이 없습니다.");
	}
	
	public void searchSubject() {
		// 과목을 주고, 해당과목을 수강하는 학생명단 출력
		// 출력 : 학생명단 , 조건 : 수강과목에 검색대상 과목이 존재하는지..
		System.out.println("검색 과목번호>");
		String subNum = scan.next();
		int index = 0;
		for(Student s : studentList) {
			//각 학생이 수강신청한 수강신청개수
			for(int i=0; i<s.getSubject().size(); i++) {
				if(s.getSubject().get(i).equals(new Subject(subNum))) {
					System.out.println(s);
					index++;
				}
			}
		}
		if(index==0) {
			System.out.println("수강신청자가 없습니다.");
		}
	}

	public void insertScore() {
		// 학생 성적 등록
		// 누구? 무슨과목?
		System.out.println("학번>");
		String num = scan.next();
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				// 내가수강하고 있는 과목 출력
				s.subjectPrint();
				System.out.println("과목번호>");
				String subNum = scan.next();
//				System.out.println("점수>");
//				int score = scan.nextInt();
//				s.subjectScore(subNum, score);
				s.subjectScore(subNum, scan);
				return;
			}
		}
		System.out.println("검색학번이 없습니다.");
		
	}

	public void printScore() {
		// 성적표 출력
		System.out.println("학번>");
		String num = scan.next();
		
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				s.subjectPrint();
				System.out.println("평균:"+
						((double)s.getTotal()/s.getSubject().size()));
				return;
			}
		}
		
		System.out.println("학번이 없습니다.");
	}
}