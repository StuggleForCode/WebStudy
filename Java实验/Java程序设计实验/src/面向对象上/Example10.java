package 面向对象上;

public class Example10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Example10 e = new Example10();
		e.nonStaticMethod1();
	}
	
	public static void staticMethod1() {
		System.out.println("Hello I am staticMethod1");
		//nonStaticMethod1();
	}
	
	public static void staticMethod2() {
		System.out.println("Hello I am staticMethod2");
	}
	
	public void nonStaticMethod1() {
		System.out.println("Hello I am nonstaticMethod1");
		staticMethod1();
		nonStaticMethod2();
		
	}
	
	public void nonStaticMethod2() {
		System.out.println("Hello I am nonstaticMethod2");
	}
}
