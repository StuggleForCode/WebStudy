package 面向对象上;

public class Student1 {
	private int age;
	private String name;
	Student1(String name){
		this.name = name;
	}
	
	Student1(){}
	
	Student1(String name, int age){
		this(name);
		this.age = age;
	}
	
	public void printAge() {
		System.out.println("name = " + name + "  age = " + age);
	}
	
	public void finalize() {
		System.out.println("垃圾回收");
	}
	
}
