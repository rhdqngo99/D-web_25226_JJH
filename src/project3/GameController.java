package project3;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameController {
	private CardPlayer player;     
    private CardPlayer enemy;      
    private Scanner scanner;   
    ConsoleView c = new ConsoleView();
    // 생성자: 객체 생성
    public GameController() {
        player = new CardPlayer(10);   
        enemy = new CardPlayer(10);   
        scanner = new Scanner(System.in);
    }


	// 게임 시작 메서드
    public void startGame() throws InterruptedException {
        c.start();
        System.out.print("시작하려면 엔터를 누르세요: ");
        scanner.nextLine(); // 아무 키 입력 대기

        for (int turn = 1; turn <= 5; turn++) {
            System.out.println("[턴 " + turn + "]");
            System.out.println();
            System.out.println("플레이어 체력: ♥ " + player.getHp());
            System.out.println("    적 체력: ♥ " + enemy.getHp());
            System.out.println();
            // 카드 드로우
            List<Card> hand = CardInfo.drawTwoRandomCards();
            System.out.println("사용할 카드를 선택하세요");
            for (int i = 0; i < hand.size(); i++) {
                Card c = hand.get(i);
                System.out.println("  ◎________♧");
                System.out.println((i + 1) + ".| " + c.getName()+"" + "");
                System.out.println("  | "+  c.getType() + " " + c.getValue() +"  |");
                System.out.println("  ☆___Δ____』");
                System.out.println();
                System.out.println();
            }

            // 카드 선택
            int choice = 0;
            while (choice < 1 || choice > 2) {
                System.out.print("선택 (1 또는 2): ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    choice = 0;
                }
            }

            // 카드 사용
            Card selected = hand.get(choice - 1);
            selected.apply(player, enemy);

            if (enemy.getHp() <= 0) {
                System.out.println("적이 쓰러졌습니다!");
                System.out.println(" 승리 ");
                restart();
                return;
            }

            // 적 턴
            System.out.println("[적 턴]");
            List<Card> enemyHand = CardInfo.drawTwoRandomCards();
            Card enemyCard = enemyHand.get(new Random().nextInt(2));
            System.out.println("적이 " + enemyCard.getName() + " 사용!");
            enemyCard.apply(enemy, player);

            if (player.getHp() <= 0) {
                System.out.println("플레이어가 쓰러졌습니다...");
                System.out.println(" 패배 ");
                restart();
                return;
            }

            // 턴 마무리 체력 확인
            System.out.println("플레이어 체력: " + player.getHp());
            System.out.println("    적 체력: " + enemy.getHp());
        }

        // ?턴 종료 후 승패 판단
        c.end();
        System.out.println();
        System.out.println("--- 게임 종료 ---");
        if (player.getHp() > enemy.getHp()) System.out.println("☆★☆ 승리 ☆★☆");
        else if (player.getHp() < enemy.getHp()) System.out.println(" 패배 ");
        else System.out.println("무승부!");

        restart(); // 다시 시작할지 묻기
    }

    // 게임 다시 시작 여부
    private void restart() throws InterruptedException {
    	System.out.println();
    	c.con();
        System.out.print("다시 하시겠습니까? (1: 예, 0: 종료): ");
        String restart = scanner.nextLine();
        if (restart.equals("1")) {
            startGame();
        } else {
            System.out.println("게임을 종료합니다.");
        }
    }	
    
    public CardPlayer getPlayer() {
    	return player;
    }
    
    public void setPlayer(CardPlayer player) {
    	this.player = player;
    }
    
    public CardPlayer getEnemy() {
    	return enemy;
    }
    
    public void setEnemy(CardPlayer enemy) {
    	this.enemy = enemy;
    }
}
