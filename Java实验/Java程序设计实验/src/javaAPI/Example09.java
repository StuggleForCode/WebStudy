package javaAPI;

import java.io.IOException;

public class Example09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runtime r = Runtime.getRuntime();
		try {
			r.exec("notepad.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
