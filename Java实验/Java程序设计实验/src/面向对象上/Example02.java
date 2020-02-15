package 面向对象上;

import java.util.Scanner;

public class Example02 {
	public static void main(String[] args) {
		Student stu1 = new Student();
		Scanner sc = new Scanner(System.in);
		stu1.SetAge(sc.nextInt());
		stu1.SetName(sc.nextLine());
		stu1.Speak();
		
	}
}
