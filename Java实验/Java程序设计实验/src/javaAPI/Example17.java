package javaAPI;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Example17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String date1 = "2014-5-31";
		
		DateFormat df1 = DateFormat.getDateInstance();
		
		Date d1 = null;
		try {
			d1 = df1.parse(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("将‘" + date1 + "’转换成Date类型的结果是： ");
		System.out.println(d1);
		
		//通过DateFormat的静态方法getDateTimeInstance()方法获取DateFormat实例对象
		DateFormat  df2 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		Date d2 = new  Date();
		
		//将Date类型转换成字符串形式
		String s = df2.format(d2);
		System.out.println("将‘" + d2 + "’转换成年月日时分秒的形式是：");
		System.out.println(s);
	}

}
