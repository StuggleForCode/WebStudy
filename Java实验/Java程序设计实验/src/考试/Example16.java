package øº ‘;

public class Example16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4};
		
		try {
			for (int  i = 0; i < 5; i++) {
				System.out.println(arr[i]);
				if(i == arr.length - 1) {
					System.out.println("over");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Ω«±Í‘ΩΩÁ");
		}

	}

}
