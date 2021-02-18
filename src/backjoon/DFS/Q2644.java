package backjoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//DFS

//comment : BFS

public class Q2644 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean[][] relations = new boolean[n + 1][n + 1];

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int tempI, tempJ;
		int m = Integer.parseInt(br.readLine());

//		Queue<int[]> relationQueue = new LinkedList<>();
		Stack<int[]> relationStack = new Stack<>();
		int[] tempArr, curPerson;
		boolean[] visited = new boolean[n + 1];
		int result = -1;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			tempI = Integer.parseInt(st.nextToken());
			tempJ = Integer.parseInt(st.nextToken());
			relations[tempI][tempJ] = true;
			relations[tempJ][tempI] = true;
		}

		for (int i = 1; i <= n; i++) {

			if (relations[x][i]) {
				if (y == i) {
					result = 1;
					break;
				} else {
					tempArr = new int[2];
					tempArr[0] = i;
					tempArr[1] = 1;
//					relationQueue.add(tempArr);
					relationStack.push(tempArr);
				}
			}
		}
		visited[x] = true;
		if (result == -1) {
//			while (!relationQueue.isEmpty()) {
			while(!relationStack.isEmpty()) {
//				curPerson = relationQueue.poll();
				curPerson = relationStack.pop();
				visited[curPerson[0]] = true;
//				System.out.println("curPosition : " + curPerson[0]);
				for (int i = 1; i <= n; i++) {
					if (relations[curPerson[0]][i]) {
						if (y == i) {
							result = curPerson[1] + 1;
//							relationQueue.clear();
							relationStack.clear();
							break;
						}
						if (!visited[i]) {
							tempArr = new int[2];
							tempArr[0] = i;
							tempArr[1] = curPerson[1] + 1;
//							relationQueue.add(tempArr);
							relationStack.push(tempArr);
						}
					}
				}
			}
		}

		System.out.println(result);
	}

}
