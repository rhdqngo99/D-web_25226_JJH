package re01;

public class SingletonMain {

	public static void main(String[] args) {
		// Singleton 객체 생성
		// Singeton s = new Singeton();  // 생성x
		Singeton s = Singeton.getInstance();
		Singeton s2 = Singeton.getInstance();
		System.out.println(s);
		System.out.println(s2);

	}

}