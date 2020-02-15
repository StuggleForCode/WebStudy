package javaAPI;

public class Example01 {
	
	public static void main(String[] agrs) {
		String s1 = new String();
		s1 = "abcde";
		System.out.println("通过String()方法创建的字符串s1:" + s1);
		
		byte[] bys = {97, 98, 99, 100, 101};
		String s2 = new String(bys);
		System.out.println("通过String{byte[] bytes}方法创建的字符串s2:" + s2);
		
		String s3 = new String(bys, 2, 3);
		System.out.println("通过String{byte[] bytes, int index, int length}方法创建的字符串s3:" + s3);
		
		char[] chs = {'a', 'b', 'c', 'd', 'e'};
		String s4 = new String(chs);
		System.out.println("通过String{char[] value}方法创建的字符串s4:" + s4);
		
		String s5 = new String(chs, 1, 3);
		System.out.println("通过String{char[] value, int index, int length} 方法创建的字符串s5:" + s5);
		
		String s6 = new String("abcde");
		System.out.println("通过String(String str)方法创建的字符串s6:" + s6);
		
		String s7 = "abcde";
		System.out.println("直接给字符串对象赋值s7:" + s7);
	}

}
