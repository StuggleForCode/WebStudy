package Class;

public class Example01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		dog.pringName();
		dog.shout();
		

	}

}


class Animal{
	public String name = "动物";
	public void shout() {
		System.out.println("动物发出叫声");
	}
}


class Dog extends Animal{
	public String name = "犬类";
	public void shout() {
		System.out.println("狗的叫声");
	}
	public void pringName() {
		System.out.println("name = " + super.name);
	}
}