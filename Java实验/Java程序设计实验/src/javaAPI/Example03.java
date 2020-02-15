package javaAPI;

public class Example03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "HelloWorld";
		//获取长度
		System.out.println(s.length());
		//获取第三个字符
		System.out.println(s.charAt(3));
		//获取第一次出现‘I'的下标
		System.out.println(s.indexOf('I'));
		//从字符串s第五个字符开始，出现字符'I'的索引
		System.out.println(s.indexOf('l', 4));
		//字符串s中第5个字符到结尾组成的新字符串
		System.out.println(s.substring(4));
		//字符串s中第5个到第9个字符组成的新串是
		System.out.println(s.substring(4, 8));	
	}

}
