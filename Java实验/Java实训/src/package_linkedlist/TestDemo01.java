package package_linkedlist;

import java.util.LinkedList;

public class TestDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("马云");
		list.add("雷军");
		list.add("彦宏");
		
		list.addFirst("强东");
		System.out.println(list);
		
		list.addLast("华腾");
		System.out.println(list);

	}

}
