package 面向的对象下;

public class Example15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer outer = new Outer();
		outer.function(new Inter() {
			public void show() {
				System.out.println("show");
			}	
			public void method() {
				System.out.println("method");
			}
		});

	}

}


interface Inter{
	public abstract void show();
	public abstract void method();
}

class Outer{
	public void function(Inter inter) {
		inter.show();
		inter.method();
	}
}