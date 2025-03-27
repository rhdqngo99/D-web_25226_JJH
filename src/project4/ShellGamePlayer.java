package project4;

public class ShellGamePlayer {
	// 멤버 변수 초기화
	private int score;
	private int money;
	private int bettingMoney;
	


	// 기본 생성자 (1)
	public ShellGamePlayer() {}
	
	// 기본 생성자 (2) 
	public ShellGamePlayer(int score,int money) {
		this.score = score;
		this.money = money;
	}
	
	
	// toString()
	@Override
	public String toString() {
		return "ShellGamePlayer [score=" + score + ", money=" + money + "]";
	}
	
	
	// 메서드 
	// 정답 : 배팅머니 얻고 +10 점수 1점
	public void answer(int bettingMoney) {
		this.money += bettingMoney + 100;
		this.score += 1;
	}
	
	
	// 꽝: 배팅 머니 잃음
	public void boom(int bettingMoney) {
		if(this.money < 0) {
			System.out.println("파산입니다");
		}

		this.money -= bettingMoney;
	} 
	
	
	// 폭탄: 돈 잃고 점수 1감소
	public void bomb(int bettingMoney) {
		if(this.money < 0) {
			System.out.println("파산입니다");
		}
		
		if(score <= 0) { 
			this.money -= 100;
			System.out.println("차감할 점수가 없습니다 !");
			System.out.println("소지금 -100 차감합니다");
		} 
			else if(score > 0) { 
			this.money -= bettingMoney;
			this.score -= 1;
		}
	}
	

	public static final String RESET = "\u001B[0m"; 
	public static final String FONT_RED = "\u001B[31m"; 
	
	
	public boolean betting(int n) {
		boolean bool = false;
		
		if(this.money < n) {
			bool = false;
			System.out.println(FONT_RED
					+"_______________________________________________\r\n"
					+"                                            \r\n"
					+"        ! 소지금보다 배팅금액이 더 큽니다 !         \r\n"
					+"                도박은 마약 입니다               \r\n"
					+"                                            \r\n"
					+"   상담안내,자가진단|전화상담 국번없이 1336 (365일)   \r\n"
					+"                                            \r\n"
					+"      불법도박 등 범죄수익신고|국번없이 1301         \r\n"
					+"_______________________________________________\r\n"+ RESET);
		  
		  System.out.println("현재 소지금 : " + this.money);
		}
		
		else if(this.money >= n) { 
			bool = true; 
			bettingMoney = n;
		}
		
		return bool;
	}
	
	
	// Getter(), Setter() 
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	int getBettingMoney() {
		return bettingMoney;
	}

	void setBettingMoney(int bettingMoney) {
		this.bettingMoney = bettingMoney;
	}
}
