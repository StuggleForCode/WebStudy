package 多线程2;

//饿汉式	 多线程并发没问题
class Single{
	private static final Single s = new Single();
	
	private Single() {}
	
	public static Single getInstance() {
		return s;
	}
}


//懒汉式
class Single1{
	private static Single1 s = null;
	
	private Single1() {}
	/*
	 * 并发访问会有安全隐患 ， 所以加入同步机制解决俺安全问题
	 * 但是，同步的出现降低效率
	 * 可以通过双重判断的方式，解决效率问题， 减少判断锁的次
	 */
	private static Single1 getInstance() {
		if (s == null) {
			synchronized (Single1.class) {
				if (s == null) {
					s = new Single1();
				}
			}
		}
		return s;
	}
}

class Demo implements Runnable{
	public void run() {
		
	}
}

public class ThreadDemo6 {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

}
