package day09;

public class CardPack {
	/* Card 클래스의 객체를 묶은 pack
	 * ♥A~♥K ◆A~◆K ♠A~♠K ♣A~♣K 
	 * - 총 카드수 52장의 한묶음 (배열)
	 * 
	 * 메서드()
	 * - 카드 출력기능 => (Card class print())
	 * - 카드 초기화 기능 => 생성자
	 * - 카드 섞는 기능
	 * - 카드 한장을 빼내는 기능
	 * */
	
	// Card 클래스를 담는 pack 배열 (52장)
	// 자료형 배열명[] = new 자료형[개수];
	private Card pack[] = new Card[52];
	private int cnt; //pack 배열의 index 체크 변수
	
	// 생성자 => 객체를 생성할 때 초기값 셋팅
	public CardPack() {
		//CardPack class의 객체가 생성되면 
		//52장의 Card class 객체가 생성되어야 함.
		/* 숫자 : 1~10, J(11), Q(12), K(13)
		 * 모양 : ♥, ◆, ♠, ♣ */
		String s = "";
		for(int i=1; i<=4; i++) {  // 4가지 모양을 넣기위한 반복문
			switch(i) {
			case 1: s = "♥"; break;
			case 2: s = "◆"; break;
			case 3: s = "♠"; break;
			case 4: s = "♣"; break;
			}
			for(int j=1; j<=13; j++) { // 1~13까지 숫자를 넣기위한 반복문
				//Card class 객체 1개 생성
				Card c = new Card(); // 새카드 1장 생성
				c.setShape(s);
				c.setNum(j);
				pack[cnt] = c;  //pack 배열에 카드 담기
				cnt++;
			}
			
		}
	}
	
	// 카드 섞는 기능
	// 매개변수:X  / 리턴타입:void
	public void shuffle() {
		for(int i=0; i<pack.length; i++) {
			int random = (int)(Math.random()*pack.length);
			Card card = pack[i];
			pack[i] = pack[random];
			pack[random] = card;
		}
	}
	
	// 카드 한장을 빼내는 기능0
	// 리턴타입 : 카드 / 매개변수 : x
	public Card pick() {
		if(cnt == 0) {
			return null;
		}
		cnt--;
		return pack[cnt];
	}
	
	// 카드를 다시 모으는 기능
	public void init() {
		cnt = 52;
	}

	public Card[] getPack() {
		return pack;
	}

	public void setPack(Card[] pack) {
		this.pack = pack;
	}
	
}
