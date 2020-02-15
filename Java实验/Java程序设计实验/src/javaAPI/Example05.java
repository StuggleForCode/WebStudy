package javaAPI;

public class Example05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hellowrld";
		
		System.out.println(s.replace('l', 'p'));
		System.out.println(s.replace("ll", "ak47"));
		String ages = "20-30";
		String[] s1 = ages.split("-");
		for (int i = 0; i < s1.length; i++) {
			System.out.println(s1[i]);
		}
		
		//去掉首尾空格后的字符串
		String name = "  admin hello      ";
		System.out.println(name.trim());
		
		String s2 = "hello";
		String s3 = "aello";
		//按字典的顺序比较字符串
		System.out.println(s2.compareTo(s3));
	}

}
