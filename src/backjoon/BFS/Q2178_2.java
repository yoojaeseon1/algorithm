package backjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178_2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] field = new int[N][M];

		StringBuilder fieldInput = new StringBuilder();
		for (int fieldI = 0; fieldI < field.length; fieldI++) {

			fieldInput.append(br.readLine());

			for (int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {

				if (fieldInput.charAt(fieldJ) == '1')
					field[fieldI][fieldJ] = 1;

			}

			fieldInput.setLength(0);

		}

		Queue<int[]> fieldQueue = new LinkedList<>();

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		int[] currentPosition = new int[2];
		
		if(field[0][1] == 1) {
			field[0][1] = 2;
			currentPosition = new int[2];
			currentPosition[0] = 1;
			currentPosition[1] = 0;
			fieldQueue.add(currentPosition);
			
		}
		
		if(field[1][0] == 1) {
			field[1][0] = 2;
			currentPosition = new int[2];
			currentPosition[0] = 0;
			currentPosition[1] = 1;
			fieldQueue.add(currentPosition);
		}
		
		field[0][0] = 0;

		while (!fieldQueue.isEmpty()) {

			currentPosition = fieldQueue.poll();

			int currentX = currentPosition[0];
			int currentY = currentPosition[1];
			
			for (int di = 0; di < dx.length; di++) {

				if (currentX + dx[di] >= 0 && currentX + dx[di] < M && currentY + dy[di] >= 0
						&& currentY + dy[di] < N) {
					if(field[currentY+dy[di]][currentX+dx[di]] == 1) {
						
						field[currentY+dy[di]][currentX+dx[di]] = field[currentY][currentX] +1;
						
						currentPosition = new int[2];
						currentPosition[0] = currentX+dx[di];
						currentPosition[1] = currentY+dy[di];
						
						fieldQueue.add(currentPosition);
						
					}
				}
			}
		}
		
		System.out.println(field[N-1][M-1]);


	}
}
