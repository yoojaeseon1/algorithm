package backjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		
		int min;
		int max = 0;
		
		for(int i = 1; i <= n; i++) {
			
			min = 0;
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j]) {
					if(min < dp[j])
						min = dp[j];
				}
			}
			dp[i] = min+1;
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}
		
		

//		int partSeqLength = 0;
//
//		if (n == 1) {
//			System.out.println(1);
//		} else if (n == 2) {
//			if (a[0] < a[1]) {
//				System.out.println(2);
//			} else {
//				System.out.println(1);
//			}
//		} else {
//
//			int[] partSeq = new int[n];
//
//			partSeq[0] = a[0];
//			partSeqLength = 1;
//
//			for (int i = 1; i < n; i++) {
//				if (partSeqLength > 1) {
//					if (a[i] < partSeq[partSeqLength - 1]) {
//						if (a[i] > partSeq[partSeqLength - 2])
//							partSeq[partSeqLength - 1] = a[i];
//					} else {
//						partSeq[partSeqLength++] = a[i];
//					}
//
//				} else {
//					if (a[i] > partSeq[0]) {
//						partSeq[partSeqLength++] = a[i];
//					} else {
//						partSeq[0] = a[i];
//					}
//				}
//			}
//
//			System.out.println(partSeqLength);
//		}

}
