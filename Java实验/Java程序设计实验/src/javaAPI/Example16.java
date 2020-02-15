package javaAPI;

import java.util.Calendar;

public class Example16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar c = Calendar.getInstance();
		int year = 1998;
		c.set(year, 2, 1);
		c.add(Calendar.DATE, -1);
		System.out.println(c.get(Calendar.DATE));		
		
	}

}
