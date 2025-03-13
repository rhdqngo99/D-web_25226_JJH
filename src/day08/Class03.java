package day08;

public class Class03 {

	public static void main(String[] args) {
		
		Car1 c = new Car1();  // 기본생성자 호출 => 기본값으로 셋팅
		c.printInfo();
		System.out.println("----------");
		Car1 c1 = new Car1("모닝", "2025");
		c1.printInfo();
		System.out.println("----------");
		Car1 c2 = new Car1("아반테", "2022", "검정", 4);
		c2.printInfo();
	}

}

// 같은 패키지에 같은 이름의 클래스를 사용하면 error 
class Car1{
	
	// 멤버변수 : name, year, color, door(문짝개수), power, speed
	private String name;
	private String year;
	private String color;
	private int door;
	private boolean power;
	private int speed;
	
	//생성자 위치 - 멤버변수 아래 (메서드 위)
	/* 객체를 생성시 초기값을 지정해주는 역할 
	 * 기본생성자 : String = null, int = 0 (컴파일시 자동 제공)
	 * - 생성자는 여러개 생성 가능(생성자 오버로딩)
	 * - 오버로딩 조건 : 매개변수의 갯수, 타입이 달라야 함.(둘중 하나가 달라야함.)
	 * - 생성자를 사용자가 생성시, 기본 생성자는 사라짐.
	 * - 생성자를 만들 때는 꼭 기본생성자와 같이 생성해야 함.
	 * - public 클래스명(매개변수){
	 * 	 초기값 지정;
	 * }
	 * - 생성자는 리턴타입이 없는 메서드와 같은 형태
	 * */
	public Car1() { }  //기본생성자
	
	//생성자 오버로딩
	public Car1(String name, String year) {
		this.name = name;
		this.year = year;
	}
	
	public Car1(String name, String year, String color, int door) {
		//생성자 호출
		// - 가장 윗줄에서만 가능
		this(name, year);
//		this.name = name;
//		this.year = year;
		this.color = color;
		this.door = door;
	}
	
	//내 차량 정보를 출력하는 메서드
	public void printInfo() {
		System.out.println(name+"("+year+")");
		System.out.println(color+"("+door+")");
	}
	
	//getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
