package tast0001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lotto_814M {

	public static void main(String[] args) {
			System.out.println("814만5천60번 회 째 로또번호");
			System.out.println("----------------");

		        Random rand = new Random();
		        
		        ArrayList<Integer> numbers;
		        
		        for (int k = 0; k < 5; k++) {
		            
		            for (int i = 0; i < 8145060; i++) {
		                numbers = new ArrayList<>();
		                
		                for (int j = 1; j <= 45; j++) {
		                    numbers.add(j);
		                }
		                
		                Collections.shuffle(numbers, rand);
		                
		                ArrayList<Integer> selectedNumbers = new ArrayList<>(numbers.subList(0, 6));
		                Collections.sort(selectedNumbers);
		                
		                ArrayList<Integer> remainingNumbers = new ArrayList<>(numbers.subList(6, numbers.size()));
		                int bonusNumber = remainingNumbers.get(rand.nextInt(remainingNumbers.size()));
		                
		                if (i == 8145059) {  
		                    System.out.println("번호 : " + (k + 1)+"번");
		                    System.out.println(selectedNumbers);
		                    System.out.println("보너스 : [" + bonusNumber + "]");
		                }
		            }
		        }

	}

}
