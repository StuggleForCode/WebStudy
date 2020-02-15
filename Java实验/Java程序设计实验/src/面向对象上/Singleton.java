package 面向对象上;

public class Singleton {
	static Singleton s = new Singleton();
	
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return s;
	}
	
}
