package cn.imust.chapter06;

public class Example01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc";
		String str2 = new String();
		String str3 = new String("abcd");
		char[] charArray = new char[] {'D', 'E', 'F'};
		String str4 = new String(charArray);
		System.out.println(str1);
		System.out.println("a" + str2 + "b");
		System.out.println(str3);
		System.out.println(str4);
	}

}
