package project3;

public class CardPlayer {
		
		private int hp;  // 체력 변수 (기본값 10)

	    
	    public CardPlayer() {}

	    public CardPlayer(int hp) {
	    	
	    	this.hp = hp;
	    }
	    // 데미지를 받아 체력을 감소시키는 메서드
	    public void takeDamage(int dmg) {
	        hp -= dmg;
	        if (hp < 0) hp = 0;  // 체력은 0 밑으로 떨어지지 않도록 함
	    }

	    // 체력을 회복시키는 메서드
	    public void heal(int amount) {
	        hp += amount;
	        if (hp > 10) hp = 10;  // 체력은 최대 10까지만 회복됨
	    }

		public int getHp() {
			return hp;
		}

		public void setHp(int hp) {
			this.hp = hp;
		}


	    
}
