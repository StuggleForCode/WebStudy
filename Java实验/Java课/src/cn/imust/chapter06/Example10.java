package cn.imust.chapter06;

public class Example10 {

	public static void main(String[] args) {
		Object obj=new Father(){
		public void show(){
		System.out.println("helloworld");
		}
		};
		obj.show();
		}
		}
		class Father{
		public  void show(){
		System.out.println("hello father");
		}

}
