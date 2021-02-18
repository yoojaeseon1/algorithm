package backjoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2847 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] cases = new int[n];
		
		for(int ci = 0; ci < n; ci++) {
			cases[ci] = Integer.parseInt(br.readLine());
		}
		
		int afterNum = cases[cases.length-1];
		int decreaseCount = 0;
		for(int ci = cases.length - 2; ci >= 0; ci--) {
			
			if(afterNum <= cases[ci]) {
				int currentNum = cases[ci];
				while(afterNum <= currentNum) {
					currentNum--;
					decreaseCount++;
				}
				afterNum = currentNum;
			} else afterNum = cases[ci];
		}
		
		System.out.println(decreaseCount);

	}

}
