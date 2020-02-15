package java基础;

import java.util.Scanner;

public class example05 {
	public static void main(String[] args) {
		String answer;
		Scanner sc = new Scanner(System.in);
		answer = sc.next();
		sc.close();
		switch(answer) {
		case "B":
			System.out.println("correct");
			break;
		case "A":
		case "C":
		case "D":
			System.out.println("wrong");
			break;
		default:
			System.out.println("不存在此选项");
			break;
		}
		
	}
}
