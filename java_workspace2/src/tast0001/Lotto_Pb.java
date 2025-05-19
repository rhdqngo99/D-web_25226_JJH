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
        	    {1, 94, 191},
        	    {2, 89, 181},
        	    {3, 94, 190},
        	    {4, 93, 188},
        	    {5, 84, 171},
        	    {6, 94, 190},
        	    {7, 94, 191},
        	    {8, 85, 172},
        	    {9, 74, 150},
        	    {10, 90, 182},
        	    {11, 90, 183},
        	    {12, 98, 199},
        	    {13, 97, 197},
        	    {14, 92, 187},
        	    {15, 90, 182},
        	    {16, 91, 184},
        	    {17, 96, 194},
        	    {18, 92, 187},
        	    {19, 90, 182},
        	    {20, 94, 191},
        	    {21, 90, 183},
        	    {22, 77, 156},
        	    {23, 78, 159},
        	    {24, 92, 187},
        	    {25, 81, 165},
        	    {26, 93, 189},
        	    {27, 98, 198},
        	    {28, 83, 169},
        	    {29, 80, 163},
        	    {30, 89, 180},
        	    {31, 91, 185},
        	    {32, 84, 171},
        	    {33, 97, 197},
        	    {34, 100, 203},
        	    {35, 90, 183},
        	    {36, 88, 179},
        	    {37, 93, 188},
        	    {38, 94, 191},
        	    {39, 91, 184},
        	    {40, 92, 186},
        	    {41, 78, 158},
        	    {42, 85, 172},
        	    {43, 96, 194},
        	    {44, 88, 179},
        	    {45, 92, 186}
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
