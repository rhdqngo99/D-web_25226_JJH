package project2;

public class GamePlayer {
    private String plName; // 플레이어 이름
    private GameScoreboard scoreboardObj; // 점수판 객체

    public GamePlayer(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

    public GameScoreboard getScoreboardObj() {
        return scoreboardObj;
    }

    public void setScoreboardObj(GameScoreboard scoreboardObj) {
        this.scoreboardObj = scoreboardObj;
    }
}