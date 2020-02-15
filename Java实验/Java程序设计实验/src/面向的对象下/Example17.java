package 面向的对象下;

public class Example17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a = 10 / 0;
			System.out.println("程序继续");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("出异常类");
		}finally {
			System.out.println("释放资源");
		}
	}

}
