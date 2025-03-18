package tast0001;
import java.util.*;

public class Lotto_Pb {

    // 각 로또 번호의 당첨 횟수와 확률 데이터를 저장할 Map
    static Map<Integer, Integer> lottoNumbers = new HashMap<>();
    static Map<Integer, Double> lottoProbabilities = new HashMap<>();
    static int totalDraws = 45; // 총 45개의 번호

    public static void updateLottoData() {
        // 최신 데이터 (번호 | 확률(%) | 당첨횟수)
        int[][] data = {
        		{1, 95, 191},
        		{2, 90, 181},
        		{3, 93, 188},
        		{4, 93, 188},
        		{5, 84, 170},
        		{6, 93, 188},
        		{7, 94, 189},
        		{8, 85, 171},
        		{9, 74, 149},
        		{10, 90, 182},
        		{11, 90, 182},
        		{12, 98, 197},
        		{13, 97, 196},
        		{14, 92, 186},
        		{15, 90, 182},
        		{16, 91, 183},
        		{17, 95, 191},
        		{18, 92, 186},
        		{19, 90, 181},
        		{20, 94, 190},
        		{21, 90, 182},
        		{22, 77, 155},
        		{23, 77, 156},
        		{24, 91, 184},
        		{25, 80, 162},
        		{26, 93, 188},
        		{27, 97, 196},
        		{28, 83, 168},
        		{29, 79, 160},
        		{30, 89, 179},
        		{31, 91, 184},
        		{32, 85, 171},
        		{33, 97, 196},
        		{34, 100, 202},
        		{35, 90, 182},
        		{36, 89, 179},
        		{37, 93, 187},
        		{38, 93, 188},
        		{39, 90, 181},
        		{40, 92, 185},
        		{41, 78, 158},
        		{42, 84, 169},
        		{43, 96, 194},
        		{44, 89, 179},
        		{45, 92, 185}
        };

        // 데이터를 갱신
        for (int[] entry : data) {
            int number = entry[0];
            int probability = entry[1];
            int count = entry[2];

            lottoNumbers.put(number, count); // 번호 당첨 횟수 업데이트
            lottoProbabilities.put(number, (double) probability); // 번호 확률 업데이트
        }
    }

    // 실시간 확률 계산 (당첨 횟수 기준)
    public static double getProbability(int number) {
        // 확률 = 해당 번호의 당첨 횟수 / 전체 회차 수
        return lottoProbabilities.getOrDefault(number, 0.0);
    }

    // 번호별 확률 출력
    public static void printProbabilities() {
        System.out.println("번호 | 당첨 횟수 | 확률(%)");
        System.out.println("------------------------");

        for (Map.Entry<Integer, Integer> entry : lottoNumbers.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();
            double probability = lottoProbabilities.getOrDefault(number, 0.0);
            System.out.printf("%2d  |   %3d   |  %.2f%%\n", number, count, probability);
        }
    }

    public static void main(String[] args) {
        // 최신 데이터 갱신
        updateLottoData();

        // 실시간 확률 출력
        printProbabilities();
    }
}
