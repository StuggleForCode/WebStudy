package java»ù´¡;

import java.util.Scanner;

public class example04 {
	public static void main(String[] args) {
		int month;
		Scanner sc = new Scanner(System.in);
		month = sc.nextInt();
		
		if (month == 3 || month == 4 || month == 5) {
			System.out.println("´º¼¾");
		}
		else if (month == 6 || month == 7 || month == 8) {
			System.out.println("ÏÄ¼¾");
		}
		else if (month == 9 || month == 10 || month == 11) {
			System.out.println("Çï¼¾");
		}
		else if (month == 12 || month == 1 || month == 2) {
			System.out.println("¶¬¼¾");
		}
		else {
			System.out.println("ÊäÈë´íÎó£¡£¡");
		}
		sc.close();
	}
}
