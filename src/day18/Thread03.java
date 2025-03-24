package day18;

public class Thread03 {

	public static void main(String[] args) {
		/* 1~50까지, 51~100까지의 합을 구하는 두개의 Thread를 생성
		 * 
		 * 두개의 Thread가 실행되고 난 뒤
		 * Thread-0 1~50까지의 출력 후 합계 출력
		 * Thread-1 51~100까지의 출력 후 합계 출력
		 * 
		 * main  Thread-0 + Thread-1 합을 출력
		 * 
		 * Thread.sleep() : 기다렸다가 실행
		 * millisecond 단위 1초 = 1000
		 * */
		JoinTest jt1 = new JoinTest(1, 50);
		JoinTest jt2 = new JoinTest(51, 100);
		
		jt1.start();
		
		try {
			jt1.join();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread 1 total > "+ jt1.getTotal());
		
		jt2.start();
		
		try {
			jt2.join();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread 2 total > "+ jt2.getTotal());
		
		System.out.println();
		System.out.println("last total > "+(jt1.getTotal() + jt2.getTotal()));

	}

}

class JoinTest extends Thread{
	private int start;  //시작값
	private int end;  //끝값
	private int total;
	
	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			System.out.println(i+". thread");
			this.total += i;
		}
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}