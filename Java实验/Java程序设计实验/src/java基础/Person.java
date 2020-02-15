package java»ù´¡;

public class Person {
	String name = "xiao·¼";
	public Person(String name) {
		name = "xiaoÀ¼";
	}
	public void show() {
		this.name = "xiao´ä";
	}
	public static void main(String[] args) {
		Person p = new Person("xiao·ï");
		System.out.print(p.name);
		p.show();
		System.out.print(p.name);
	}
	
}
