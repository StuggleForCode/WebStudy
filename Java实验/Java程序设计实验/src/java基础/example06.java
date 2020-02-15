package java»ù´¡;

public class example06 {
	public static void main(String [] args) {
		int x = 1;
		int count = 0;
		while (x <= 10) {
			if (x % 2 == 0) 
				count++;
			x++;
		}
		System.out.println("count = " + count );
	}

}
