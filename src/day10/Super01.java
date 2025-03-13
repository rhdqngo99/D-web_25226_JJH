package day10;

public class Super01 {

	public static void main(String[] args) {
		/* 상속 : 부모의 것을 자식에게 물려주는 것.
		 * - 멤버변수/메서드만 상속가능.
		 * - 클래스의 확장 개념. 
		 * - 상속을 하는 이유 : 재사용을 해서 중복코드를 줄이고, 유지보수를 쉽게하기 위해
		 * 
		 * class A(부모), class B(자식)
		 * 
		 * class B extends A{
		 * 
		 * }
		 * 
		 * 상속키워드 : extends
		 * - 상속을 받으면 부모의 멤버변수와 메서드를 사용할 수 있다.
		 * - 접근제어자가 private 이면 자식이 접근 불가능.
		 * - 접근제어자가 protected : 상속받는 자식에게 허용하는 제어자
		 * - 상속은 1개만 가능. 부모가 2명이 될 수 없음. (단일 상속이 원칙)
		 * */
		A a = new A();
		a.setA(1);
		a.setB(2);
		a.setC(3);
		a.num = 10;  // 접근제어자가 protected라서 직접 접근가능.
		a.print();
		System.out.println("-------------");
		
		B b = new B();
		b.setA(10);
		b.setB(20);
		b.setC(20);
		b.setD(40);
		b.setE(50);
		b.setF(60);
		b.num = 100; // 접근제어자가 protected라서 직접 접근가능.
		b.print();
		

	}

}


class A{ //부모클래스
	private int a,b,c; //나만사용가능
	protected int num;  //상속가능 변수
	
	public void print() {
		System.out.println("a:"+a+", b:"+b+", c:"+c);
		System.out.println("num:"+num);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}

class B extends A{ //자식클래스
	private int d,e,f;
	
	//override(오버라이드) : 부모의 메서드를 재정의하여 사용하는 것.
	// super : 부모의 값을 가져올 때 키워드
	// this : 내 값을 사용할 때 키워드
		
	@Override
	public void print() {
		// 부모의 값을 호출
		super.print();
		System.out.println("d:"+d+", e:"+e+", f:"+f);
	}

	public int getD() {
		return d;
	}


	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}
	
	
}
