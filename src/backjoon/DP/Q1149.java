package backjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] minCost = new int[3];

		StringTokenizer st = new StringTokenizer(br.readLine());

		minCost[0] = Integer.parseInt(st.nextToken());
		minCost[1] = Integer.parseInt(st.nextToken());
		minCost[2] = Integer.parseInt(st.nextToken());

		int[] currentCost = new int[3];

		for (int houseCount = 1; houseCount < n; houseCount++) {

			st = new StringTokenizer(br.readLine());

			currentCost[0] = Integer.parseInt(st.nextToken());
			currentCost[1] = Integer.parseInt(st.nextToken());
			currentCost[2] = Integer.parseInt(st.nextToken());
			int[] currentMinCost = new int[3];
			for (int mi = 0; mi < 3; mi++) {
//				System.out.println("mi : " + mi);
				int tempMinCost = Integer.MAX_VALUE;
				for (int mj = 0; mj < 3; mj++) {
					// System.out.print("mj : " + mj + " / ");
					if (mi != mj) {
						// System.out.println("minCost[mj] : " + minCost[mj]);
						tempMinCost = Math.min(tempMinCost, minCost[mj]);
					}

					// currentMinCost[0] = Math.min(minCost[1], minCost[2]) +
					// currentCost[0];
					// currentMinCost[1] = Math.min(minCost[0], minCost[2]) +
					// currentCost[1];
					// currentMinCost[2] = Math.min(minCost[0], minCost[1]) +
					// currentCost[2];

					// }
					// System.out.println("tempMinCost : " + tempMinCost);
				}
				currentMinCost[mi] = currentCost[mi] + tempMinCost;
			}
			System.arraycopy(currentMinCost, 0, minCost, 0, currentMinCost.length);

		}
		int minCostSum = Math.min(minCost[0], minCost[1]);
		minCostSum = Math.min(minCostSum, minCost[2]);

		System.out.println(minCostSum);
	}

}
