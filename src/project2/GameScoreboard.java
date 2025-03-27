package project2;

import java.util.List;

public class GameScoreboard {
    private int[] scores = new int[12];  // 12개의 점수 항목
    private boolean[] isFilled = new boolean[12];  // 항목이 채워졌는지 확인
    private int grandTotal = 0;  // 총합

    // 점수판을 출력하는 메소드
    public void displayScoreboard() {
        System.out.println("==== 점수판 ====");
        System.out.println("1. Aces");
        System.out.println("2. Deuces");
        System.out.println("3. Threes");
        System.out.println("4. Fours");
        System.out.println("5. Fives");
        System.out.println("6. Sixes");
        System.out.println("7. Choice");
        System.out.println("8. 4 of a Kind");
        System.out.println("9. Full House");
        System.out.println("10. Small Straight");
        System.out.println("11. Large Straight");
        System.out.println("12. Yacht");

        for (int i = 0; i < 12; i++) {
            if (isFilled[i]) {
                System.out.println((i + 1) + ". " + scores[i]);  // 항목에 번호와 점수를 출력
            } else {
                System.out.println((i + 1) + ". 빈 항목");
            }
        }
    }

    // 점수 기록하는 메소드
    public void recordScore(int category, List<Integer> diceResults) {
        if (category < 1 || category > 12 || isFilled[category - 1]) {
            System.out.println("잘못된 항목 선택이거나 이미 채운 항목입니다.");
            return;
        }

        int score = 0;
        switch (category) {
            case 1: // Aces
                score = GameUtils.calculateAces(diceResults);
                break;
            case 2: // Deuces
                score = GameUtils.calculateDeuces(diceResults);
                break;
            case 3: // Threes
                score = GameUtils.calculateThrees(diceResults);
                break;
            case 4: // Fours
                score = GameUtils.calculateFours(diceResults);
                break;
            case 5: // Fives
                score = GameUtils.calculateFives(diceResults);
                break;
            case 6: // Sixes
                score = GameUtils.calculateSixes(diceResults);
                break;
            case 7: // Choice
                score = GameUtils.calculateChoice(diceResults);
                break;
            case 8: // 4 of a Kind
                score = GameUtils.calculate4OfAKind(diceResults);
                break;
            case 9: // Full House
                score = GameUtils.hasFullHouse(diceResults) ? 25 : 0;
                break;
            case 10: // Small Straight
                score = GameUtils.hasSmallStraight(diceResults) ? 15 : 0;
                break;
            case 11: // Large Straight
                score = GameUtils.hasLargeStraight(diceResults) ? 30 : 0;
                break;
            case 12: // Yacht
                score = GameUtils.hasYacht(diceResults) ? 50 : 0;
                break;
        }

        scores[category - 1] = score;
        isFilled[category - 1] = true;
        grandTotal += score;
        System.out.println("점수 " + score + "가 기록되었습니다.");
    }

    // 게임이 완료되었는지 확인하는 메소드
    public boolean isComplete() {
        for (boolean filled : isFilled) {
            if (!filled) return false;
        }
        return true;
    }

    // 총합 반환
    public int getGrandTotal() {
        return grandTotal;
    }

	public int calculateScore(int choice, List<Integer> keptDice) {
		// TODO Auto-generated method stub
		return 0;
	}
}