package day15;

public class Student implements Comparable<Student> {
	// 학생 클래스 name, score만 가지는 클래스 생성
	private String name;
	private int score;
	
	public Student() {}
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "[" + name + ":" + score + "]";
	}
	@Override
	public int compareTo(Student o) {
		// o1, o2를 비교하여 정렬
		// this. o 를 비교
		return this.name.compareTo(o.getName());
	}
	
}
