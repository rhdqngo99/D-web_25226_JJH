package sale;

public class Order extends Menu {
	// - super : no, name, price 이미 있음. 
	// - 수량, 금액 (가격 * 수량)
	
	private int count; //수량
	private int total; //합계 (가격 * 수량)
	
	//생성자
	public Order() {}

	public Order(int menuNo, String menuName, int price, int count) {
		// menu 생성자 호출
		super(menuNo, menuName, price);
		this.count = count;
		this.total = price * count;
	}
	
	//print 메서드 추가 (한 주문에 대한 출력)
	public void printOrder() {
//		super.toString(); 
		System.out.println(super.getMenuNo()+". "+
				super.getMenuName()+"  "+super.getPrice()+
				" "+this.count+" => "+this.total);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [count=" + count + ", total=" + total + "]";
	}

}
