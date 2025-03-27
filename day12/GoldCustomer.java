package day12;

public class GoldCustomer extends Customer{
	
	// gold / vip => 할인율 존재
	private double saleRatio;
	
	public GoldCustomer() {}
	
	// 생성자 추가
	public GoldCustomer(int id, String name) {
		super(id, name);
		this.customerGrade = "Gold";
		this.bonusRatio = 0.02;
		this.saleRatio = 0.1;
	}
	
	@Override
	public int calcPrice(int price) {
		// 할인금액 적용이 필요하므로... calcPrice 메서드를 그대로 사용할 수 없음. 
		// 오버라이드 후 수정.
		this.bonusPoint += (int)(price*bonusRatio);
		return price - (int)(price * saleRatio);
	}
	

	public double getSaleRatio() {
		return saleRatio;
	}

	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

	@Override
	public String toString() {
		return "GoldCustomer [saleRatio=" + saleRatio + "]";
	}

}
