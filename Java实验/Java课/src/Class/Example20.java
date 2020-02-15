package Class;

public class Example20 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		try {
//			int result = divide(4,0);
//		}catch(Exception e) {
//			System.out.println("程序的异常信息： " + e.getMessage());
//			System.exit(0);    // 有他 finally 中的内容不执行
//			return;
//		}finally {
//			System.out.println("Hello world");
//		}
//		System.out.println("程序继续执行");
		
		
		try {
			int result = divide(4, 0);
		} catch (DivideByMinusException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

//	private static int divide(int x, int y) throws Exception {	//  throws 该方法可能有错误， 
//		return x /y;											//必须修改， 如果不修改编译不会通过
//	}
	
	private static int divide (int x, int y) throws DivideByMinusException{
		if(y <= 0) {
			throw new DivideByMinusException("除数为负数");   // throw关键字用于在方法中声明抛出异常的实例对象
		}
		return x / y;
	}

}


class DivideByMinusException extends Exception{

	public DivideByMinusException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DivideByMinusException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}

