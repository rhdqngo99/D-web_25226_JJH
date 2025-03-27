package day16;

import studentManager.Subject;

public class Student { // 학생 클래스
	
//	- 학번, 이름, 나이, 전화번호, 주소, 
//	- 과목 클래스 리스트(신청하면 추가)
	
	private String stdNum;
	private String stdName;
	private int stdAge;
	private int stdPhone;
	private String stdAddress;
	private Subject[] subject = new Subject[5];
	private int cnt;

public Student(String num, String name, String age, String phone, String address) {}

public Student(String stdNum, String stdName, int stdAge, 
		int stdPhone, String stdAddress) {
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

public int getStdAge() {
	return stdAge;
}

public void setStdAge(int stdAge) {
	this.stdAge = stdAge;
}

public int getStdPhone() {
	return stdPhone;
}

public void setStdPhone(int stdPhone) {
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