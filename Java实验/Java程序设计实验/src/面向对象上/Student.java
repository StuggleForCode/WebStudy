package 面向对象上;

 public class Student {
	private String name;
	private int age;
	public void SetAge(int age) {
		if (age < 0) {
			System.out.println("设置年龄不合法");
		}
		else this.age = age;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public void GetName() {
		System.out.println("Name = " + name);
	}
	
	public void GetAge() {
		System.out.println("Age = " + age);
	}
	
	
	public void Speak() {
		System.out.println("name = " + name +" " +  "age = " + age);
	}
}
