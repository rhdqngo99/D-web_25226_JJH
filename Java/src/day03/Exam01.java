package day03;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* up/down 게임
		 * 
		 * 1~50까지의 랜덤 수 생성하여 맞추는 게임
		 * 컴퓨터가 랜덤 수 생성 : 23
		 * 입력> 10
		 * up!!
		 * 입력> 20
		 * up!!
		 * 입력> 30
		 * down!!
		 * 입력> 23
		 * 정답!!
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.println("up&down 게임");
		int random = (int)(Math.random()*50)+1;
		
		int chance = 5;

		while (true) {
			System.out.println("숫자 입력");
			chance--;
		    int num = scan.nextInt();
		    if(random > num) {
		    	System.out.println("up");
		    }else if(random < num) {
		    	System.out.println("down");
		    }else if(random == num){
		    	System.out.println("정답!"+ chance + "회 남음");
		    	break;
		    }
		    if (chance == 0) {
				System.out.println("실패! 정답은"+ random +"입니다.");
				break;
			}
		    	
		}
		scan.close();

	}

}
