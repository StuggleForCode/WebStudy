package cn.imust.chapter06;

import java.util.Enumeration;
import java.util.Properties;

public class Example09 {
	public static void main(String[] args) {
		Properties properties = System.getProperties();
		Enumeration propertyName = properties.propertyNames();
		while(propertyName.hasMoreElements()) {
			String key = (String)propertyName.nextElement();
			String value = System.getProperty(key);
			System.out.println(key + "---->" + value);
		}
		
	}
}
