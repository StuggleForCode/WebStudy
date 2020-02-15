package javaAPI;

public class Example06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append(100).append("hello").append(true).append(12.5);
		System.out.println(sb);
		sb.insert(8, "world");
		System.out.println(sb);
		
		sb.deleteCharAt(1);
		System.out.println(sb);
		sb.delete(5, 10);
		System.out.println(sb);
	}

}
