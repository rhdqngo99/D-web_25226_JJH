package re01;

//싱글톤 카운트 객체 생성
class Counter{
	
	private int count;
	private static Counter instance;
	
	//생성자 private
	private Counter() {}
	
	public static Counter getInstance() {
		if(instance == null) {
			instance = new Counter();
		}
		return instance;
	}
	
	//countMethod()  // 호출시 count 변수가 1씩 증가
	public int countMethod() {
		count++;
		return count;
	}
} // class

public class SingletonCount {

	public static void main(String[] args) {
		// 싱글톤 카운트 생성
		Counter c1 = Counter.getInstance();
		Counter c2 = Counter.getInstance();
		
		System.out.println(c1.countMethod());
		System.out.println(c2.countMethod());
		System.out.println(c1.countMethod());
		System.out.println(c2.countMethod());
		System.out.println(c1.countMethod());
		System.out.println(c2.countMethod());
		System.out.println(c1.countMethod());
		System.out.println(c2.countMethod());
		
	} // main

} // class
