package 面向对象上;

public class Example12 {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		if (s1 == s2) {
			System.out.println("true");
		}
		else System.out.println("false");
		
	}
}
