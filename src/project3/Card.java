package project3;

public class Card {
		private String name;   
	    private String type;   
	    private int value;     // 카드 효과 수치 (데미지 or 회복량)

	    // 생성자: 카드 이름, 타입, 수치를 설정
	    public Card(String name, String type, int value) {
	        this.name = name;
	        this.type = type;
	        this.value = value;
	    }
	    ConsoleView c = new ConsoleView();
	    // 카드 효과를 실제로 적용하는 메서드
	    // 플레이어가 자신또는 상대방에게 사용함
	    public void apply(CardPlayer me, CardPlayer enemy) throws InterruptedException {
	        if (type.equals("공격")) {
	        	c.attact();
	        	System.out.println(" 공격 실행!");
	            System.out.println(name + " - 공격: 상대에게 " + value + " 데미지!");
	            enemy.takeDamage(value);         // 상대에게 데미지 적용
	        } else if (type.equals("회복")) {
	        	c.heal();
	        	System.out.println(" 회복 실행!");
	            System.out.println(name + " - 회복: 자신의 체력 " + value + " 회복!");
	            me.heal(value);                 // 본인 체력 회복
	        }
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	    
}
