package backjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] field = new int[N][M];

		StringBuilder oneOfLine = new StringBuilder();
		for (int fieldI = 0; fieldI < N; fieldI++) {

			oneOfLine.append(br.readLine());

			for (int fieldJ = 0; fieldJ < M; fieldJ++) {

				if (oneOfLine.charAt(fieldJ) == '1')
					field[fieldI][fieldJ] = -1;

			}

			oneOfLine.setLength(0);
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		Queue<int[]> searchQueue = new LinkedList<>();

		int[] startPosition = { 0, 0 };

		searchQueue.add(startPosition);
		
		field[0][0] = 1;

		while (!searchQueue.isEmpty()) {

			int[] currentPosition = searchQueue.poll();

			int currentX = currentPosition[0];
			int currentY = currentPosition[1];

			if (currentY == N-1 && currentX == M-1)
				break;

			for (int dI = 0; dI < dx.length; dI++) {

				if (currentX + dx[dI] >= 0 && currentX + dx[dI] < M && currentY + dy[dI] >= 0
						&& currentY + dy[dI] < N) {

					if (field[currentY + dy[dI]][currentX + dx[dI]] == -1) {

						field[currentY + dy[dI]][currentX + dx[dI]] = field[currentY][currentX] + 1;
						int[] addedPosition = { currentX + dx[dI], currentY + dy[dI] };
						searchQueue.add(addedPosition);

					}

				}

			}

		}
		
		System.out.println(field[N-1][M-1]);

	}

}
