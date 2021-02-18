package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int n;
		
		int[] zeroCnt = new int[41];
		int[] oneCnt = new int[41];
		
		zeroCnt[0] = 1;
		zeroCnt[1] = 0;
		oneCnt[0] = 0;
		oneCnt[1] = 1;
		
		for(int i = 2; i <= 40; i++) {
			
			zeroCnt[i] = zeroCnt[i-1] + zeroCnt[i-2];
			oneCnt[i] = oneCnt[i-1] + oneCnt[i-2];
		}
		
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			
			System.out.println(zeroCnt[n] + " " + oneCnt[n]);
		}
		
	}

}
