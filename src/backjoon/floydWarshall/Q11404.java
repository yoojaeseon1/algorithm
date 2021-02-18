package backjoon.floydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11404 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] feesOfRoute = new int[n + 1][n + 1];

		StringTokenizer st;

		for (int i = 0; i < m; i++) {

			st = new StringTokenizer(br.readLine());
			int startLocation = Integer.parseInt(st.nextToken());
			int endLocation = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());

			if (feesOfRoute[startLocation][endLocation] == 0)
				feesOfRoute[startLocation][endLocation] = fee;
			else
				feesOfRoute[startLocation][endLocation] = Math.min(feesOfRoute[startLocation][endLocation], fee);
		}

		for (int fi = 1; fi < feesOfRoute.length; fi++) {
			for (int fj = 1; fj < feesOfRoute[fi].length; fj++) {
				if (feesOfRoute[fi][fj] == 0)
					feesOfRoute[fi][fj] = n * n;
			}
		}

		for (int throughStop = 1; throughStop < feesOfRoute.length; throughStop++) {

			for (int startStop = 1; startStop < feesOfRoute.length; startStop++) {

				for (int endStop = 1; endStop < feesOfRoute[startStop].length; endStop++) {
					if (startStop != endStop)
						feesOfRoute[startStop][endStop] = Math.min(feesOfRoute[startStop][endStop],
								feesOfRoute[startStop][throughStop] + feesOfRoute[throughStop][endStop]);
				}
			}
		}

		for (int ri = 1; ri < feesOfRoute.length; ri++) {

			for (int rj = 1; rj < feesOfRoute[ri].length; rj++) {
				
				System.out.print(feesOfRoute[ri][rj] == n * n ? "0 " : feesOfRoute[ri][rj] + " ");

//				if (feesOfRoute[ri][rj] == n * n)
//					System.out.print(0 + " ");
//				else
//					System.out.print(feesOfRoute[ri][rj] + " ");

			}
			System.out.println();
		}

	}

}
