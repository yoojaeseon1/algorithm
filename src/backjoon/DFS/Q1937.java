package backjoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1937 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] field = new int[n][n];

		StringTokenizer st;
		for (int fieldI = 0; fieldI < n; fieldI++) {
			st = new StringTokenizer(br.readLine());
			for (int fieldJ = 0; fieldJ < n; fieldJ++) {
				field[fieldI][fieldJ] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] route = new int[n][n];

		int maxNumMoved = 0;
		for (int fieldI = 0; fieldI < n; fieldI++) {
			for (int fieldJ = 0; fieldJ < n; fieldJ++) {
				maxNumMoved = Math.max(maxNumMoved, countLiveDay(field, route, fieldJ, fieldI));
			}
		}

		System.out.println(maxNumMoved);

	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static int countLiveDay(int[][] field, int[][] route, int x, int y) {

		if (route[y][x] != 0)
			return route[y][x];

		int numMoved = 1;
		for (int di = 0; di < dx.length; di++) {
			if (x + dx[di] >= 0 && x + dx[di] < field[0].length && y + dy[di] >= 0 && y + dy[di] < field.length) {
				if(field[y+dy[di]][x+dx[di]] > field[y][x]) {
					numMoved = Math.max(numMoved, countLiveDay(field, route, x+dx[di], y+dy[di]) + 1);
					route[y][x] = numMoved;
				}
			}
		}

		return numMoved;

	}

}
