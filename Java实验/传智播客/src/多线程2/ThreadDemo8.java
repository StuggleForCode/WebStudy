
package 多线程2;


/*
 * 问题1.
 * 运行结果：数据错误， 已经被生产很早期的商品， 才被消费到
 * 出现了线程俺安全问题， 加同步解决， 使用同步函数
 * 问题已解决， 不会在消费到之前很早期的商品
 * 
 * 问题2
 * 发现了连续生产却没有消费， 同时对同一个商品进行多次消费
 * 希望的结果应该是生产一个商品， 就别消费掉
 * 
 * 搞清楚几个问题？
 * 生产者什么时候生产？ 消费者什么时候消费？
 * 当盘子里没有面包时， 就生产， 如果有了面包， 就不生产
 * 当盘子里有面包时， 就消费， 如果没有面包， 就不消费
 * 
 * 
 * 生产者生产了商品后因该告诉消费者来消费， 这是的生产者应处于等待状态
 * 消费者消费了商品后， 应告诉生产者， 这是消费者处于等待状态
 * 
 * 等待： wait()
 * 告诉 : notify();//唤醒
 * 
 * 问题解决， 实现了生产一个消费一个
 * 
 * 
 * 
 */

//描述资源。属性：商品名称和编号， 行为：对商品名称赋值，获取商品
class Resource {
	private String name;
	private int count = 1;
	
	//定义标记
	private boolean flag = false;
	
	//1.提供设置方法
	public synchronized  void set(String name){
		if (flag)
			try {wait();}catch(InterruptedException e) {}
		
		//给成员变量赋值并加上编号
		this.name = name + count;
		
		//打印生产那个商品
		System.out.println(Thread.currentThread().getName() + ".....生产者...." + this.name);
		
		//编号自增
		count++;
		
		flag = true;
		notify();
	}
	public synchronized void out() {
		if (!flag)
			try {wait();}catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + ".....消费者...." + this.name);
		
		//将标记改为false
		flag = false;
		notify();
	}

}

class Producer implements Runnable{
	private Resource r = new Resource();
	Producer(Resource r){
		this.r = r;
	}
	public void run() {
		while(true) {
			r.set("面包");
		}
	}
}


class CONSUMER implements Runnable{
	Resource r = new Resource();
	CONSUMER(Resource r){
		this.r = r;
	}
	public void run() {
		while (true) {
			r.out();
		}
	}
}

public class ThreadDemo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Resource r = new Resource();
		
		Producer pro = new Producer(r);
		CONSUMER con = new CONSUMER(r);
		
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		t1.start();
		t2.start();
	}

}
