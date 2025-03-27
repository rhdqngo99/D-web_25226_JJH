package project3;

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
		// answer() - 정답 시 나오는 메서드 
			// 배팅머니만큼 돈을 얻고 점수 1점 획득
	public void answer(int bettingMoney) {
		this.money += bettingMoney;
		this.score += 1;
	}
	
	
	// boom() - 꽝인 경우 나오는 메서드, 배팅 머니 잃음
	public void boom(int bettingMoney) {
		// 소지금만큼 배팅하여 돈을 잃는 경우 파산 출력 
		if((money - bettingMoney) <= 0) { 
			this.money = 0;
			zeroPrint(); 
		}
		
		else if((money - bettingMoney) > 0){
			this.money -= bettingMoney;
		}
	} 
	
	
	// 폭탄: 돈 잃고 점수 1감소
	public void bomb(int bettingMoney) {	
		// 점수가 0점 이하 일 때 수행하는 작업 
		if(score <= 0) { 
			// 점수가 0점이고 돈이 있는 경우 
			// 돈이 없는 경우, 소지금보다 배팅 금액이 더 큰 경우는 betting() 메서드로 인해
			// 수행될 수 없고 소지금보다 배팅금액을 크게 걸면 경고문구 출력 
			
			// 소지금만큼 배팅하여 돈을 잃는 경우 파산 출력 
			if((money - bettingMoney) <= 0) { 
				this.money = 0;
				zeroPrint(); 
			}
				
			// 소지금에서 배팅 금액을 뺀 금액이 0 보다 큰 경우
			else if((money - bettingMoney) > 0) {
				System.out.println("차감할 점수가 없습니다 !");
				System.out.println("소지금만 차감합니다");
				
				this.money = money - bettingMoney;
			}
		}
		 
			// 점수가 1점 이상이고 돈이 있는 경우
			else if(score > 0) { 
				this.money -= bettingMoney;
				this.score -= 1;
			}
	}
	

	public static final String RESET = "\u001B[0m"; 
	public static final String FONT_RED = "\u001B[31m"; 
	
	
	// betting() - 배팅 가능한지 판단하는 메서드 
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
	
	// 파산 상태 출력 메서드
	public void zeroPrint() {
		System.out.println("\r\n"
				+ "                  ⠀⣿⣿⣿⣗⠀                     ⣿⣿⣿⣿\r\n"
				+ " ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⣿⣿⣿⣗          ⣸⣿⣿⣿        ⣿⣿⣿⣿\r\n"
				+ " ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⣿⣿⣿⣗         ⡀⣺⣿⣿⣿⡇      ⠀⣿⣿⣿⣿\r\n"
				+ "   ⣿⣿⣿⡇    ⣿⣿⣿⡇    ⣿⣿⣿⡯         ⢀⣿⣿⣿⣿⣧      ⠀⣿⣿⣿⣿\r\n"
				+ "   ⣿⣿⣿⡇    ⣿⣿⣿     ⣿⣿⣿⡯        ⢡⣿⣿⣿⢿⣿⣿⣷      ⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "   ⣿⣿⣿⡇    ⣿⣿⣿     ⣿⣿⣿⣿⣿⣿⣿⡇ ⢄⣦⣿⣿⣿⠟⠈⢻⣿⣿⣿⣦⣂    ⣿⣿⣿⣿\r\n"
				+ "   ⣿⣿⣿⡇    ⣿⣿⣿     ⣿⣿⣿⡿⠛⠟⠟⠇⢴⣾⣿⣿⣿⡿⠋⡀⠡⠀⡉⠿⣿⣿⣿⡿  ⣿⣿⣿⣿\r\n"
				+ "   ⣿⣿⣿⡇    ⣿⣿⣿⠀    ⣿⣿⣿⡯    ⠈⠻⡿⠟⠋       ⡈⠛⡋   ⣿⣿⣿⣿\r\n"
				+ "   ⣿⣿⣿⡇    ⣿⣿⣿     ⣿⣿⣿⡯                      ⣿⣿⣿⣿\r\n"
				+ " ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿  ⣿⣿⣿⡯        ⣿⣿⣿⣿⠀        ⠀⣿⣿⣿⣿\r\n"
				+ "                   ⣿⣿⣿⡯        ⢸⣿⣿⣿\r\n"
				+ "                   ⣿⣿⣿⡯        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "                   ⣿⣿⣿⡯       ⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
				+ "");
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
