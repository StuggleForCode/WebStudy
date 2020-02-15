package ∂‡œﬂ≥Ã2;


class Test implements Runnable{
	private boolean flag;
	Test(boolean flag){
		this.flag = flag;
	}
	
	public void run() {
		if(flag) {
			while(true) {
				synchronized (MyLock.LOCKA) {
					System.out.println(Thread.currentThread().getName() + ".... if....A");
					synchronized (MyLock.LOCKB) {
						System.out.println(Thread.currentThread().getName() + ".... if....B");
					}
				}
			}
		}
		else {
			while(true) {
				synchronized (MyLock.LOCKB) {
					System.out.println(Thread.currentThread().getName() + ".... if....B");
					synchronized (MyLock.LOCKA) {
						System.out.println(Thread.currentThread().getName() + ".... if....A");
					}
					
				}
			}
		}
	}
	
}


class MyLock{
	public static final Object LOCKA = new Object();
	public static final Object LOCKB = new Object();
}

public class ThreadLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t1 = new Test(true);
		Test t2 = new Test(false);
		
		Thread t11 = new Thread(t1);
		Thread t22 = new Thread(t2);
		t11.start();
		t22.start();
		

	}

}
