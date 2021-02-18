package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6603 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int n;
		int[] arr;
		int[] combArr;

		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			arr = new int[n];
			combArr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			doCombination(combArr, n, 6, 0, 0, arr);
			System.out.println();
		}

	}

	public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {

		if (r == 0) {
			for (int i = 0; i < index; i++)
				System.out.print(arr[combArr[i]] + " ");

			System.out.println();

		} else if (target == n) {

			return;

		} else {
			combArr[index] = target;
			doCombination(combArr, n, r - 1, index + 1, target + 1, arr);

			doCombination(combArr, n, r, index, target + 1, arr);
		}
	}
}