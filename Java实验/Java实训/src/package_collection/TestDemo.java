package package_collection;

import java.util.ArrayList;

/*
 * 求两个集合的并集、交集、差集
 */

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1：第一个集合
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("貂蝉");
		list1.add("贵妃");
		list1.add("玉环");
		list1.add("昭君");
		
		//2:第二个集合
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("韩雪");
		list2.add("景甜");
		list2.add("玉环");
		list2.add("昭君");
		
		//3：求两个集合的并集
		//list1.addAll(list2);//list1 中存储了源list1,list2的数据合集
		//System.out.println(list1);
		
		//4:求两个集合的交集
//		list1.retainAll(list2);
//		System.out.println(list1);
		
		//5.求两个集合的差集
		list1.removeAll(list2);
		System.out.println(list1);
		
		
	}

}
