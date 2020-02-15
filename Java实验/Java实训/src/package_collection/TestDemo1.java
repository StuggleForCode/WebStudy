package package_collection;

import java.util.ArrayList;

public class TestDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		//ctrl alt + xia  复制
		list.add(new Student("宝强", 36));
		list.add(new Student("柳岩", 33));
		list.add(new Student("冰冰", 42));
		list.add(new Student("云鹏", 35));
		for(int i = 0; i < list.size(); i++) {
			Student stu = list.get(i);
			System.out.println(stu.getName() + " " + stu.getAge());
		}
		
		//3.判断集合中是否有宝强
		boolean bl = list.contains(new Student("宝强", 36));
		System.out.println(bl);
	
	
		
		//4.将集合转为数组
		Object[] array = list.toArray();
		for (int i = 0; i < array.length; i++) {
			Student  stu =  (Student) list.get(i);
			System.out.println(stu.getName() + "--------" + stu.getAge());
			stu.toString();
		}
		
	}

}
