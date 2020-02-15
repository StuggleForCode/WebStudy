package javaAPI;

public class Example07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		sb.append("hello").append("world").append("java");
		sb.replace(5, 10, "¡÷«‡œº");
		System.out.println(sb);
		String s = sb.substring(5);
		System.out.println(s);
		
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
	}

}
