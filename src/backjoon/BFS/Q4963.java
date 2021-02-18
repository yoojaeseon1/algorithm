package backjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q4963 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
		int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
		Stack<int[]> fieldStack = new Stack<>();
		int areaCount;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int xSize = Integer.parseInt(st.nextToken());
			int ySize = Integer.parseInt(st.nextToken());

			if (xSize == 0 && ySize == 0)
				break;

			int[][] field = new int[ySize][xSize];
			areaCount = 0;
			for (int fieldY = 0; fieldY < field.length; fieldY++) {
				st = new StringTokenizer(br.readLine());
				for (int fieldX = 0; fieldX < field[0].length; fieldX++) {
					field[fieldY][fieldX] = Integer.parseInt(st.nextToken());
				}
			}

			for (int fieldY = 0; fieldY < field.length; fieldY++) {
				for (int fieldX = 0; fieldX < field[0].length; fieldX++) {
					if (field[fieldY][fieldX] == 1) {

//						int[] firstPosition = new int[2];
//						firstPosition[0] = fieldY;
//						firstPosition[1] = fieldX;
						int[] firstPosition = {fieldY, fieldX};

						fieldStack.push(firstPosition);

						while (!fieldStack.isEmpty()) {

							int[] curPosition = fieldStack.pop();
							int curY = curPosition[0];
							int curX = curPosition[1];
							field[curY][curX] = 2;
							for (int di = 0; di < dx.length; di++) {

								if (curX + dx[di] >= 0 && curX + dx[di] < field[0].length && curY + dy[di] >= 0
										&& curY + dy[di] < field.length) {
									if (field[curY + dy[di]][curX + dx[di]] == 1) {

//										int[] pushedPosition = new int[2];
//										pushedPosition[0] = curY + dy[di];
//										pushedPosition[1] = curX + dx[di];
										int[] pushedPosition = {curY + dy[di], curX + dx[di]};
										fieldStack.push(pushedPosition);
										field[curY + dy[di]][curX + dx[di]] = 2; // pushed
																					// flag
									}
								}

							}

						}
						areaCount++;
					}

				}
			}
			System.out.println(areaCount);
		}

	}

}
