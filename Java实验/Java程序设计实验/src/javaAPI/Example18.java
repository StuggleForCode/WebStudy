package javaAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Example18 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		
		System.out.println("按照自定义的字符串形式格式化当前日期");
		
		String str = sdf.format(d);
		System.out.println("将" + d + "转换成年月日时分秒的形式");
		System.out.println(str);
		System.out.println("-------------------");
		
		String s = "2016-12-12 23:12:34";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
		System.out.println("按照自定义的字符串的格式将s解析成Date形式");

		Date dd = sdf2.parse(s);
		System.out.println("将字符串" + s + "解析成Date形式");
		System.out.println(dd);
	}
}
