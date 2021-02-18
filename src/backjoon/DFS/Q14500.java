package backjoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14500 {

	static int maxSumFourBlocks;

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
		
		
		maxSumFourBlocks = 0;
		boolean[][] isVisited = new boolean[N][M];
		List<int[]> positions = new ArrayList<>();
		for (int fieldI = 0; fieldI < N; fieldI++) {
			for (int fieldJ = 0; fieldJ < M; fieldJ++) {
				positions.clear();
				isVisited = new boolean[N][M];
				int[] addedPosition = { fieldJ, fieldI };
				positions.add(addedPosition);
				isVisited[fieldI][fieldJ] = true;
				searchField(field, isVisited, positions, fieldJ, fieldI);
				isVisited[fieldI][fieldJ] = false;
				

			}
		}

		int[] exceptedBlockX = { 1, 2, 1 };
		int[] exceptedBlockY = { 0, 0, 1 };

		searchField(field, exceptedBlockX, exceptedBlockY);

		exceptedBlockX[0] = 1;
		exceptedBlockX[1] = 1;
		exceptedBlockX[2] = 1;
		
		exceptedBlockY[0] = -1;
		exceptedBlockY[1] = 0;
		exceptedBlockY[2] = 1;
		
		searchField(field, exceptedBlockX, exceptedBlockY);
		
		exceptedBlockX[0] = -1;
		exceptedBlockX[1] = 0;
		exceptedBlockX[2] = 1;
		
		exceptedBlockY[0] = 1;
		exceptedBlockY[1] = 1;
		exceptedBlockY[2] = 1;
		
		searchField(field, exceptedBlockX, exceptedBlockY);
		
		exceptedBlockX[0] = 0;
		exceptedBlockX[1] = 0;
		exceptedBlockX[2] = 1;
		
		exceptedBlockY[0] = 1;
		exceptedBlockY[1] = 2;
		exceptedBlockY[2] = 1;
		
		searchField(field, exceptedBlockX, exceptedBlockY);
		
		System.out.println(maxSumFourBlocks);

	}

	static int[] dx = { 0, 1, 0, -1 };;
	static int[] dy = { -1, 0, 1, 0 };

	public static void searchField(int[][] field, boolean[][] isVisited, List<int[]> positions, int x, int y) {

		if (positions.size() == 4) {

			int sumFourBlocks = 0;

			for (int positionI = 0; positionI < positions.size(); positionI++) {

				int[] position = positions.get(positionI);

				sumFourBlocks += field[position[1]][position[0]];

			}
			
			maxSumFourBlocks = Math.max(maxSumFourBlocks, sumFourBlocks);
			return;
		}

		for (int di = 0; di < dx.length; di++) {

			if (x + dx[di] >= 0 && x + dx[di] < field[0].length && y + dy[di] >= 0 && y + dy[di] < field.length
					&& !isVisited[y + dy[di]][x + dx[di]]) {

				int[] addedPosition = { x + dx[di], y + dy[di] };

				positions.add(addedPosition);

				isVisited[y + dy[di]][x + dx[di]] = true;

				searchField(field, isVisited, positions, x + dx[di], y + dy[di]);

				positions.remove(positions.size() - 1);
				isVisited[y + dy[di]][x + dx[di]] = false;

			}

		}

	}

	public static void searchField(int[][] field, int[] dx, int[] dy) {

		int sumFourBlocks = 0;

		for (int fieldI = 0; fieldI < field.length; fieldI++) {
			for (int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {
				for (int di = 0; di < dx.length; di++) {
					if (fieldJ + dx[di] >= 0 && fieldJ + dx[di] < field[fieldI].length && fieldI + dy[di] >= 0
							&& fieldI + dy[di] < field.length) {
						sumFourBlocks += field[fieldI + dy[di]][fieldJ + dx[di]];
					} else
						continue;
				}
				sumFourBlocks += field[fieldI][fieldJ];
				maxSumFourBlocks = Math.max(maxSumFourBlocks, sumFourBlocks);
				sumFourBlocks = 0;
			}
		}

	}

}
