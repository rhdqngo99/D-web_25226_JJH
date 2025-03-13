package day08;

public class Class02 {

	public static void main(String[] args) {
		// Car 객체 생성
		Car myCar = new Car();
		myCar.setName("모닝");
		myCar.setColor("검정");
		myCar.setYear("2025");
		myCar.printCar();
		myCar.speedPrint();
		myCar.power();
		myCar.setSpeed(150);
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.power();

		myCar.speedPrint();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedUp();
//		myCar.speedPrint();
		myCar.setSpeed(20);
		myCar.speedDown();
		myCar.speedDown();
		myCar.speedDown();
		myCar.speedDown();
		myCar.speedDown();
		myCar.speedDown();
		myCar.power();
		myCar.speedPrint();
	}

}

class Car{
	//멤버변수 : name, color, year, power, speed => private
	private String name;
	private String color;
	private String year;
	private boolean power;
	private int speed;
	
	//메서드 => public
	// 현재 멤버변수의 상태 출력
	public void printCar() {
		System.out.println(name+"("+color+") : "+year);
	}
	
	public void speedPrint() {
		System.out.println((power? "ON" : "OFF") +" / "+ speed);
	}
	
	// 시동 켜기 / 끄기 메서드
	// power 꺼져있으면 => 켜기
	// power 켜져있으면 => 끄기
	public void power() {
		if(speed == 0) {
			power = !power;	
		}else {
			System.out.println("error!!");
		}
	}
	
	// 속도up()
	public void speedUp() {
		if(power) {
			if(speed >=200) {
				speed = 200;
			}else {
				speed += 10;				
			}
			speedPrint();
		}
	}
	
	
	// 속도 down()
	public void speedDown() {
		if(power) {
			if(speed <=0) {
				speed = 0;
			}else {
				speed -= 10;				
			}
			speedPrint();
		}
	}
	
	//getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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
