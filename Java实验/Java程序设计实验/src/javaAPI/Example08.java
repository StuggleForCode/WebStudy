package javaAPI;

import java.util.Arrays;

public class Example08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
		int[] arr2 = {5, 6, 7, 8, 9};
		System.out.println("系统当前时间：" + System.currentTimeMillis());
		System.arraycopy(arr, 3, arr2, 3, 2);
		
		System.out.println("数组arr的内容为：" + Arrays.toString(arr));
		System.out.println("数组arr2的内容为：" + Arrays.toString(arr2));
		System.exit(100);
		System.out.println("HelloWorld");
	}

}
