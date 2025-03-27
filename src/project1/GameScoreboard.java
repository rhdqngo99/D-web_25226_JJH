package project1;

import java.util.HashMap;
import java.util.Map;

// 점수 기록 판
public class GameScoreboard {
    private Map<String, Integer> upperSection;
    private Map<String, Integer> lowerSection;
    private int upperSectionTotal;
    private int lowerSectionTotal;
    private int bonus;
    private int grandTotal;

    public GameScoreboard() {
        upperSection = new HashMap<>();
        lowerSection = new HashMap<>();
        upperSectionTotal = 0;
        lowerSectionTotal = 0;
        bonus = 0;
        grandTotal = 0;

        for (int i = 1; i <= 6; i++) {
            upperSection.put(String.valueOf(i), -1);
        }
        
        // 특수 추가 점수 판
        lowerSection.put("Choice", -1);
        lowerSection.put("4 of a Kind", -1);
        lowerSection.put("Full House", -1);
        lowerSection.put("Small Straight", -1);
        lowerSection.put("Large Straight", -1);
        lowerSection.put("Yahtzee", -1);
    }

    public void recordScore(String category, int score) {
        if (upperSection.containsKey(category) && upperSection.get(category) == -1) {
            upperSection.put(category, score);
            upperSectionTotal += score;
        } else if (lowerSection.containsKey(category) && lowerSection.get(category) == -1) {
            lowerSection.put(category, score);
            lowerSectionTotal += score;
        }
        calculateBonus();
        calculateGrandTotal();
    }
    
    // 초이스
    public int calculateScore(String category, int[] diceResults) {
        int score = 0;
        switch (category) {
            case "Choice":
                for (int die : diceResults) {
                    score += die;
                }
                break;
            default:
                int num = Integer.parseInt(category);
                for (int die : diceResults) {
                    if (die == num) {
                        score += die;
                    }
                }
                break;
        }
        return score;
    }

    public void calculateBonus() {
        if (upperSectionTotal >= 63) {
            bonus = 35;
        }
    }

    public void calculateGrandTotal() {
        grandTotal = upperSectionTotal + lowerSectionTotal + bonus;
    }

    public int getGrandTotal() {
        return grandTotal;
    }
    
    //점수판 상위, 하위 보너스 합계
    public void displayScoreboard() {
        System.out.println("==== 점수판 ====");
        System.out.println("상위 항목:");
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + ": " + (upperSection.get(String.valueOf(i)) == -1 ? "-" : upperSection.get(String.valueOf(i))));
        }

        System.out.println("\n하위 항목:");
        for (String category : lowerSection.keySet()) {
            System.out.println(category + ": " + (lowerSection.get(category) == -1 ? "-" : lowerSection.get(category)));
        }

        System.out.println("\n상위 항목 합계: " + upperSectionTotal);
        System.out.println("하위 항목 합계: " + lowerSectionTotal);
        System.out.println("보너스: " + bonus);
        System.out.println("총 합계: " + grandTotal);
    }

    public boolean isComplete() {
        return !upperSection.containsValue(-1) && !lowerSection.containsValue(-1);
    }
    
    
    
    // 특수룰 구현 번호 6 ~ 12
    public String getCategoryFromChoice(int choice) {
        if (choice >= 1 && choice <= 6) {
            return String.valueOf(choice);
        } else if (choice == 7) {
            return "초이스";
        } else if (choice == 8) {
            return "4 of a Kind";
        } else if (choice == 9) {
            return "풀하우스";
        } else if (choice == 10) {
            return "S스트레이트";
        } else if (choice == 11) {
            return "L스트레이트";
        } else if (choice == 12) {
            return "야추";
        }
        return "";
    }
}
