package project1;

import java.util.ArrayList;

public class GamePlayer {
	
	 private String plNum; // 플레이어 넘버 (1p,2p)
	 private String plName; // 플레이어 이름
	 private int score;    // 점수
	 private int scoreboard; // 점수판
	 private ArrayList<GameRecrd> record = new ArrayList<>(); //점수 기록표
	 private int bonus;    // 보너스
	 private int total;    // 총 합계
	
	public GamePlayer() {}

	public GamePlayer(String plNum, String plName, int score, ArrayList<GameRecrd> record, int bonus, int scoreboard, int total) {
       this.plNum = plNum;
       this.plName = plName;
       this.score = score;
       this.scoreboard = scoreboard;
       this.record = record;
       this.bonus = bonus;
       this.total = total;
   }
	

   public String getPlNum() {
       return plNum;
   }

   public void setPlNum(String plNum) {
       this.plNum = plNum;
   }

   public String getPlName() {
       return plName;
   }

   public void setPlName(String plName) {
       this.plName = plName;
   }

   public int getScore() {
       return score;
   }

   public void setScore(int score) {
       this.score = score;
   }

   public ArrayList<GameRecrd> getRecord() {
       return record;
   }

   public void setRecord(ArrayList<GameRecrd> record) {
       this.record = record;
   }

   public int getBonus() {
       return bonus;
   }

   public void setBonus(int bonus) {
       this.bonus = bonus;
   }

   public int getTotal() {
       return total;
   }

   public void setTotal(int total) {
       this.total = total;
   }

   public int getScoreboard() {
       return scoreboard;
   }

   public void setScoreboard(int scoreboard) {
       this.scoreboard = scoreboard;
   }

   @Override
   public String toString() {
       return "GamePlayer [plNum=" + plNum + ", plName=" + plName + ", score=" + score + ", scoreboard=" + scoreboard
               + ", record=" + record + ", bonus=" + bonus + ", total=" + total + "]";
   }
	
}