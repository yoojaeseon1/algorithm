package backjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11052 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] cardPackTypes = new int[n+1];
		
		for(int ci = 1; ci < cardPackTypes.length; ci++) {
			
			cardPackTypes[ci] = Integer.parseInt(st.nextToken());
//			System.out.println(cardPackTypes[ci]);
		}
		
		int[] maxPrices = new int[n+1];
		
		for(int mi = 1; mi < maxPrices.length; mi++) {
			for(int mj = 1; mj <= mi; mj++) {
				
				maxPrices[mi] = Math.max(maxPrices[mi], maxPrices[mi-mj] + cardPackTypes[mj]);
				
			}
		}
		
		System.out.println(maxPrices[n]);
	}
}
