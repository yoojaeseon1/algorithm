package programmers.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
	
	public static void main(String[] args) {

		int n = 3;
		 int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
//		int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };

		System.out.println(solution(n, computers));

	}

	public static int solution(int n, int[][] computers) {
		int networkCount = 0;

		boolean[] isEnqueued = new boolean[n];

		Queue<Integer> searchingQueue = new LinkedList<>();

		for (int ci = 0; ci < computers.length; ci++) {

			if (!isEnqueued[ci]) {

				searchingQueue.add(ci);
				isEnqueued[ci] = true;
				while (!searchingQueue.isEmpty()) {

					int currentNode = searchingQueue.poll();

					for (int cj = 0; cj < computers.length; cj++) {

						if (computers[currentNode][cj] == 1 && ci != cj && !isEnqueued[cj]) {
							searchingQueue.add(cj);
							isEnqueued[cj] = true;
						}
					}
				}
				networkCount++;
			}
		}

		return networkCount;
	}

}
