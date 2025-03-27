package project4;

public class CafeGuest {
	// 멤버 변수 초기화
	String menuName;
	int fare = 0;
	
	// 기본 생성자 
	public CafeGuest() {};
	
	public CafeGuest(String s, int i) {
		this.menuName = s;
		this.fare = i;
	}


	
	// toString()
	
	// 메서드 
		// 메뉴판ㅇ
	
	// Getter(), Setter()
		// menuName
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

		
		// fare
	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	};
}
