package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N+5];
		int[] P = new int[N+5];

		StringTokenizer st;

		for (int TI = 0; TI < N; TI++) {
			st = new StringTokenizer(br.readLine());

			T[TI] = Integer.parseInt(st.nextToken());
			P[TI] = Integer.parseInt(st.nextToken());

		}
		
		int[] maxProfits = new int[N+5];
		
		int maxProfit = 0;
		 		
		for(int maxProfitsI = 0; maxProfitsI <= N; maxProfitsI++) {
			
			maxProfits[maxProfitsI] = Math.max(maxProfit, maxProfits[maxProfitsI]);
			
			maxProfits[maxProfitsI + T[maxProfitsI]] = Math.max(maxProfits[maxProfitsI + T[maxProfitsI]], P[maxProfitsI] + maxProfits[maxProfitsI]);
			
			maxProfit = Math.max(maxProfit, maxProfits[maxProfitsI]);
		}
		System.out.println(maxProfit);

	}

}
