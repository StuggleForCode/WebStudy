package 面向的对象下;

public class Example18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int result = div(4, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("程序异常");
		}
		
	}
	
	private static int div(int a, int b) throws Exception {
		return a / b;
	}
}
