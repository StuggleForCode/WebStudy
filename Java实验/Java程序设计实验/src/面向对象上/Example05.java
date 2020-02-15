package 面向对象上;

public class Example05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student1 Stu1 = new Student1("zhangsan");
		Student1 Stu2 = new Student1("lisi", 19);
		Student1 Stu3 = new Student1();
		
		Stu1.printAge();
		Stu2.printAge();
		Stu3.printAge();
		

	}

}