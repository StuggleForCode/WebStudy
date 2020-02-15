package 面向对象上;

public class Student3 {
	
	static public String className;
	private String name;
	
	Student3(String name){
		this.name = name;
	}
	
	public void speak() {
		System.out.println("name = " + name + " className = " + className);
	}
	

}
