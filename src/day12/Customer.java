package day12;

public class Customer {
	/*- 멤버변수
	 * 고객ID : int customerID
	 * 고객이름 : String customerName
	 * 고객등급 : String customerGrade
	 * 보너스포인트 : int bonusPoint
	 * 보너스포인트 적립비율 : double bonusRatio
	 * 
	 * 클래스 생성
	 * - 메서드
	 * 1. 보너스 적립 계산 메서드 (메서드명 : calcPrice)
	 *    - 구매금액의 적립 보너스를 계산 => bonusPoint 누적
	 *    - 보너스 적립, 할인여부를 체크해서 구매 price를 리턴
	 *    
	 * 2. 출력메서드 (메서드명 : customerInfo())
	 *    - 홍길동님은 VIP고객이며, 보너스 포인트는 1000점 입니다.
	 *    - 전담 상담사는 OOO 이고, 번호는 1111입니다. <- VIP
	 *    
	 * 3. 등급별 할인 적립 여부
	 *    - Silver 등급
	 *    - 제품을 구입할 때 0% 할인 / 보너스 포인트 1% 적립
	 *    - Gold 등급
	 *    - 제품을 구입할 때 10% 할인 / 보너스 포인트 2% 적립
	 *    - VIP 등급
	 *    - 제품을 구입할 때 10% 할인 / 보너스 포인트 3% 적립
	 *    - 전담 상담사를 멤버변수에 추가하여 (agentName, agentNum)
	 * */
	
	// 멤버변수 선언
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	protected int bonusPoint;
	protected double bonusRatio;
	
	//생성자
	public Customer() {}
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerGrade = "Silver";
		this.bonusRatio = 0.01;
	}
	
	//보너스 적립 계산 메서드 (메서드명 : calcPrice)
	// 리턴타입 : 할인율을 적용한 구매금액(int) / 매개변수: int price
	public int calcPrice(int price) {
		int point = (int)(price * this.bonusRatio);
		this.bonusPoint = this.bonusPoint + point;
		
//		this.bonusPoint += (int)(price * this.bonusRatio);
		//실버등급이기 때문에 0%
		return price;
	}
	
	
	//출력메서드 (메서드명 : customerInfo())
	public void customerInfo() {
		//홍길동님은 VIP고객이며, 보너스 포인트는 1000점 입니다.
		System.out.print(customerName+"님은 " +customerGrade+"고객이며,");
		System.out.println("보너스 포인트는 "+bonusPoint+"점 입니다.");
	}
	
	//getter/setter
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}
	
}
