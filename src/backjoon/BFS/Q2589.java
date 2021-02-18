package backjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2589 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		StringBuilder tempLine = new StringBuilder();
		char[][] field = new char[N][M];
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		for (int i = 0; i < N; i++) {
			tempLine.append(br.readLine());
			for (int j = 0; j < M; j++) {
				field[i][j] = tempLine.charAt(j);
			}
			tempLine.setLength(0);
		}

		boolean[][] visitedCheck = new boolean[N][M];
		boolean[][] pushedCheck = new boolean[N][M];
		Queue<int[]> fieldQueue = new LinkedList<>();
		int[] curPosition, pushedPosition;
		int currentX, currentY;
		int maxDistance = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (field[i][j] == 'L') {
					visitedCheck = new boolean[N][M];
					pushedCheck = new boolean[N][M];
					curPosition = new int[3];
					curPosition[0] = j;
					curPosition[1] = i;
					curPosition[2] = 0;
					visitedCheck[i][j] = true;
					pushedCheck[i][j] = true;
					fieldQueue.add(curPosition);

					while (!fieldQueue.isEmpty()) {
						curPosition = fieldQueue.poll();
						currentX = curPosition[0];
						currentY = curPosition[1];
						visitedCheck[currentY][currentX] = true;
						maxDistance = Math.max(maxDistance, curPosition[2]);
						for (int k = 0; k < 4; k++) {
							if (currentX + dx[k] >= 0 && currentX + dx[k] < M && currentY + dy[k] >= 0
									&& currentY + dy[k] < N) {
								if (field[currentY + dy[k]][currentX + dx[k]] == 'L' && !visitedCheck[currentY + dy[k]][currentX + dx[k]]
										&& !pushedCheck[currentY + dy[k]][currentX + dx[k]]) {
									pushedPosition = new int[3];
									pushedPosition[0] = currentX + dx[k];
									pushedPosition[1] = currentY + dy[k];
									pushedPosition[2] = curPosition[2] + 1;
									pushedCheck[currentY + dy[k]][currentX + dx[k]] = true;
									fieldQueue.add(pushedPosition);
								}
							}
						}
					}			
				}
			}
		}
		
		System.out.println(maxDistance);
	}

}
