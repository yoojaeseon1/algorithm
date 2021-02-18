package backjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

//		boolean isUsableElev = false;
		Queue<Integer> fieldQueue = new LinkedList<>();
		int[] field = new int[f + 1];
		boolean[] visited = new boolean[f + 1];
		int curPosition = 0;
		fieldQueue.add(s);
		visited[s] = true;

		while (!fieldQueue.isEmpty()) {
			curPosition = fieldQueue.poll();
			
//			if (curPosition == g || curPosition == g) {
//				isUsableElev = true;
//				break;
//			}

			if (curPosition + u <= f && !visited[curPosition + u]) {
				int nextPosition = curPosition + u;
				field[nextPosition] = field[curPosition] + 1;
				visited[nextPosition] = true;
				fieldQueue.add(nextPosition);
			}
			if (curPosition - d >= 1 && !visited[curPosition - d]) {
				int nextPosition = curPosition - d;
				field[nextPosition] = field[curPosition] + 1;
				visited[nextPosition] = true;
				fieldQueue.add(nextPosition);
			}
		}

		if(visited[g])
			System.out.println(field[g]);
		else
			System.out.println("use the stairs");
	}

}
