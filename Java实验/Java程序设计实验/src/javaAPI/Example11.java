package javaAPI;

import java.util.Random;

public class Example11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		System.out.println("----------");
		for(int i = 0 ; i< 5; i++) {
			System.out.println(r.nextInt());
		}
		
		System.out.println("----------");
		
		for (int i = 0; i < 5; i++)
			System.out.println(r.nextInt(10));

	}

}
