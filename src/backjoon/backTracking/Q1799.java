package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1799 {

	static int size;
	static int[][] field;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { -1, 1, 1, -1 };
	static int maxBlackCount = 0;
	static int maxWhiteCount = 0;
	static int searchCount = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());
		field = new int[size][size];

		StringTokenizer st;

		for (int i = 0; i < field.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] blackVisited = new boolean[size][size];
		boolean[][] whiteVisited = new boolean[size][size];

		searchBlack(blackVisited, 0, 0, 0);

		searchWhite(whiteVisited, 1, 0, 0);

		System.out.println(maxBlackCount + maxWhiteCount);

	}

	static void searchBlack(boolean[][] visited, int x, int y, int count) {

		maxBlackCount = Math.max(maxBlackCount, count);

		if (x >= size) {
			y++;
			x = (y % 2 == 0) ? 0 : 1;
		}

		if (y >= size)
			return;

		if (isPosible(visited, x, y)) {
			visited[y][x] = true;
			searchBlack(visited, x + 2, y, count + 1);
			visited[y][x] = false;
		}

		searchBlack(visited, x + 2, y, count);

	}

	static void searchWhite(boolean[][] visited, int x, int y, int count) {

		searchCount++;

		maxWhiteCount = Math.max(maxWhiteCount, count);

		if (x >= size) {
			y++;
			x = (y % 2 == 0) ? 1 : 0;
		}

		if (y >= size)
			return;

		if (isPosible(visited, x, y)) {
			visited[y][x] = true;
			searchWhite(visited, x + 2, y, count + 1);
			visited[y][x] = false;
		}
		searchWhite(visited, x + 2, y, count);
	}

	static boolean isPosible(boolean[][] visited, int x, int y) {

		if (field[y][x] == 0)
			return false;

		int curX;
		int curY;

		for (int i = 0; i < 4; i++) {

			curX = x + dx[i];
			curY = y + dy[i];

			for (int j = 1; j <= size; j++) {
				if (curX >= 0 && curX < size && curY >= 0 && curY < size) {
					if (visited[curY][curX])
						return false;
					curX += dx[i];
					curY += dy[i];
				}
			}
		}
		return true;

	}
}