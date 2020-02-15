package 面向的对象下;

public class Example11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MIPhone mi = new MIPhone();
		mi.UseMIUI();
		mi.receiveMessages();
		mi.call();
		mi.faceTime();
		
	}

}


interface Phone{
	public abstract void receiveMessages();
	public abstract void call();
}

interface SmartPhone extends Phone{
	public abstract void faceTime();
}

class MIPhone implements SmartPhone{
	public void UseMIUI() {
		System.out.println("UseMIUI");
	}
	
	public void receiveMessages() {
		System.out.println("receiveMessages");
	}
	public void call() {
		System.out.println("call");
	}
	public void faceTime() {
		System.out.println("faceTime");
	}
}