package backjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import backjoon.Position;

public class Q1012 {
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int m, n, k, tempX, tempY, curX, curY;
		int[][][] field = new int[t][][];
		Stack<Position> fieldStack = new Stack<>();
		Position curPosition;
		int[] areaCounts = new int[t];
		int areaCount = 0;

		for (int z = 0; z < t; z++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			field[z] = new int[n][m];
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				tempX = Integer.parseInt(st.nextToken());
				tempY = Integer.parseInt(st.nextToken());
				field[z][tempY][tempX] = 1;
			}
		}

		for (int z = 0; z < t; z++) {
			for (int y = 0; y < field[z].length; y++) {
				for (int x = 0; x < field[z][y].length; x++) {

					if (field[z][y][x] == 1) {

						fieldStack.push(new Position(x, y));

						while (!fieldStack.isEmpty()) {
							curPosition = fieldStack.pop();
							curX = curPosition.getX();
							curY = curPosition.getY();
							field[z][curY][curX] = 3;

							for (int i = 0; i < dx.length; i++) {
								if ((curX + dx[i] >= 0) && (curX + dx[i] < field[z][y].length) && (curY + dy[i] >= 0)
										&& (curY + dy[i] < field[z].length)) {

									if ((field[z][curY + dy[i]][curX + dx[i]] == 1)) {
										fieldStack.push(new Position(curX + dx[i], curY + dy[i]));
										field[z][curY + dy[i]][curX + dx[i]] = 2;
									}
								}
							}
						}
						areaCount++;
					}
				}
			}
			areaCounts[z] = areaCount;
			areaCount = 0;
		}
		
		for(int i =0; i < areaCounts.length; i++) {
			System.out.println(areaCounts[i]);
		}
	}
}