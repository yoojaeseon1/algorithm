package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1138 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] beforeTallerArray = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			beforeTallerArray[i] = Integer.parseInt(st.nextToken());
		}

		int emptyCount = 0;
		int beforeTallerCount;
		int[] resultSequenceArray = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			beforeTallerCount = beforeTallerArray[i];
			for (int j = 0; j < N; j++) {
				if (resultSequenceArray[j] == 0) {
					if (beforeTallerCount == emptyCount) {
						resultSequenceArray[j] = i;
						emptyCount = 0;
						break;
					} else {
						emptyCount++;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(resultSequenceArray[i] + " ");
		}

	}

}
