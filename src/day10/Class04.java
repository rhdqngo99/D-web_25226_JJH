package day10;

public class Class04 {

	public static void main(String[] args) {
		/* 객체를 생성시 값을 초기화 하는 방법
		 * - 기본값, 명시적 초기값, 초기화 블럭, 생성자
		 * 1. 기본값 : 멤버변수 선언시 기본적으로 주는 값 int = 0, String = null
		 * 2. 명시적 초기값 : 기본값을 직접 명시하여 주는 값.
		 *    brand = "LG"
		 * 3. 초기화 블럭 : {초기값 지정.} => 멤버변수 초기화
		 * 4. 생성자 : 객체를 생성 할 때 초기화 해서 생성
		 * 
		 * 초기값의 우선순위
		 * 기본값 -> 명시적초기값 -> 초기화블럭 -> 생성자(우선순위가 가장 놓음)
		 * */
		Student s = new Student("aaa","bbb","cccc");
		System.out.println(s);

	}

}

class Student{
	private String gigum = "강남";  //명시적 초기값
	private String name;  // 기본값 null
	private String phone; // 기본값
	
	{
		//초기화 블럭 영역
		gigum="수원";
		name="미정";
		phone="000";
	}
	
	public Student() {}
	public Student(String gigum, String name, String phone) {
		this.gigum = gigum;
		this.name = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student [gigum=" + gigum + ", name=" + name + ", phone=" + phone + "]";
	}

	public String getGigum() {
		return gigum;
	}

	public void setGigum(String gigum) {
		this.gigum = gigum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
