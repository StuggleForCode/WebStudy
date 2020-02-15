package 多线程2;

//两个客户到一个银行去存钱，每个客户一次存100， 存3次
//问题：改程序是否有安全问题， 如果有， 写出分析过程， 并定义解决方案
/**
* 
* @author 27289
*
*/
/*
*发现运行结果
sum = 200
sum = 200
sum = 400
sum = 300
sum = 600
sum = 500

打印错乱， 不关心， 但是发现数值错误， 没有100
运行几次发现有对的。
sum = 100
sum = 100
sum = 200
sum = 400
sum = 300
sum = 500

说明多线程的随机性造成了安全问题的发生

那的问题？
1. 既然时多线程的问题， 必须问题发生在线程任务内。
2.任务代码中是否有共性数据呢？ 有的，   b对象的中的sum
3.是否有对sum进行多次运算呢？有

加同步就搞定了。



*/


class Bank{
	private int sum;
	private Object obj = new Object();
	public void add(int num) {
		synchronized (obj) {
			sum += num;
			System.out.println("sum = "+ Thread.currentThread().getName()+"......" + sum);
		}
	}
}

class Consumer implements Runnable{
	private Bank b = new Bank();
	public void run() {
		
		for (int i = 0; i < 3; i++) {
			b.add(100); //一次存100  循环3次
		}
		
	}
}


public class TreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Consumer c = new Consumer();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();

	}

}
