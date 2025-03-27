package project1;

import java.util.Scanner;

// controller 개념
public class GameConsole {
	
	public void Console(){
		
		Scanner scan = new Scanner(System.in);
		
		// 유저 설정
		System.out.println("플레이어1의 이름을 설정 해주세요.");
		GamePlayer pl1 = new GamePlayer();
		pl1.setPlName(scan.next());
		System.out.println("플레이어2의 이름을 설정 해주세요.");
		GamePlayer pl2 = new GamePlayer();
		pl2.setPlName(scan.next());
		
		System.out.println("플레이어1 이름: " + pl1.getPlName());
		System.out.println("플레이어2 이름: " + pl2.getPlName());
		
		// 점수판 초기화
		GameScoreboard scoreboard1 = new GameScoreboard();
		GameScoreboard scoreboard2 = new GameScoreboard();
		
        // 게임 진행
        while (!isGameOver(scoreboard1, scoreboard2)) {
            playRound(pl1, pl2, scoreboard1, scoreboard2, scan);
        }
        
        // 게임 종료 후 결과 출력
        printFinalResult(pl1, pl2, scoreboard1, scoreboard2);
        
        // 플레이어1 주사위 던지기
        GameDice gameDice1 = new GameDice();
        System.out.println(pl1.getPlName() + "의 주사위 던지기:");

        for (int i = 0; i < 3; i++) {
            System.out.println("주사위 던지기 " + (i + 1) + "번째");
            gameDice1.rollDice();
            gameDice1.printDice();
            if (i < 2) { // 마지막 던지기 전까지
                gameDice1.keepDice();
            }
        }

        System.out.println(pl1.getPlName() + "의 최종 주사위 결과:");
        gameDice1.printDice();

        // 플레이어2 주사위 던지기
        GameDice gameDice2 = new GameDice();
        System.out.println(pl2.getPlName() + "의 주사위 던지기:");

        for (int i = 0; i < 3; i++) {
            System.out.println("주사위 던지기 " + (i + 1) + "번째");
            gameDice2.rollDice();
            gameDice2.printDice();
            if (i < 2) { // 마지막 던지기 전까지
                gameDice2.keepDice();
            }
        }

        System.out.println(pl2.getPlName() + "의 최종 주사위 결과:");
        gameDice2.printDice();
	
	}
    // 게임이 끝났는지 확인
    public boolean isGameOver(GameScoreboard scoreboard1, GameScoreboard scoreboard2) {
        return scoreboard1.isComplete() && scoreboard2.isComplete();
    }
    
    public void playRound(GamePlayer pl1, GamePlayer pl2, GameScoreboard scoreboard1, GameScoreboard scoreboard2, Scanner scan) {
        // 주사위 굴리기
        GameDice gameDice = new GameDice();
        gameDice.rollDice();
        gameDice.printDice();
        
        // 플레이어 1의 점수 선택
        System.out.println(pl1.getPlName() + "님, 점수를 기록해주세요.");
        scoreboard1.displayScoreboard();
        selectScoreCategory(scoreboard1, scan);

        // 플레이어 2의 점수 선택
        System.out.println(pl2.getPlName() + "님, 점수를 기록해주세요.");
        scoreboard2.displayScoreboard();
        selectScoreCategory(scoreboard2, scan);
    }
    

    // 점수 항목 선택
    public void selectScoreCategory(GameScoreboard scoreboard, Scanner scan) {
        System.out.println("점수를 선택할 항목의 번호를 입력해주세요.");
        int choice = scan.nextInt();
        String category = scoreboard.getCategoryFromChoice(choice);
        if (!category.isEmpty()) {
            int score = scoreboard.calculateScore(category, new GameDice().getDice());
            scoreboard.recordScore(category, score);
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }

    // 게임 종료 후 결과 출력
    public void printFinalResult(GamePlayer pl1, GamePlayer pl2, GameScoreboard scoreboard1, GameScoreboard scoreboard2) {
        System.out.println("==== 게임 종료 ====");
        System.out.println(pl1.getPlName() + "총합: " + scoreboard1.getGrandTotal());
        System.out.println(pl2.getPlName() + "총합: " + scoreboard2.getGrandTotal());

        if (scoreboard1.getGrandTotal() > scoreboard2.getGrandTotal()) {
            System.out.println(pl1.getPlName() + "님이 승리!");
        } else if (scoreboard1.getGrandTotal() < scoreboard2.getGrandTotal()) {
            System.out.println(pl2.getPlName() + "님이 승리!");
        } else {
            System.out.println("비겼습니다!");
        }
    }
}