package day08;

public class Exam01 {

	public static void main(String[] args) {
//		/* Tv 클래스 생성
//		 * 맴버변수 : brand, power, ch, vol
//		 * 메서드 : 
//		 * power()
//		 * chUp() / chDown() : 1씩 증가 / 감소
//		 * 30까지 있음 30이 넘어가면 1로 순환구조
//		 * 
//		 * volUp / volDown() : 1씩 증가 / 감소
//		 * vol 10까지 있음. 10이 넘으면 10, 0이면 음소거라고 출력
//		 * */
//		Tv myTv = new Tv();
//		myTv.setBrand("삼성");
//		
//		myTv.power();
//		myTv.chUp();
//		myTv.volUp();
//		myTv.chDown();
//		myTv.volDown();
//		myTv.volDown();
//		myTv.power();
//		
//		System.out.println("------------------------");
//		System.out.println("Tv브랜드: "+ myTv.getBrand());
//		System.out.println("전원: "+(myTv.isPower() ? "켜짐" : "꺼짐"));
//		System.out.println("현 채널: " + myTv.getCh());
//        System.out.println("현 볼륨: " + myTv.getVol());
		
		Tv t = new Tv();
		t.power();
		t.chUp();
		t.setCh(28);
		t.chUp();
		System.out.println("----");
		t.chDown();
		System.out.println("----");
		t.volUp();
		System.out.println("----");
		t.volDown();
		
	}

}

//class Tv{
//	private String brand;
//	private boolean power;  
//	private int ch;        
//	private int vol;
//	
//	public Tv() {
//	    this.brand = brand;
//        this.power = false;
//        this.ch = 1; 
//        this.vol = 0; 
//    }
//	
//	public void power() {
//		power = !power;	
//		if(power) {
//			System.out.println("Tv켬");
//		}else {
//			System.out.println("Tv끔");
//		}
//	}
//	
//	public void chUp() {
//		if(ch < 30) {
//			ch++;
//		}else {
//			ch = 1;
//		}
//		System.out.println("채널: " + ch);
//	}
//	public void chDown() {
//		if(ch > 1) {
//			ch--;
//		}else {
//			ch = 30;
//		}
//		System.out.println("채널: " + ch);
//	}
//	
//	 public void volUp() {
//		 if(vol < 10) {
//			 vol++;
//		 }
//		 System.out.println("음량: " + (vol == 10 ? "Max" : vol));
//	 }
//	 
//	 public void volDown() {
//		 if(vol > 0) {
//			 vol--;
//			 System.out.println("음량: " + vol);
//		 }else {
//			 System.out.println("음소거");
//		 }
//		 
//	 }
//	 
//	 public void live() {
//			System.out.println("Tv상태: " + (power ? "켜짐" : "꺼짐"));
//			System.out.println("현 채널: " + ch);
//			System.out.println("현 음량"+(vol == 0 ? "음소거" : vol));
//	 }
//
//	public String getBrand() {
//		return brand;
//	}
//
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//
//	public boolean isPower() {
//		return power;
//	}
//
//	public void setPower(boolean power) {
//		this.power = power;
//	}
//
//	public int getCh() {
//		return ch;
//	}
//
//	public void setCh(int ch) {
//            this.ch = ch;
//	}
//
//	public int getVol() {
//		return vol;
//	}
//
//	public void setVol(int vol) {
//            this.vol = vol;
//	}
//	 
//}

class Tv{
	// 상수 : 변하지 않는 값. = final 변경할 수 없는 값을 지정. (변수명은 대문자로)
	private final String BRAND="LG";
	private boolean power;
	private int ch;
	private int vol;
	
	public Tv() {
		ch = 1;
		vol = 3;
	}
	
	public void print() {
		System.out.println(BRAND+"TV, ch:"+ch+" / vol:"+vol);
	}
	
	public void power() {
		power = !power;
		if(power) {  //tv가 켜져있다면...
			System.out.println("전원이 켜집니다.");
			print();
		}else {
			System.out.println("전원이 꺼집니다.");
		}
	}
	
	public void chUp() { //ch 기본값 = 1
		if(power) {
			ch++;
			if(ch >30) {
				ch=1;
			}
			System.out.println("ch:"+ch);
		}
	}
	
	public void chDown() {
		if(power) {
			ch--;
			if(ch<=0) {
				ch=30;
			}
			System.out.println("ch:"+ch);
		}
	}
	
	public void volUp() {
		if(power) {
			vol++;
			if(vol > 10) {
				vol = 10;
			}
			System.out.println("vol:"+vol);
			
		}
	}
	
	public void volDown() {
		if(power) {
			vol--;
			if(vol <= 0) {
				System.out.println("음소거");
				vol=0;
			}else {
				System.out.println("vol:"+vol);
			}
		}
	}
	
	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}

	public String getBRAND() {
		return BRAND;
	}

}



