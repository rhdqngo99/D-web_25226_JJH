package tast0001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LottoNum {

    public static int[] generateLottoNumbers() {
        Set<Integer> lottoSet = new HashSet<>();
        while (lottoSet.size() < 6) {
            lottoSet.add((int)(Math.random() * 45) + 1);
        }

        int[] lottoNumbers = new int[6];
        int i = 0;
        for (int num : lottoSet) {
            lottoNumbers[i++] = num;
        }
        Arrays.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static int generateBonus(int[] lottoNumbers) {
        Set<Integer> lottoSet = new HashSet<>();
        for (int num : lottoNumbers) {
            lottoSet.add(num); 
        }

        int bonus;
        do {
            bonus = (int)(Math.random() * 45) + 1;
        } while (lottoSet.contains(bonus));
        return bonus;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("-------▶" + i + "차◀-------");

            int[] lottoNumbers = generateLottoNumbers();
            System.out.println("로또번호: ");
            System.out.println(Arrays.toString(lottoNumbers)); 

            int bonus = generateBonus(lottoNumbers);
            System.out.println("보너스: [" + bonus + "]");  

            System.out.println();
        }
    }
}
