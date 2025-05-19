package re01;

public class Singeton {
	/* 싱글톤(Singleton) : 디자인 패턴 중 생성 패턴의 일종
	 * 단 1개의 객체만 존재하게 하고자 할 때 사용 => 개체 1개로 공유 
	 * */
	
	// 단 1개만 존재해야하는 객체의 인스턴스 생성
	private static Singeton instance;
	
	// 생성자를 통해 객체를 생성하는 것을 막기 위해 기본 생성자를 private으로 생성
	private Singeton() {}
	
	//getter를 통해서만 인스턴스를 얻을 수 있음.
	// 만약 instance가 없으면 생성해서 리턴 
	// 있으면 기존 instance를 리턴
	public static Singeton getInstance() {
		if(instance == null) {
			instance = new Singeton();
		}
		return instance;
	}

} // class
