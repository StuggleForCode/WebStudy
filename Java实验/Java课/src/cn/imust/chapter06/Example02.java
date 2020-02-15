package cn.imust.chapter06;

public class Example02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "abcd";
		
		char[] charArray = str1.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(i != (charArray.length - 1)) {
				System.out.println(charArray[i] + ",");
			}
			else {
				System.out.println(charArray[i]);
			}
		}
		
		System.out.println(String.valueOf(12));
		System.out.println();
		
		System.out.println(str1.length());
		System.out.println(str1.charAt(0));
		System.out.println(str1.indexOf('c'));
		System.out.println(str1.lastIndexOf('c'));

	}

}
