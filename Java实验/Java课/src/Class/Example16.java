package Class;

public class Example16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Animal_Three ani1 = new Animal_Three();
//		System.out.println(ani1.toString());
		//System.out.println("Hello world");
		
//		class Cat_Tow implements Animal_Three{
//			public void shout() {
//				System.out.println("猫的叫声");
//			}
//		}
//		
//		animalShout(new Cat_Tow());
		
		animalShout(new Animal_Three() {
			public void shout() {
				System.out.println("猫的叫声");
			}
		});
	}

	private static void animalShout(Animal_Three an) {
		// TODO Auto-generated method stub
		an.shout();
	}
}


interface Animal_Three{
	void shout();
}


/*class Animal_Three{
	void shout() {
		System.out.println("动物的叫声");
	}
	public String toString() {
		return "this is an Animal";
	}
}
*/