package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1475 {
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder n = new StringBuilder(br.readLine());
		
		int[] nums = new int[10];
		
		for(int i = 0; i < n.length(); i++) {
			nums[Integer.parseInt(n.substring(i,i+1))]++;
		}
		
		int minSets = (int)Math.round((nums[6] + nums[9]) / 2.0);
		
		for(int i = 0; i < nums.length; i++) {
			if(i != 6 && i != 9) {
				minSets = Math.max(minSets, nums[i]);
			}
		}
		
		System.out.println(minSets);
	}

}
