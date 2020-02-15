package cn.itcast.api.string;

public class StringDemo2 {
	public static void main(String[] args) {
		/**
		 * "abcde"
		 * 
		 * 1.字符串是一个对象， 那么它的方法必然是围绕操作这个对象的数据而定义的
		 * 2.你认为字符串中以后哪些功能呢
		 * 	2.1有多个字符呢？
		 * 	int length()	
		 * 
		 * 	2.2字符的位置
		 *    int indextOf(char, fromIndex)
		 * 
		 *  2.3获取所需位置上的字符
		 *  char charAt(int)
		 *  
		 *  
		 *  2.4获取部分字符串
		 *	String substring(int start, int end); 
		 */
		String str = "abad";
		int len = str.length();
		System.out.println(len);
		
		//-----a字母出现的位置----------
		
		int index = str.indexOf('a');    // 获取字符出现的第一个位置
		System.out.println("index = " + index);
		
		
		//-----第二个a字母出现的位置----------
		int index1 = str.indexOf('a', index + 1);
		System.out.println(index1);
		
		
		int index3 = str.lastIndexOf('a');    // 如果要找的字符不存在 -1
		System.out.println(index3);
		
		
		//-------获取所需位置上的字符----
		String str1 = "itcast";
		char ch = str1.charAt(3);
		System.out.println(ch);
		
		//-------获取部分字符串-----
		String s = str1.substring(2, 4);	//包含头部，不包含尾
		System.out.println(s);
		
	}
}
