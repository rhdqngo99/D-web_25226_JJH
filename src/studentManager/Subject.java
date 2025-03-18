package studentManager;

public class Subject {
	//과목코드, 과목명, 학점, 시수, 교수명, 시간표, 강의장...
	private String subNum;
	private String subName;
	private int subPoint;
	private int subTime;
	private String subProfessor;
	private String subTimeTable;
	private String subRoom;
	
	// 생성자
	public Subject() {}

	public Subject(String subNum, String subName, int subPoint, 
			int subTime, String subProfessor, String subTimeTable,
			String subRoom) {
		this.subNum = subNum;
		this.subName = subName;
		this.subPoint = subPoint;
		this.subTime = subTime;
		this.subProfessor = subProfessor;
		this.subTimeTable = subTimeTable;
		this.subRoom = subRoom;
	}
	
	public Subject(String subNum, String subName) {
		this.subNum = subNum;
		this.subName = subName;
	}

	@Override
	public String toString() {
		return "Subject [subNum=" + subNum + ", subName=" + subName + ", subPoint=" + subPoint + ", subTime=" + subTime
				+ ", subProfessor=" + subProfessor + ", subTimeTable=" + subTimeTable + ", subRoom=" + subRoom + "]";
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
	
}
