package day11;

public class Interface01 {

	public static void main(String[] args) {
		/* 인터페이스 : 추상메서드와 상수(final)로만 이루어진 것
		 * 추상메서드 : 메서드의 선언부만 있고, 구현부는 없는 메서드
		 * 추상클래스 / 인터페이스 => 반드시 구현해야 객체를 생성할 수 있음.
		 * 
		 * 인터페이스 키워드 : interface
		 * - 기능요약서 : 메뉴얼 화
		 * - 자체적으로 사용할 수 없고, 인터페이스를 구현한 클래스로 활용
		 * - 구현 키워드 : implements
		 * - 인터페이스는 멤버변수가 없음. 이 부분은 염두에 두고 메서드 정리를 해야함. 
		 * 
		 * - 상속 : 다중상속이 불가능 (단일상속이 원칙)
		 * - 구현 : 다중 구현이 가능
		 * - 상속 + 구현 동시에 가능.
		 * */
		TV tv = new TV();
		tv.trunOn();
		tv.chUp();
		tv.volUp();
		tv.trunOff();

	}

}

interface Power{
	abstract void trunOn();
	abstract void trunOff();
}

interface Remocon{
	void volUp();
	void volDown();
}

// class TV extends A implements B {  } // 상속과 구현을 동시에

// 다중 구현
class TV implements Power, Remocon{
	
	private boolean power;
	private int vol;
	private int ch;
	
	
	@Override
	public void volUp() {
		if(power) {
			vol++;
			System.out.println("vol:"+vol);
		}
		
	}

	@Override
	public void volDown() {
		if(power) {
			vol--;
			System.out.println("vol:"+vol);
		}
		
	}

	@Override
	public void trunOn() {
		power = true;
		System.out.println("TV ON");
	}

	@Override
	public void trunOff() {
		power = false;
		System.out.println("TV OFF");
		
	}  
	
	public void chUp() {
		if(power) {
			ch++;
			System.out.println("ch:"+ch);
		}
	}
	
	public void chDown() {
		if(power) {
			ch--;
			System.out.println("ch:"+ch);
		}
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}
	
}
