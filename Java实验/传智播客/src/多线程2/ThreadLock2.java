package 多线程2;

//定义一个存储锁的对象
class MyLock1{
	public static final Object LOCKA = new Object();
	public static final Object LOCKB = new Object();
}

class Test1 implements Runnable{
	private boolean flag;
	Test1(boolean flag){
		this.flag = flag;
	}
	
	public void run() {
		if (flag) {
			while(true) {
				synchronized (MyLock.LOCKA) {
					System.out.println(Thread.currentThread().getName() + "....if....A");
					synchronized (MyLock.LOCKB) {
						System.out.println(Thread.currentThread().getName() + ".....if...B");
						
					}
					
				}
			}
		}
		else {
			while(true) {
				synchronized (MyLock.LOCKB) {
					System.out.println(Thread.currentThread().getName() + "....if....B");
					synchronized (MyLock.LOCKA) {
						System.out.println(Thread.currentThread().getName() + ".....if...A");
						
					}
					
				}
			}
		}
	}
	
	
	
}

public class ThreadLock2 {
	public static void main(String[] args) {
		Test1 t1 = new Test1(true);
		Test1 t2 = new Test1(false);
		Thread t11 = new Thread(t1);
		Thread t22 = new Thread(t2);
		t11.start();
		t22.start();
	}

}
