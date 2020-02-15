package java»ù´¡;

public class example11 {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		print(a);
		
		
		
	}
	
	public static void print(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println(a[a.length - 1]);
	}
}
