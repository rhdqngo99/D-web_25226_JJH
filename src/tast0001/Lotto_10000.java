package tast0001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lotto_10000 {
	
	public static void main(String[] args) {
		System.out.println("1만 번 돌린 로또번호");
		System.out.println("----------------");
        Random rand = new Random();
        ArrayList<Integer> numbers;
        
        // 5번 반복
        for (int k = 0; k < 5; k++) {
            // 1만번 반복
            for (int i = 0; i < 10001; i++) {
                numbers = new ArrayList<>();
                
                // 1부터 45까지의 숫자 중 6개 랜덤으로 뽑기
                for (int j = 1; j <= 45; j++) {
                    numbers.add(j);
                }
                
                Collections.shuffle(numbers, rand);  // 숫자 섞기
                
                // 뽑은 6개 숫자 출력 (정렬 후)
                ArrayList<Integer> selectedNumbers = new ArrayList<>(numbers.subList(0, 6));
                Collections.sort(selectedNumbers);
                
                // 보너스 번호는 이미 뽑은 번호와 중복되지 않도록 추가
                ArrayList<Integer> remainingNumbers = new ArrayList<>(numbers.subList(6, numbers.size()));
                int bonusNumber = remainingNumbers.get(rand.nextInt(remainingNumbers.size()));
                
                if (i == 10000) {  // 마지막 1만번 반복 후 에서 출력
                    System.out.println("번호 : " + (k + 1)+"번");
                    System.out.println(selectedNumbers);
                    System.out.println("보너스 : [" + bonusNumber + "]");
                }
            }
        }
	
	}
	
}

