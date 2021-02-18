package backjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2156 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n + 1];
		long maxSum = 0;
		long tempMax = 0;

		for (int i = 1; i <= n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}

		long[][] dp = new long[n + 1][3];
		dp[1][0] = wines[1];
		dp[1][1] = wines[1];
		dp[1][2] = wines[1];
		if (n >= 2) {
			dp[2][0] = wines[2] + dp[1][1];
			dp[2][1] = wines[2];
			dp[2][2] = wines[2];
		}
		for (int i = 3; i <= n; i++) {
			dp[i][0] = wines[i] + Math.max(dp[i - 1][1], dp[i - 1][2]);
			tempMax = Math.max(dp[i - 2][0], dp[i - 2][1]);
			dp[i][1] = wines[i] + Math.max(tempMax, dp[i - 2][2]);
			tempMax = Math.max(dp[i - 3][0], dp[i - 3][1]);
			dp[i][2] = wines[i] + Math.max(tempMax, dp[i - 3][2]);
		}

		maxSum = Math.max(dp[n][0], dp[n][1]);
		maxSum = Math.max(maxSum, dp[n - 1][0]);
		maxSum = Math.max(maxSum, dp[n - 1][1]);
		maxSum = Math.max(maxSum, dp[n - 1][2]);
		if (n >= 2) {
			maxSum = 0;
			for (int i = n - 1; i <= n; i++) {
				for (int j = 0; j <= 2; j++) {
					maxSum = Math.max(maxSum, dp[i][j]);
				}
			}
		}

		System.out.println(maxSum); // max : 6667000
		
		
		
		// another answer
		
//		int[] dp = new int[n+1];
//		dp[1] = wines[1];
//		if(n >= 2) {
//			dp[2] = wines[1] + wines[2];
//		}
//		
//		for(int i = 3; i <= n; i++) {
//			dp[i] = Math.max(wines[i] + wines[i-1] + dp[i-3], wines[i] + dp[i-2]);
//			dp[i] = Math.max(dp[i], dp[i-1]);
//		}
//		
//		System.out.println(dp[n]);
	}

}
