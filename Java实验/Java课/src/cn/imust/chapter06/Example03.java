package cn.imust.chapter06;

public class Example03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "ÓğÃ«Çò-ÀºÇò-Æ¹ÅÒÇò";
		System.out.println(str1.substring(4));
		System.out.println(str1.substring(4, 6));
		String[] strArray = str1.split("-");
		
		
		for (int  i = 0; i < strArray.length; i++) {
			if(i != (strArray.length - 1)) {
				System.out.println(strArray[i] + ",");
			}
			else {
				System.out.println(strArray[i]);
			}
		}
		
		str1 = "asdf";
		//StringBuffer str3 = "sdflj";
		StringBuffer str2 = new StringBuffer();
		System.out.println(str1);
		
	}

}
