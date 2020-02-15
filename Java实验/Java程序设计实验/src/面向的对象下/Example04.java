package 面向的对象下;

public class Example04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zi zi = new Zi();
		zi.show();
	}
}


class Fu{
	public final int num = 10;
	
	
}

class Zi extends Fu{
	Zi(){}
	void show() {
		
		System.out.println(super.num);
	}
}