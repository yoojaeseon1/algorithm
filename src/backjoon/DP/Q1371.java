package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1371 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[1001];
		
		int n = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007; 
		}
		
		System.out.println(dp[n]);
	}

}
