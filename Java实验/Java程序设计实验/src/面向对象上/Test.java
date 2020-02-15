package 面向对象上;

public class Test {
	private static String name;
	static {
	name = "World";
	System.out.print (name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Hello");
		Test test = new Test();
	}

}
