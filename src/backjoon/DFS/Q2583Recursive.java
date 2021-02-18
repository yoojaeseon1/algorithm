package backjoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2583Recursive {

	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { -1, 0, 1, 0 };
	
	// using static filed
	
	// private static int areaCount;

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

		List<Integer> areas = new ArrayList<>();
		for (int fi = 0; fi < field.length; fi++) {
			for (int fj = 0; fj < field[fi].length; fj++) {

				if (field[fi][fj] == 0) {
					field[fi][fj] = 2;
					int areaCount = 1;
					
					areas.add(doDFS(field, fj, fi, areaCount));

					// areaCount = 0;
					// areas.add(areaCount);
//					 doDFS(field, fj, fi);
				}

			}
		}

		Collections.sort(areas);

		System.out.println(areas.size());

		for (int ai = 0; ai < areas.size(); ai++) {
			System.out.print(areas.get(ai) + " ");
		}

	}

	// public static void doDFS(int[][] field, int x , int y) {
	public static int doDFS(int[][] field, int x, int y, int areaCount) {
		
//		areaCount++;
		
		System.out.println("currentPosition : (" + x + ", " + y + ")");
		
		System.out.println("start areaCount : " + areaCount);
		System.out.println("----------");

		for (int di = 0; di < 4; di++) {

			if (x + dx[di] >= 0 && x + dx[di] < field[0].length && y + dy[di] >= 0 && y + dy[di] < field.length) { // range
																													// check

				if (field[y + dy[di]][x + dx[di]] == 0) {

					field[y + dy[di]][x + dx[di]] = 2;
					System.out.println("pushedPosition : ("+ (x + dx[di]) + ", " + (y + dy[di]) + ")");
					areaCount = doDFS(field, x + dx[di], y + dy[di], ++areaCount);
//					doDFS(field, x + dx[di], y + dy[di]);
					

				}
			}
		}
		
		
		System.out.println("currentPosition : (" + x + ", " + y + ")");
		System.out.println("end areaCount : " + areaCount);
		System.out.println("------------");
		return areaCount;

	}

}
