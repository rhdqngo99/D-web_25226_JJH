package day10;

public class Product {
	/* Product 클래스 생성 : 상품을 등록하는 클래스
	 * 상품명, 가격
	 * 상품명과 가격을 출력하는 메서드
	 * 상품을 추가하는 메서드
	 * 커피 2000 => Product class 객체
	 * 사탕 1000
	 * */
	//멤버변수
	private String name;
	private int price;
	
	//생성자
	public Product() {}
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// 상품추가 메서드
	public void insertProduct(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	//기본 출력 메서드 toString()
	// 부모의 메서드를 자식이 사용하는 것(자식입장 : 내 형식에 맞게 수정가능)
	@Override
	public String toString() {
		return "[" + name + ":" + price + "]";
	}
		
	//getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
