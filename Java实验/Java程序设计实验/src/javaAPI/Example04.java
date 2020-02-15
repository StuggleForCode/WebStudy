package javaAPI;

public class Example04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "HelloWorld";
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			System.out.print(chs[i] + " ");
		}
		
		char[] chs2 = {'a', 'b', 'c', '中', '国'};
		//通过String类的copyValueof()方法将字符数组chs2转成字符串
		System.out.println(String.copyValueOf(chs2));
		//通过String类的valueOf()方法将字符数组chs2转换成字符串
		System.out.println(String.valueOf(chs2));
		
		
		//通过String类的valueOf()方法将int 类型100转换成字符串
		int i = 100;
		System.out.println(String.valueOf(i));
		
		System.out.println(s.toLowerCase());
		System.out.println(s.toUpperCase());
		
		//字符串s拼接‘world'后， 生成的新字符串
		System.out.println(s.concat("world"));
	}
}
