package backjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2583 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] field = new int[m][n];

		for (int kCount = 1; kCount <= k; kCount++) {

			st = new StringTokenizer(br.readLine());

			int beginX = Integer.parseInt(st.nextToken());
			int beginY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			for (int fi = beginY; fi < endY; fi++) {

				for (int fj = beginX; fj < endX; fj++) {

					field[fi][fj] = 1;
				}
			}

		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		List<Integer> areas = new ArrayList<>();
		Stack<int[]> fieldStack = new Stack<>();

		for (int fi = 0; fi < field.length; fi++) {
			for (int fj = 0; fj < field[fi].length; fj++) {

				if (field[fi][fj] == 0) {
					int[] beginPosition = { fj, fi };

					fieldStack.push(beginPosition);
					field[beginPosition[1]][beginPosition[0]] = 1;
					int areaCount = 0;

					while (!fieldStack.isEmpty()) {

						areaCount++;

						int[] currentPosition = fieldStack.pop();

						int currentX = currentPosition[0];
						int currentY = currentPosition[1];

						for (int di = 0; di < 4; di++) {

							if (currentX + dx[di] >= 0 && currentX + dx[di] < field[0].length && currentY + dy[di] >= 0
									&& currentY + dy[di] < field.length) {

								if (field[currentY + dy[di]][currentX + dx[di]] == 0) {
									int[] pushedPosition = { currentX + dx[di], currentY + dy[di] };

									fieldStack.push(pushedPosition);

									field[currentY + dy[di]][currentX + dx[di]] = 1;
									
								}
							}
						}
					}
					
					areas.add(areaCount);

				}

			}
		}
		
		System.out.println(areas.size());
		
		
		Collections.sort(areas);
		for(int ai = 0; ai < areas.size(); ai++) {
			System.out.print(areas.get(ai) + " ");
		}

	}
}