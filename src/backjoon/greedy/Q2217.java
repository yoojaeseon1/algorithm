package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] ropeArray = new int[n];

		for (int i = 0; i < n; i++) {
			ropeArray[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(ropeArray);

		int maxWeight = 0;
		int ableRopeCount = n;

		for (int i = 0; i < n; i++) {
			maxWeight = Math.max(maxWeight, ropeArray[i] * ableRopeCount);
			ableRopeCount--;
		}
		System.out.println(maxWeight);
	}

}
