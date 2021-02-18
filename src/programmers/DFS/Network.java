package programmers.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

	public static void main(String[] args) {

		// int[] test = { 1, 2, 3, 4 };
		//
		// System.out.println(test[0]);
		//
		// test = new int[2];
		//
		// System.out.println(test[0]);

		int n = 3;
//		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
//		 int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		// int[][] computers = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		 int[][] computers = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};

		System.out.println(solution(n, computers));

	}

	public static int solution(int n, int[][] computers) {
		int numNetwork = 0;

		Queue<Integer> searchQueue = new LinkedList<>();

		for (int computersI = 0; computersI < computers.length; computersI++) {

			if (computers[computersI][computersI] == 1) {

				searchQueue.add(computersI);
				while (!searchQueue.isEmpty()) {
					int currentPosition = searchQueue.poll();
					computers[currentPosition][currentPosition] = 3;
					for (int computersJ = 0; computersJ < computers[currentPosition].length; computersJ++) {
						if(computers[currentPosition][computersJ] == 1) {
							searchQueue.add(computersJ);
							computers[currentPosition][computersJ] = 2;
							computers[computersJ][currentPosition] = 2;
						}
					}
				}
				numNetwork++;
			}
		}

		return numNetwork;
	}

}
