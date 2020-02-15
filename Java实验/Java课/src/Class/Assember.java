package Class;

public class Assember {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	interface PCI{
		void start();
		void stop();
	}
}


class NetworkCard implements PCI{
	public void start() {
		System.out.println("send...");
	}
}
