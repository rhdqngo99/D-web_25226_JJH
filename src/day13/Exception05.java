package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exception05 {

	public static void main(String[] args) {
		// IO Exception 발생 예제
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String name = "";
		try {
			name = br.readLine();
			System.out.println(name);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
