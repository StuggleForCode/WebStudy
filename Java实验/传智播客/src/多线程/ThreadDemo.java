package 多线程;


/*
 通过代码来演示之前和之后的区别
 在之前的代码中， jvm 启动后，必然有个执行路径（线程）从main方法开始的。 一直执行到main方法结束
 这个线程在java中称为主线程。
 
 当主线程在这个程序执行时 ， 如果遇到了循环而导致在指定的位置停留时间过长， 
 无法执行下面的程序。
 可不可以实现一个主线程负责执行其中一个循环， 由另一个线程负责其他代码的执行。
 实现多部分代码的同时执行.
 这就是多线程技术可以解决的问题.

该如何创建线程呢?

通过API中的英文Thread的搜索,  查到Thread类
通过阅读Thread类中的描述,
1.继承Thread类
	1.1定义一个类的继承Thread
	1.2重写run方法
	1.3创建子类对象,就是创建线程对象
	1.4调用start方法, 开启线程并让线程执行, 同时还会告诉jvm去调用run方法
	

为什么要这样做?
继承Thread类: 因为Thread类描述线程事物,具备线程应该有的功能.
那为什么不直接创建Thread类的对象呢?
Thread t1 = new Thread();
t1.start();  // 这么做没有错, 但是改start调用的时Thread类中的run方法.
而这个run方法没有做什么事情, 更重要的事这个run方法中并没有定义我们需要让线程执行的代码

创建线程的目的是什么?  是为了建立单独的执行路径, 让多部分代码实现同时执行.
也就是说线程创建并执行需要给定的代码(线程的任务)
对于之前所讲的主线程,  它的任务定义在mian函数中.
自定义线程需要执行的任务都定义在run方法中.
Thread类中的run方法内部的任务并不是我们所需要的, 只要重写这个run方法,
既然Thread类已经定义了线程任务的位置, 只要在位置中定义任务代码即可.
所以进行了重新run方法动作.


 */


class Demo extends Thread{
	private String name;
	Demo(String name){
		this.name = name;
	}
	public void run() {
		int[] arr = new int [3];
		System.out.println(arr[4]);
		
		for (int i = 0; i < 20; i++) {
			System.out.println("name" + name + "......." + Thread.currentThread().getName()+ "     " + i);
		}
		
	}
}




public class ThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello wrold");
		
		//创建了两个线程.
		Demo d1 = new Demo("小强");
		Demo d2 = new Demo("旺财");
		d2.start(); // 讲d2这个线程执行
		d1.run(); //由主线程负责
		
		
		/*
		 线程对象调用run方法和调用start方法区别?
		 调用run方法不开启线程. 仅是对象调用方法
		 调用start开启线程, 并让jvm调用run方法在开启的线程中执行,
		 */
		
	}

}
