package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int[] result = new int[11];
		
		 result[1] = 1;
		 result[2] = 2;
		 result[3] = 4;
		
		 for(int i = 4; i <= 10; i++) {
		 result[i] = result[i-1] + result[i-2] + result[i-3];
		 }
		 
		int castedN;
		int caseCnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < caseCnt; i++) {
			castedN = Integer.parseInt(br.readLine());
			System.out.println(result[castedN]);

		}

	}
}