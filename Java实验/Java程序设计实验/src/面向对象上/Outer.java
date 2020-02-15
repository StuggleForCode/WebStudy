package 面向对象上;

public class Outer {
	
	static class Inner{
		static String staticField = "静态内部类的静态变量";
		public String nonStaticField = "静态内部类中的非静态变量";
		public static void staticMethod() {
			System.out.println("静态内部类的静态方法");
		}
		
		public void nonStaticMethod() {
			System.out.println("静态内部类的非静态方法");
		}

	}
}
