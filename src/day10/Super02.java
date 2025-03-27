package day10;

public class Super02 {

	public static void main(String[] args) {
		//
		Dog d = new Dog("뽀삐","개과");
		d.printInfo();
		d.howl();
		
		Cat c = new Cat("네로","고양이과");
		c.printInfo();
		c.howl();
	}

}
class Cat extends Animal{
	public Cat(String name, String category) {
		super.setName(name);
		super.setCategory(category);
	}

	@Override
	public void howl() {
		// TODO Auto-generated method stub
		super.howl();
		System.out.println("야옹!!");
	}
	
}

class Dog extends Animal{
	public Dog(String name, String category) {
		// 부모의 생성자 호출
		// 부모의 메서드를 호출하여 setter
		super(name, category);
		
//		super.setName(name)
//		super.setCategory(category);
	}

	@Override
	public void howl() {
		// TODO Auto-generated method stub
		super.howl();
		System.out.println("멍멍!!");
	}
	
}

class Animal{	//부모클래스
	private String name;
	private String category;
	
	//생성자
	public Animal() {}
	
	public Animal(String name, String category) {
		this.name = name;
		this.category = category;
	}
	
	public void printInfo() {
		System.out.println("이름:"+name);
		System.out.println("종:"+category);
	}
	
	public void howl() {
		System.out.println("--"+name+" 울음소리--");
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}