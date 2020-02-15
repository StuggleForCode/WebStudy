package package_API;

import java.awt.List;
import java.util.ArrayList;

/*
 * 数组：存数据
 * 	1.长度是固定的
 * 	2.只能存同一类型的数据
 * 	3.数组是顺序存储
 * 集合：存数据
 * ArrayList  LinkeList    HashSet  LinkedHashSet   TreeSet 	HashMap LinkedHashMap TreeMap
  * 数组			链表	 	     哈希表	   哈希表+链表			二叉树	哈希表	哈希表+链表			二叉树
 * 
 * 
 */

public class API {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world ");
		ArrayList<String> list1 = new ArrayList<String>();
		//元素添加的顺序和数据的顺序一致
		list1.add("马云");
		list1.add("华腾");
		list1.add("雷军");
		list1.add("强东");
		System.out.println(list1);
		list1.remove("强东");
		System.out.println(list1);
//		list1.clear();
//		System.out.println(list1);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
	}

}
