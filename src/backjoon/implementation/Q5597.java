package backjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5597 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] attendCheck = new boolean[31];
		
		for(int i = 0; i < 28; i++) {
			attendCheck[Integer.parseInt(br.readLine())] = true;
		}
		
		Integer[] notAttend = new Integer[2];
		int notAttendIndex = 0;
		
		for(int i = 1; i < attendCheck.length; i++) {
			if(!attendCheck[i]) {
				notAttend[notAttendIndex++] = i;
			}
		}
		
		Arrays.sort(notAttend);
		
		for(int i = 0; i < notAttend.length; i++) {
			System.out.println(notAttend[i]);
		}
	}

}
