package project5;

import java.util.ArrayList;

public class DiceGamePlayer {

  private String plName; // 플레이어 이름
  private int plscore;     // 점수
  
  // 기본 생성자 (1)
  public DiceGamePlayer() {}
  
  // 기본 생성자 (2) 
  public DiceGamePlayer(String name) { this.plName = name;}
  
  // toString()
  @Override
	public String toString() {
		return "플레이어 이름 : " + plName + ", 플레이어 점수 : " + plscore;
	}

  // Getter(), Setter()
  public String getPlName() {
      return plName;
  }

	public void setPlName(String plName) {
      this.plName = plName;
  }

	int getPlscore() {
		return plscore;
	}

	void setPlscore(int plscore) {
		this.plscore = plscore;
	}
}