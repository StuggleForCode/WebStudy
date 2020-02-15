package javaAPI;

public class Example10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("PI的值：" + Math.PI);
		System.out.println("自然对数的底数： " + Math.E );
		System.out.println("3的绝对值 " + Math.abs(3));
		System.out.println("27的立方根 " + Math.cbrt(27));
		System.out.println("16的平方跟 " + Math.sqrt(16));
		System.out.println("4的平方是 " + Math.pow(4,  2));
		System.out.println("12.345使用ceil方法后的结果是：" + Math.ceil(12.345));
		System.out.println("-12.234使用floor方法后的结果是： " + Math.floor(-12.345));
		for (int i = 0; i < 3; i++) {
			System.out.println(Math.random());
		}
		for (int i = 0; i < 3; i++) {
			System.out.println((int)(Math.random() * 100 + 1));  // 边界值1-100
		}

	}

}
