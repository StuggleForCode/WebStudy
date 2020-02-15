package java»ù´¡;

import java.util.Scanner;

public class example09 {
	public static void main(String[] args) {
		
		int x, y;
		String c;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		c = sc.next();
		y = sc.nextInt();
		
		Size(x, y, c);
		sc.close();
		
	}
	
	
	public static void Size(int x, int y, String c) {
		if (c.equals("+"))
			System.out.println(x + y);
		else if (c.equals("-"))
			System.out.println(x - y);
		else if (c.equals("*"))
			System.out.println(x * y);
		else if (c.equals("/"))
			System.out.println(x / y);
		else
			System.out.println("·ûºÅ´íÎó");
	}
}
