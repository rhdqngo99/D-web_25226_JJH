package project2;

import java.util.*;
import java.util.stream.Collectors;

public class GameUtils {

    // Aces: 주사위에서 1이 나온 개수만큼 점수 합산
    public static int calculateAces(List<Integer> diceResults) {
        return (int) diceResults.stream().filter(die -> die == 1).count();
    }

    // Deuces: 주사위에서 2가 나온 개수만큼 점수 합산
    public static int calculateDeuces(List<Integer> diceResults) {
        return (int) diceResults.stream().filter(die -> die == 2).count() * 2;
    }

    // Threes: 주사위에서 3이 나온 개수만큼 점수 합산
    public static int calculateThrees(List<Integer> diceResults) {
        return (int) diceResults.stream().filter(die -> die == 3).count() * 3;
    }

    // Fours: 주사위에서 4가 나온 개수만큼 점수 합산
    public static int calculateFours(List<Integer> diceResults) {
        return (int) diceResults.stream().filter(die -> die == 4).count() * 4;
    }

    // Fives: 주사위에서 5가 나온 개수만큼 점수 합산
    public static int calculateFives(List<Integer> diceResults) {
        return (int) diceResults.stream().filter(die -> die == 5).count() * 5;
    }

    // Sixes: 주사위에서 6이 나온 개수만큼 점수 합산
    public static int calculateSixes(List<Integer> diceResults) {
        return (int) diceResults.stream().filter(die -> die == 6).count() * 6;
    }

    // Choice: 주사위 5개의 총합
    public static int calculateChoice(List<Integer> diceResults) {
        return diceResults.stream().mapToInt(Integer::intValue).sum();
    }

    // 4 of a Kind: 동일한 주사위 눈 4개 이상이 있을 경우
    public static int calculate4OfAKind(List<Integer> diceResults) {
        Map<Integer, Long> frequencyMap = diceResults.stream()
                .collect(Collectors.groupingBy(die -> die, Collectors.counting()));
        
        // 4개 이상 동일한 숫자가 있으면 해당 숫자의 총합을 리턴
        for (Map.Entry<Integer, Long> entry : frequencyMap.entrySet()) {
            if (entry.getValue() >= 4) {
                return entry.getKey() * 4;
            }
        }
        return 0;  // 조건에 맞지 않으면 0점
    }

    // Full House: 같은 숫자 3개 + 다른 숫자 2개일 경우
    public static boolean hasFullHouse(List<Integer> diceResults) {
        List<Integer> sorted = new ArrayList<>(diceResults);
        sorted.sort(Integer::compareTo);
        return sorted.get(0) == sorted.get(1) && sorted.get(1) == sorted.get(2) && sorted.get(3) == sorted.get(4);
    }

    // Small Straight: 1, 2, 3, 4 또는 2, 3, 4, 5 또는 3, 4, 5, 6 일 때 15점
    public static boolean hasSmallStraight(List<Integer> diceResults) {
        List<Integer> sorted = new ArrayList<>(diceResults);
        sorted.sort(Integer::compareTo);
        return sorted.containsAll(Arrays.asList(1,2,3,4)) || sorted.containsAll(Arrays.asList(2,3,4,5)) 
                || sorted.containsAll(Arrays.asList(3,4,5,6));
    }

    // Large Straight: 1, 2, 3, 4, 5 또는 2, 3, 4, 5, 6 일 때 30점
    public static boolean hasLargeStraight(List<Integer> diceResults) {
        List<Integer> sorted = new ArrayList<>(diceResults);
        sorted.sort(Integer::compareTo);
        return sorted.containsAll(Arrays.asList(1,2,3,4,5)) || sorted.containsAll(Arrays.asList(2,3,4,5,6));
    }

    // Yacht: 동일한 주사위 눈 5개가 나와야 50점
    public static boolean hasYacht(List<Integer> diceResults) {
        return new HashSet<>(diceResults).size() == 1;
    }
}