package backjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q11724 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int u, v;
		int count = 1;
		int curPosition;
		boolean searchCheck = false;
		boolean zeroCheck = false;

		int[][] adjancy = new int[n + 1][n + 1];
		int[] visited = new int[n + 1];

		Stack<Integer> nodeStack = new Stack<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			adjancy[u][v] = 1;
			adjancy[v][u] = 1;

		}

		for (int i = 1; i <= n; i++) {
			nodeStack.push(i);
			visited[i] = count;
			while (!nodeStack.isEmpty()) {
				curPosition = nodeStack.pop();
				visited[curPosition] = count;
//				System.out.println("curPosition" + curPosition);
				for (int j = 1; j <= n; j++) {
					if (adjancy[curPosition][j] == 1) {
						zeroCheck = true;
						if (visited[j] == 0) {
							searchCheck = true;
//							System.out.println("j : " + j);
							visited[j] = count;
							nodeStack.push(j);
						}
					}
				}
			}

			if (searchCheck || !zeroCheck) {
				count++;
				searchCheck = false;
			}
			zeroCheck = false;
			
		}

		System.out.println(count - 1);
	}
}
