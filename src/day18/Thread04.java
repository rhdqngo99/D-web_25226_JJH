package day18;

class Bank{
	// 계좌
	private int money = 10000;
	
	//입금 : 동기화 (synchronized)
	public synchronized void saveMoney (int money) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.money += money;
	}
	
	//출금 : 동기화 (synchronized)
	public synchronized void minusMoney(int money) {
		int m = this.money;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.money -= money;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}

//홍길동 객체 => 입금
class Hong extends Thread{
	
	@Override
	public void run() {
		System.out.println("홍길동 님이 입금 시작~!!");
		Thread04.myBank.saveMoney(10000);
		System.out.println("saveMoney(10000) > "+ 
				Thread04.myBank.getMoney());
	}
}

//홍길동 와이프 객체 => 출금
class HongWife extends Thread{
	
	@Override
	public void run() {
		System.out.println("홍길동와이프님 출금 시작~!!");
		Thread04.myBank.minusMoney(5000);
		System.out.println("MinusMoney(5000) > "+
				Thread04.myBank.getMoney());
	}
}

public class Thread04 {
	
	//계좌 생성 : 공유영역에 생성
	public static Bank myBank = new Bank();

	public static void main(String[] args) {
		/* critical section(임계영역 : 공유영역) 
		 * 두개 이상의 thread가 동시에 접근할 수 있는 구역 
		 * 동시에 여러개의 thread가 공유영역의 값을 가지려고하면 충돌이 발생할 수 있음. 
		 * 교착상태(deadlock)가 발생
		 * 한 순간에 하나의 thread만 사용가능 : 세마포어(semaphore)
		 * 세마포어를 얻은 스레드만 접근 가능 / 나머지는 대기상태가 됨.
		 * 
		 * 동기화(순서화) : synchronized
		 * 동기화가 필요한 메서드 앞에 키워드로 선언.
		 * */
		
		/* bank 클래스 생성
		 * 계좌 1개 생성 : 급여통장 => 공유영역 (static)
		 * 홍길동 : hong / 홍길동와이프 : hongwife
		 * 잔액 : 10000
		 * */
		
		System.out.println("------------------");
		Hong h = new Hong();
		HongWife hw = new HongWife();
		
		hw.start();
		
		h.start();

	}
}
