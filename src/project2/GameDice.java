package project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameDice {
    private List<Integer> diceResults = new ArrayList<>();  // 주사위 결과 리스트
    private List<Integer> keptDice = new ArrayList<>();    // 킵한 주사위 리스트

    // 첫 번째 주사위 던지기 (5개의 주사위를 던짐)
    public void rollDice() {
        diceResults.clear();  // 이전 주사위 결과를 비웁니다.
        while (diceResults.size() < 5) {
            diceResults.add((int) (Math.random() * 6) + 1);  // 1부터 6까지의 난수를 생성하여 리스트에 추가
        }
        Collections.sort(diceResults);  // 주사위 결과 정렬
        System.out.println("첫 번째 주사위 굴림 결과: " + diceResults);
    }

    // 두 번째 주사위 던지기 (킵하지 않은 주사위만 던지기)
    public void rollRemainingDice() {
        List<Integer> remainingDice = getRemainingDice();  // 남은 주사위 얻기
        diceResults.clear();  // 남은 주사위만 던짐
        for (int i = 0; i < remainingDice.size(); i++) {
            diceResults.add((int) (Math.random() * 6) + 1);
        }
        Collections.sort(diceResults);  // 주사위 결과 정렬
        System.out.println("두 번째 주사위 굴림 결과: " + diceResults);
    }

    // 주사위 출력
    public void printDice(List<Integer> dice) {
        System.out.println("주사위 결과: " + dice);
    }

    // 킵할 주사위 선택
    public void keepDice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("킵할 주사위를 선택해주세요. (0부터 시작하는 인덱스 번호로 입력, 예: 0 1 2)");
        String[] keepIndices = scan.nextLine().split(" ");
        
        // 선택한 인덱스를 킵한 주사위 리스트에 추가
        for (String idx : keepIndices) {
            int index = Integer.parseInt(idx);
            if (index >= 0 && index < diceResults.size()) {
                keptDice.add(diceResults.get(index));  // 킵할 주사위 저장
            }
        }
    }

    // 킵한 주사위와 던져야 할 주사위들을 반환
    public List<Integer> getKeptDice() {
        return new ArrayList<>(keptDice);  // 킵한 주사위 반환
    }

    // 던져야 할 주사위 반환
    public List<Integer> getRemainingDice() {
        List<Integer> remaining = new ArrayList<>(diceResults);  // 전체 주사위에서 킵한 주사위 빼기
        remaining.removeAll(keptDice);  // 이미 킵한 주사위 제거
        return remaining;  // 남은 주사위 반환
    }

    // 킵한 주사위와 나머지 주사위 출력
    public void printKeptAndRemaining() {
        System.out.println("킵한 주사위: " + keptDice);
        System.out.println("남은 주사위: " + getRemainingDice());
    }

    // 점수 계산 메소드
    public int calculateScore(int choice) {
        int score = 0;
        for (int die : diceResults) {
            if (die == choice) {
                score += die;  // 주사위 값이 choice와 일치하면 점수에 추가
            }
        }
        return score;
    }

	public List<Integer> getDiceResults() {
		return null;
	}
	public List<Integer> setDiceResults() {
		return null;
	}
}