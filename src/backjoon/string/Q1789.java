package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1789 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long s = Long.parseLong(br.readLine());
		long n = 0;
		long sum = 0;
		
		while(sum < s) {
			n++;
			sum += n;
		}
		
		if(sum == s) {
			System.out.println(n);
		} else {
			System.out.println(n - 1);
		}
		
	}

}
