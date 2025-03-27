package day11;

public class Abstract01 {

	public static void main(String[] args) {
		/* 추상클래스 : 미완성클래스
		 * 추상메서드 : 메서드의 선언부만 있고, 구현은 없는 메서드
		 * 추상클래스 : 추상메서드 + 일반메서드 + 멤버변수 + 상수(final)
		 * 추상클래스는 미완성클래스 이기 때문에 객체를 생성할 수 없다.
		 * 키워드 : abstract
		 * abstract 클래스명 / abstract 메서드명
		 * abstract 리턴타입 메서드명(매개변수); => 추상메서드
		 * - 추상클래스에서 abstract 키워드를 반드시 기재해야 함.
		 * - 인터페이스에서는 abstract 키워드 생략가능. => (어차피 추상메서드만 존재)
		 * - 상속을 하기위한 부모클래스를 만들기 위해 사용.
		 * - 상속을 받은 자식 클래스에서는 반드시 추상메서드를 구현해야 함.
		 * */
		Dog dog = new Dog("뽀비","개");
		dog.printInmfo();
		dog.howl();
		dog.eating("고기");
	}

}

class Dog extends Animal{
	
	private String eat;
	
	public Dog(String name, String category) {
		super.name = name;
		super.category = category;
	}

	@Override
	public void howl() {
		System.out.println(super.name+" 울음소리 : 멍멍!!");
	}
	
	public void eating(String eat) {
		this.eat = eat;
		System.out.println(name+"은 "+eat+"를 좋아합니다.");
	}
	
}

//abstract : 추상클래스
abstract class Animal{
	protected String name;
	protected String category;
	
	public void printInmfo() {
		System.out.println("이름:"+name);
		System.out.println("종:"+category);
	}
	public abstract void howl(); //추상메서드
	
}