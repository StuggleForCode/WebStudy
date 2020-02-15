package java»ù´¡;

public class example12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {9, 3, 2, 5, 6, 7, 1, 8};
		int min = FindMin(a);
		System.out.println(min);

	}
	
	public static int FindMin(int[] a) {
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (min > a[i])
				min = a[i];
		}
		return min;
	}

}
