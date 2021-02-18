package backjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q8978 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] nations = new int[n][4];
		int rankCount = 1;
		int rankAdded = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				nations[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(nations, new Comparator<int[]>() {

			@Override
			public int compare(int[] nation1, int[] nation2) {

				if (nation1[1] > nation2[1]) {
					return -1;
				} else if (nation1[1] == nation2[1]) {
					if (nation1[2] > nation2[2])
						return -1;
					else if (nation1[2] == nation2[2]) {
						return Integer.compare(nation2[3], nation1[3]);
						// if (nation1[3] > nation2[3])
						// return 1;
						// else if (nation1[3] == nation2[3])
						// return 0;
						// else
						// return -1;
					} else
						return 1;
				} else
					return 1;
			}
		});
		if (nations[0][0] != k) {
			for (int i = 1; i < nations.length; i++) {
				if (nations[i][1] == nations[i - 1][1] && nations[i][2] == nations[i - 1][2]
						&& nations[i][3] == nations[i - 1][3]) {
					rankAdded++;
				} else {
					rankCount += rankAdded + 1;
					rankAdded = 0;
					
				}
				if (nations[i][0] == k)
					break;
			}
		}

		System.out.println(rankCount);

	}

}
