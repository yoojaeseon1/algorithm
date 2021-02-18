package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2810 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder seats = new StringBuilder(br.readLine());
		
		int sCount = 0;
		int holderCount = 0;
		
		for(int i = 0; i < seats.length(); i++) {
			if(seats.charAt(i) == 'S') {
				sCount++;
				holderCount++;
			} else {
				holderCount++;
				i++;
			}
		}
		
		if(holderCount == sCount) {
			System.out.println(sCount);
		} else {
			System.out.println(holderCount + 1);
		}

	}
	
}
