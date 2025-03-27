package examStd;

public class StudentMain {

		public static void main(String[] args) {
			
			// 컨트롤러 객체 생성
			StudentController sc = new StudentController();
			sc.addStudent(); // 학생데이터 추가
			sc.addSubject(); // 과목데이터 추가
			
			int menu = 0;
			
			do {
				// 메뉴넣기
				
				menu = sc.menuPrint();  //컨트로러에서 메서드 생성하기
				
				/*  - 학생등록 | 학생리스트출력 | 학생검색(학생정보)
				- 학생정보수정 | 학생삭제
				- 수강신청 | 수강철회
				- 과목별 신청자리스트 (학생정보)
				- 학생별 성적 등록(교수님전용)
				- 학생별 성적표 출력 (학생의 수강정보+성적) => 성적평균
				- 종료
				 * */
				switch(menu) {
				case 1: sc.insertStudent(); break;
				case 2: sc.printStudent(); break;
				case 3: sc.searchStudent(); break;
				case 4: sc.modifyStudent(); break;
				case 5: sc.removeStudent(); break;
				case 6: sc.insertSubject(); break;
				case 7: sc.removeSubject(); break;
				case 8: sc.searchSubject(); break;
				case 9: sc.insertScore(); break;
				case 10: sc.printScore(); break;
				case 11: 
					System.out.println("종료");
					break;
					default:
						System.out.println("잘못된 메뉴입니다.");
				}
				
			}while(menu != 11);
		}

	}
