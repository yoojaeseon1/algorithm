package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2193 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] pinaryNum = new long[n + 1];

		pinaryNum[1] = 1;
		if (n >= 2) {

			pinaryNum[2] = 1;
		}

		for (int i = 3; i <= n; i++) {

			pinaryNum[i] = pinaryNum[i - 1] + pinaryNum[i - 2];

		}

		System.out.println(pinaryNum[n]);
		
		
//		long[] dp = new long[n+1];
//		
//		
//		if(n <= 2) {
//			System.out.println(1);
//		} else {
//			dp[1] = 1;
//			dp[2] = 1;
//			for(int i = 3; i <= n; i++) {
//				dp[i] = dp[i-2] + dp[i-1];
//			}
//			System.out.println(dp[n]);
//		}
	}
}
