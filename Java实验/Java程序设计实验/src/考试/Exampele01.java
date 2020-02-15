package ¿¼ÊÔ;

public class Exampele01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 3, 5, 3, 10, 1, 3, 2};
		int a = getMin(arr);
		System.out.println(a);
	}
	
	public static int getMin(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}

}
