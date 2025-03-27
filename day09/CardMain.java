package day09;

public class CardMain {

	public static void main(String[] args) {
		Card c = new Card();
//		c.print();
//		// 숫자의 범위 1~13까지
//		c.setNum(2);
//		
//		c.setShape("♣");
//		c.print();
		
//		for(int j=1; j<=4; j++) {
//			switch(j) {
//			case 1: c.setShape("♥"); break;
//			case 2: c.setShape("◆"); break;
//			case 3: c.setShape("♠"); break;
//			case 4: c.setShape("♣"); break;
//			}
//			
//			for(int i=1; i<=13; i++) {
//				c.setNum(i);
//				c.print();
//			}
//			System.out.println();
//		}
//	
//	}
//
//}

		CardPack cp = new CardPack();
		
		// cardpack 객체 확인
		int cnt = 0;
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=13; j++) {
				cp.getPack()[cnt].print();
				cnt++;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("--------------");
		cp.shuffle();
		cnt = 0;
		for(Card card : cp.getPack()) {
			card.print();
		}
		
		System.out.println("--------------");
		System.out.println("딜러가 카드를 섞고 있습니다. ");
		cp.shuffle();
		cnt = 0;
		for(Card card : cp.getPack()) {
			card.print();
		}
		
		System.out.println("딜러가 카드를 나누고 있습니다.");
		Card player1 = cp.pick();
		Card player2 = cp.pick();
		Card player3 = cp.pick();
		
		System.out.println("-----------------");
		
		System.out.println("player1 card open");
		player1.print();
		System.out.println();
		System.out.println("player2 card open");
		player2.print();
		System.out.println();
		System.out.println("player3 card open");
		player3.print();
						
	}

}
