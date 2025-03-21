package examStd;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Student {
	/*  - 학번, 이름, 나이, 전화번호, 주소, 
  		- 과목 클래스 리스트(신청하면 추가)
	 * */
	private String stdNum; //학번
	private String stdName; //이름
	private String stdAge; //나이
	private String stdPhone; //전화번호
	private String stdAddress; //주소
	private int total; // 내가 수강하고 있는 과목의 점수합계
	private ArrayList<Subject> subject = new ArrayList<Subject>();
	
	public Student() {}

	public Student(String stdNum, String stdName, 
			String stdAge, String stdPhone, String stdAddress) {
		this.stdNum = stdNum;
		this.stdName = stdName;
		this.stdAge = stdAge;
		this.stdPhone = stdPhone;
		this.stdAddress = stdAddress;
	}
	
	public Student(String stdNum) {
		this.stdNum = stdNum;
	}
	
	// 내가 필요한 메서드 추가하기
	// subject에 데이터 추가하기 : 수강신청
	public void insertSub(Subject tmp) {
		// subject 객체가 입력되면, 내 수강신청 리스트에 추가
		for(Subject s: subject) {
			if(s.equals(tmp)) {
				System.out.println("이미 신청한 과목입니다.");
				return;
			}
		}
		subject.add(tmp);
		System.out.println("수강신청 완료");
	}
	
	// subject에 데이터 삭제하기 : 수강철회
	public void deleteSub(String num) {
		// 수강취소 번호를 주면 수강 삭제하기
		if(subject.remove(new Subject(num))) {
			System.out.println("수강삭제 완료");
			return;
		}
		System.out.println("삭제할 과목이 없습니다.");
	}
	
	//성적 등록하기
	// 어떤과목? (과목번호) / 몇점? (점수)
	// 해당 성적을 등록 후 점수에 누적 total
//	public void subjectScore(String subNum, int score) {
//		// TODO Auto-generated method stub
//		for(int i=0; i<subject.size(); i++) {
//			if(subject.get(i).getSubNum().equals(subNum)) {
//				subject.get(i).setSubScore(score);
//				total += score;
//				return;
//			}
//		}
//		System.out.println("과목이 없습니다.");
//	}
	
	// 과목이 있을 때만 점수 받기
	public void subjectScore(String subNum, Scanner scan) {
		// TODO Auto-generated method stub
		for(int i=0; i<subject.size(); i++) {
			if(subject.get(i).getSubNum().equals(subNum)) {
				System.out.println("점수>");
				int score = scan.nextInt();
				subject.get(i).setSubScore(score);
				total += score;
				return;
			}
		}
		System.out.println("과목이 없습니다.");
	}
	
	// subject에 데이터 조회하기 : 과목에 대한 조회 (성적추가)
	// subject 출력하기
	public void subjectPrint() {
		System.out.println("--"+ stdNum+"님 수강신청목록--");
		if(subject.size() == 0) {
			System.out.println("수강신청목록이 없습니다.");
			return;
		}
		for(Subject s : subject) {
			System.out.println(s);				
		}
		System.out.println("---------------------------");
	}
	
	
	public String getStdNum() {
		return stdNum;
	}

	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdAge() {
		return stdAge;
	}

	public void setStdAge(String stdAge) {
		this.stdAge = stdAge;
	}

	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}

	public String getStdAddress() {
		return stdAddress;
	}

	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ArrayList<Subject> getSubject() {
		return subject;
	}

	public void setSubject(ArrayList<Subject> subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [stdNum=" + stdNum + ", stdName=" + stdName + ", stdAge=" + stdAge + ", stdPhone=" + stdPhone
				+ ", stdAddress=" + stdAddress + ", total=" + total + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(stdNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(stdNum, other.stdNum);
	}

}

