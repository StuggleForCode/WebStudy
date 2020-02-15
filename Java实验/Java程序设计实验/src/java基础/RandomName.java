package java基础;

import java.util.Random;
import java.util.Scanner;

public class RandomName {
	
	static String[] Namestr = new String[100];
	
	public static void main(String[] args) {
		int n;
		System.out.println("请入全班一共有多少人");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		//System.out.println(n);
		
		ScannerName(n);
		PrintName(n);
		Randomname(n);
		sc.close();
		
	}
	
	public static void ScannerName(int n) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			System.out.print("储存第" + (i+1) + "个人的姓名：");
			Namestr[i] = sc.next();
		}	
		sc.close();
	}
	
	public static void PrintName(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("第" + i + "个学生的姓名：" + Namestr[i]);
		}
	}
	
	public  static void Randomname(int n) {
		int RandomNumber = new Random().nextInt(n);
		//System.out.println(RandomNumber);
		System.out.println("别点到明的同学是：" + Namestr[RandomNumber]);
	}
	
}



//刘备
//张飞
//关羽

