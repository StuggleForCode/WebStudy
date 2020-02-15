package 面向对象上;

public class Example13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Outer.Inner.staticField);
		//Outer.Inner.staticMethod();
		Outer.Inner a = new Outer.Inner();
		System.out.println(a.nonStaticField);
		a.nonStaticMethod();
	}

}
