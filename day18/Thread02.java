package day18;

public class Thread02 {

	public static void main(String[] args) {
		// 2. runnable 구현하는 방법
		/* join() : 동시에 여러개의 스레드가 실행될 때 
		 * 다른 스레드의 결과를 참조하여 실행되어야 할 경우
		 * join() 메서드 호출 
		 * join() : 실행중인 스레드를 강제로 실행대기(lock) 
		 * 상태로 변하게 한 뒤 특정 스레드가 종료될 때까지 기다리게 
		 * 할 수 있음. 
		 * */
		System.out.println(Thread.currentThread().getName());
		System.out.println("main thread start!!");

		MyThread2 th2 = new MyThread2();
		// interface로 구현한 스레드 객체는 Thread 객체가 없어서 
		// 실행이 안됨. 
		// Thread 객체를 구현해서 넣어줘야 함.
		Thread t = new Thread(th2);
		t.start();
		try {
			t.join(); // t의 스레드가 종료될 때까지 기다려.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyThread2 th3 = new MyThread2();
		Thread t1 = new Thread(th3);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main thread end!!"); // 마지막 실행

	}

}

class MyThread2 implements Runnable{

	@Override
	public void run() {
		// run은 반드시 구현해야 함. 
		for(int i=0; i<=500; i++) {
			System.out.println(i+". thread > "+ Thread.currentThread().getName());
		}
		
	}
	
}