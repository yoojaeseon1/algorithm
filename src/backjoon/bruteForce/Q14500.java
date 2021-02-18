package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] field = new int[N][M];

		for (int fieldI = 0; fieldI < N; fieldI++) {

			st = new StringTokenizer(br.readLine());

			for (int fieldJ = 0; fieldJ < M; fieldJ++) {

				field[fieldI][fieldJ] = Integer.parseInt(st.nextToken());

			}

		}

		boolean[][] isVisited = new boolean[N][M];

		for (int fieldI = 0; fieldI < N; fieldI++) {

			for (int fieldJ = 0; fieldJ < M; fieldJ++) {
				
				isVisited[fieldI][fieldJ] = true;
				searchShape(field, isVisited, fieldJ, fieldI, field[fieldI][fieldJ], 1);
				isVisited[fieldI][fieldJ] = false;

				// คว shape

				calculateMiddleFinger(field, fieldJ, fieldI);
			}

		}

		System.out.println(maxSumPoint);

	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int maxSumPoint;

	public static void searchShape(int[][] field, boolean[][] isVisited, int currentX, int currentY, int sumPoint,
			int numDepth) {

		if (numDepth == 4) {
			maxSumPoint = Math.max(maxSumPoint, sumPoint);
			return;
		}

		for (int di = 0; di < 4; di++) {

			int nextX = currentX + dx[di];
			int nextY = currentY + dy[di];

			if (nextX >= 0 && nextX < field[currentY].length && nextY >= 0 && nextY < field.length && !isVisited[nextY][nextX]) {

				isVisited[nextY][nextX] = true;
				searchShape(field, isVisited, nextX, nextY, sumPoint + field[nextY][nextX], numDepth + 1);
				isVisited[nextY][nextX] = false;

			}

		}

	}

	public static void calculateMiddleFinger(int[][] field, int currentX, int currentY) {
		
		if(currentX + 2 < field[currentY].length && currentY + 1 < field.length)
			maxSumPoint = Math.max(maxSumPoint, field[currentY][currentX] + field[currentY][currentX+1] + field[currentY][currentX+2] + field[currentY+1][currentX+1]);
		
		if(currentX+1 < field[currentY].length && currentY - 1 >= 0 && currentY+1 < field.length)
			maxSumPoint = Math.max(maxSumPoint, field[currentY][currentX] + field[currentY][currentX+1] + field[currentY-1][currentX+1] + field[currentY+1][currentX+1]);
		
		if(currentX + 1 < field[currentY].length && currentX - 1 >= 0 && currentY + 1 < field.length)
			maxSumPoint = Math.max(maxSumPoint, field[currentY][currentX] + field[currentY+1][currentX] + field[currentY+1][currentX+1] + field[currentY+1][currentX-1]);
		
		if(currentX + 1 < field[currentY].length && currentY+2 < field.length)
			maxSumPoint = Math.max(maxSumPoint, field[currentY][currentX] + field[currentY+1][currentX] + field[currentY+2][currentX] + field[currentY+1][currentX+1]);

	}

}
