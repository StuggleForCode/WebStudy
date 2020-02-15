package java»ù´¡;

public class example13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {9, 3, 4, 2, 5 ,6, 11, 6, 3, 100, 334};
		SelectSort(a);
		Print(a);
	}
	
	public static void SelectSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int k = i;
			for (int j = i; j < a.length; j++) {
				if (a[k] > a[j]) {
					k = j;
				}
			}
			if (k != i) {
				int temp = a[k];
				a[k] = a[i];
				a[i] = temp;
			}
		}
			
	}
	
	public static void Print(int[] a) {
		for (int i  = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}
