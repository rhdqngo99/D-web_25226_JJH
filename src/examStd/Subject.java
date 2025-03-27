package examStd;

import java.util.Objects;

public class Subject {
	/* - 과목코드, 과목명, 학점, 시수, 교수명, 
	    시간표, 강의장, 
	   - 점수(마지막에 추가)
	 * */
	private String subNum; //과목코드
	private String subName; //과목명
	private int subPoint; //학점
	private int subTime; //시수
	private String subProfessor; //교수명
	private String subTimeTable; //시간표
	private String subRoom; //강의장
	private int subScore; //점수
	
	// 생성자는 반드시 클래스명과 동일 (리턴타입 자리가 없음) 
	public Subject() {}

	public Subject(String subNum, String subName, int subPoint, int subTime, String subProfessor, String subTimeTable,
			String subRoom, int subScore) {
		this.subNum = subNum;
		this.subName = subName;
		this.subPoint = subPoint;
		this.subTime = subTime;
		this.subProfessor = subProfessor;
		this.subTimeTable = subTimeTable;
		this.subRoom = subRoom;
		this.subScore = subScore;
	}
	
	public Subject(String subNum) {
		this.subNum = subNum;
	}
	
	public Subject(Subject s) {
		// 과목목록의 subject
		this.subNum = s.subNum;
		this.subName = s.subName;
		this.subPoint = s.subPoint;
		this.subTime = s.subTime;
		this.subProfessor = s.subProfessor;
		this.subTimeTable = s.subTimeTable;
		this.subRoom = s.subRoom;
	}
	
	// equals()
	

	@Override
	public int hashCode() {
		return Objects.hash(subNum);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) //주소가 같다면 같은객체로 인지
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		//subNum만 같으면 같은 객체로 인정
		return Objects.equals(subNum, other.subNum); 
	}

	public String getSubNum() {
		return subNum;
	}


	public void setSubNum(String subNum) {
		this.subNum = subNum;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getSubPoint() {
		return subPoint;
	}

	public void setSubPoint(int subPoint) {
		this.subPoint = subPoint;
	}

	public int getSubTime() {
		return subTime;
	}

	public void setSubTime(int subTime) {
		this.subTime = subTime;
	}

	public String getSubProfessor() {
		return subProfessor;
	}

	public void setSubProfessor(String subProfessor) {
		this.subProfessor = subProfessor;
	}

	public String getSubTimeTable() {
		return subTimeTable;
	}

	public void setSubTimeTable(String subTimeTable) {
		this.subTimeTable = subTimeTable;
	}

	public String getSubRoom() {
		return subRoom;
	}

	public void setSubRoom(String subRoom) {
		this.subRoom = subRoom;
	}

	public int getSubScore() {
		return subScore;
	}

	public void setSubScore(int subScore) {
		this.subScore = subScore;
	}

	@Override
	public String toString() {
		return "Subject [subNum=" + subNum + ", subName=" + subName + ", subPoint=" + subPoint + ", subTime=" + subTime
				+ ", subProfessor=" + subProfessor + ", subTimeTable=" + subTimeTable + ", subRoom=" + subRoom
				+ ", subScore=" + subScore + "]";
	}
	
}
