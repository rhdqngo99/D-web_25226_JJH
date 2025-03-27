package project1;

// 점수 
public class GameRecrd {
    
    private int recrd;

    public GameRecrd(int recrd) {
        this.recrd = recrd;
    }

    public int getRecrd() {
        return recrd;
    }

    public void setRecrd(int recrd) {
        this.recrd = recrd;
    }

    @Override
    public String toString() {
        return "GameRecrd [recrd=" + recrd + "]";
    }
}