package 面向对象上;

public class Example11 {
	
	static {
		System.out.println("静态代码块");
	}
	
	{     //构造代码块， 创建一个对象执行一次， 优于构造函数执行    
		System.out.println("构造代码块");
	}
	
	public Example11() {
		System.out.println("构造方法");
	}
	
	public void localBlock() {
		System.out.println("这是一个方法");
		{
			System.out.println("局部代码块");
		}
	}
	
	
	public static void main(String[] args) {
		Example11 e1 = new Example11();
		Example11 e2 = new Example11();
		
		e1.localBlock();
		e2.localBlock();
		
	}
}
