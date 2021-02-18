package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10988 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder inputStr = new StringBuilder(br.readLine());

		if (inputStr.toString().equals(inputStr.reverse().toString()))
			System.out.println(1);
		else
			System.out.println(0);

	}
	
}
