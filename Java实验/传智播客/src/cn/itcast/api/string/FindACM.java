package cn.itcast.api.string;

import java.util.Scanner;

public class FindACM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			String str;
			str= sc.nextLine();
			String str1 = "ACM";
			int x = str.indexOf(str1, 0);
			if(str == str1) {
				System.out.println("Case " + (i + 1)+ ": " + "No");
			}
			else if (x > 0)
				System.out.println("Case " + (i + 1)+ ": " + "Yes");
			else 
				System.out.println("Case " + (i + 1)+ ": " + "No");
			
		}

	}

}
