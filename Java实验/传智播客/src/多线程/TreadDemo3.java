package 多线程;


class Ticket implements Runnable{
	//1.描述票的数量
	private static int tickets = 100;
	
	private Object obj = new Object();
	
	boolean flag = true;
	
	//2.售票的动作， 这个动作需要被多线程执行， 那就是线程任务代码，需要定义run方法中。
	//线程任务中通常都有循环结构
	public void run() {
		if (flag) {
			while(true) {
				synchronized(Ticket.class){
					if (tickets > 0) {
					
						//要让线程在这里稍停，模拟问题的发生 sleep  看到了0 - 1- 2 错误的数据， 这个就是传说中的多线程安全问题。
						try{Thread.sleep(10);}catch(InterruptedException e){/*未写处理异常*/}
					
						System.out.println(Thread.currentThread().getName()+ ".....obj…………" + tickets--);
					}
				}
			}
		}
		else {
			while(true) {
				Ticket.sale();
				}
				
			}
	}
	
	
	public static synchronized void sale() {			//同步函数

		if (tickets > 0) {
			
			//要让线程在这里稍停，模拟问题的发生 sleep  看到了0 - 1- 2 错误的数据， 这个就是传说中的多线程安全问题。
			try{Thread.sleep(10);}catch(InterruptedException e){/*未写处理异常*/}
		
			System.out.println(Thread.currentThread().getName()+ ".....sale…………" + tickets--);
		}
	}
	
}



public class TreadDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.创建Runnable接口的子类对象
		Ticket t = new Ticket();
		
		//2.创建四个线程对象，并将Runnable接口的子类对象作为参数传给Thread的构造函数
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
//		Thread t3 = new Thread(t);
//		Thread t4 = new Thread(t);
		
		
		//3.开启四个线程
		t1.start();
		
		try {Thread.sleep(10);}catch(InterruptedException e) {}
		
		//切换标记之前， 让主线程停一会， 这是就只有一个t1线程子啊去， 他就会执行同步代码块。
		t.flag = false;
		
		
		t2.start();
//		t3.start();
//		t4.start();
		
		
	}

}
