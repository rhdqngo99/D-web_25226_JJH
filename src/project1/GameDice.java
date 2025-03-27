package project1;

import java.util.Random;
import java.util.Scanner;

public class GameDice {

	   private int[] dice;
	    private Random rand;
	    private Scanner scan;

	    public GameDice() {
	        this.dice = new int[5]; // 5개의 주사위
	        this.rand = new Random();
	        this.scan = new Scanner(System.in);
	    }

	    // 주사위를 던지기
	    public void rollDice() {
	        for (int i = 0; i < dice.length; i++) {
	            dice[i] = rand.nextInt(6) + 1;
	        }
	    }

	    // 주사위 결과 출력
	    public void printDice() {
	        System.out.print("주사위 결과: ");
	        for (int die : dice) {
	            System.out.print(die + " ");
	        }
	        System.out.println();
	    }

	    // 킵할 주사위 선택
	    public void keepDice() {
	        System.out.println("현재 주사위: ");
	        printDice();
	        System.out.println("어떤 주사위를 킵 할건가요? (0부터 시작하는 인덱스 번호로 입력, 예: 1 2 3)");
	        String input = scan.nextLine();
	        String[] indexes = input.split(" ");

	        boolean[] keep = new boolean[dice.length];
	        for (String index : indexes) {
	            int idx = Integer.parseInt(index);
	            if (idx >= 0 && idx < dice.length) {
	                keep[idx] = true;
	            }
	        }

	        // 킵한 주사위 제외하고 나머지 주사위는 던지기
	        for (int i = 0; i < dice.length; i++) {
	            if (!keep[i]) {
	                dice[i] = rand.nextInt(6) + 1;
	            }
	        }
	    }

	    public int[] getDice() {
	        return dice;
	    }
	}
