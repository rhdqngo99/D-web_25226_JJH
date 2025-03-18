package studentManager;

import java.util.Arrays;

public class Student {
	//학번, 이름, 나이, 전화번호, 주소, 수강과목(Subject class[])
	private String stdNum;
	private String stdName;
	private String stdAge;
	private String stdPhone;
	private String stdAddress;
	private Subject[] subject = new Subject[5]; //내가 수강신청한 목록
	private int cnt;
	
	// 생성자
	public Student() {}

	public Student(String stdNum, String stdName, String stdAge, 
			String stdPhone, String stdAddress) {
		this.stdNum = stdNum;
		this.stdName = stdName;
		this.stdAge = stdAge;
		this.stdPhone = stdPhone;
		this.stdAddress = stdAddress;
	}
	
	public Student(String stdNum, String stdName) {
		this.stdNum = stdNum;
		this.stdName = stdName;
	}
	
	// 내가 필요한 메서드 추가하기.
	// 과목의 객체가 들어오면(입력) 내 수강배열(subject)에 추가
	public void insertSubject(Subject s) {
		if(cnt == subject.length) {
			//배열복사하여 배열 늘려주기
			Subject[] tmp = new Subject[subject.length+5];
			// 배열복사
			System.arraycopy(subject, 0, tmp, 0, subject.length);
			// 기존 객체명에 객체 바꾸기
			subject = tmp;
		}
		subject[cnt] = s;
		cnt++;
		System.out.println("수강신청 완료");
	}
	
	public void deleteSubject(String subNum) {
		// 실제 배열에서 수강과목을 삭제하는 메서드
		// subject 배열에서 subNum가 몇번지에 있는지 찾기
		int index = -1;
		if(subNum == null) {
			return;
		}
		for(int i=0; i<cnt; i++) {
			if(subject[i].getSubNum().equals(subNum)) {
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			//찾는 값이 없다면...
			System.out.println("철회 과목이 없습니다.");
			return;
		}
		
		// 삭제 : index 번지부터 뒷번지를 앞으로 옮기는 작업
		for(int i=index; i<cnt-1; i++) {
			subject[i] = subject[i+1];
		}
		
		//마지막 끝번지는 null
		subject[cnt-1] = null;
		cnt--;
		System.out.println("수강철회 완료");
		
	}

	@Override
	public String toString() {
		return "[stdNum=" + stdNum + ", stdName=" + stdName + ", stdAge=" + stdAge + ", stdPhone=" + stdPhone
				+ ", stdAddress=" + stdAddress + ", subject=" + Arrays.toString(subject) + "]";
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

	public Subject[] getSubject() {
		return subject;
	}

	public void setSubject(Subject[] subject) {
		this.subject = subject;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
