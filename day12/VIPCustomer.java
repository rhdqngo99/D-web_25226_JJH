package day12;

public class VIPCustomer extends Customer {

	// 할인율 / 전담상담사 이름 / 상담사 번호
	private double saleRatio;
	private int agentNum;
	private String agentName;
	
	public VIPCustomer() {}
	
	// 생성자
	public VIPCustomer(int id, String name, int agentNum, String agentName) {
		super(id, name);
		this.customerGrade = "VIP";
		this.bonusRatio = 0.03;
		this.saleRatio = 0.1;
		this.agentNum = agentNum;
		this.agentName = agentName;
	}
	
	// 메서드 오버라이딩
	@Override
	public int calcPrice(int price) {
		// 새로 계산
		// 할인금액 적용이 필요하므로... calcPrice 메서드를 그대로 사용할 수 없음. 
		// 오버라이드 후 수정.
		this.bonusPoint += (int)(price*bonusRatio);
		return price - (int)(price * saleRatio);
	}
	
	@Override
	public void customerInfo() {
		// 기존 내용에 추가
		super.customerInfo();
		System.out.println("담당 상담사는 "+agentName+"("+agentNum+")입니다.");
	}
	
	public double getSaleRatio() {
		return saleRatio;
	}

	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

	public int getAgentNum() {
		return agentNum;
	}

	public void setAgentNum(int agentNum) {
		this.agentNum = agentNum;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	@Override
	public String toString() {
		return "VIPCustomer [saleRatio=" + saleRatio + ", agentNum=" + agentNum + ", agentName=" + agentName + "]";
	}
	
	
}
