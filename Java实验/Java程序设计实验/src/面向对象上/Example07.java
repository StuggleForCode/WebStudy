package 面向对象上;

public class Example07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student1 stu1 = new Student1();
		Student1 stu2 = new Student1();
		stu1 = null;
		stu2 = null;
		
		System.gc();
	}
}
