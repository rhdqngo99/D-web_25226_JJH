package sale2;

public class Order {
	private int opp;
    private int tP;
    
    public Order(String name, int price, int opp) {
        super();
        this.opp = opp;
        this.tP = price * opp;
    }

	public int getOpp() {
		return opp;
	}

	public void setOpp(int opp) {
		this.opp = opp;
	}

	public int gettP() {
		return tP;
	}

	public void settP(int tP) {
		this.tP = tP;
	}

	@Override
	public String toString() {
		return getName() + " x " + opp + " = " + tP + "원";
	}

	private String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
