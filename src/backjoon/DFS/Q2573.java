package backjoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2573 {
	
	
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
	
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
	
		Queue<int[]> fieldQueue = new LinkedList<>();
	
		int numArea = 1;
		int year = 0;
	
		while (numArea == 1) {
	
			for (int fieldI = 0; fieldI < N; fieldI++) {
				for (int fieldJ = 0; fieldJ < M; fieldJ++) {
					int iceHeight = field[fieldI][fieldJ];
					if (iceHeight > 0) {
						int numSea = 0;
						for (int di = 0; di < dx.length; di++) {
							if (fieldI + dy[di] >= 0 && fieldI + dy[di] < N && fieldJ + dx[di] >= 0
									&& fieldJ + dx[di] < M && field[fieldI + dy[di]][fieldJ + dx[di]] == 0) {
								numSea++;
							}
						}
						int[] enqueuedPosition = { fieldJ, fieldI, numSea };
						fieldQueue.add(enqueuedPosition);
					}
				}
			}
	
			while (!fieldQueue.isEmpty()) {
				int[] currentPosition = fieldQueue.poll();
				int currentX = currentPosition[0];
				int currentY = currentPosition[1];
	
				field[currentY][currentX] -= currentPosition[2];
	
				if (field[currentY][currentX] < 0)
					field[currentY][currentX] = 0;
	
			}
	
			numArea = countArea(field);
			year++;
	
		}
	
		switch (numArea) {
		case 0:
			System.out.println(0);
			break;
		case 2:
			System.out.println(year);
			break;
		}
	
	}
	
	public static int countArea(int[][] field) {
	
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
	
		boolean[][] isAdded = new boolean[field.length][field[0].length];
		int numArea = 0;
		
		
	
		Queue<int[]> fieldQueue = new LinkedList<>();
	
		for (int fieldI = 0; fieldI < field.length; fieldI++) {
			for (int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {
	
				if (field[fieldI][fieldJ] > 0 && !isAdded[fieldI][fieldJ]) {
					int[] addedPosition = { fieldJ, fieldI };
	
					fieldQueue.add(addedPosition);
					isAdded[fieldI][fieldJ] = true;
	
					while (!fieldQueue.isEmpty()) {
	
						int[] currentPosition = fieldQueue.poll();
	
						int currentX = currentPosition[0];
						int currentY = currentPosition[1];
						for (int di = 0; di < dx.length; di++) {
							if (currentX + dx[di] >= 0 && currentX + dx[di] < field[0].length && currentY + dy[di] >= 0
									&& currentY + dy[di] < field.length
									&& !isAdded[currentY+dy[di]][currentX+dx[di]] && field[currentY + dy[di]][currentX + dx[di]] > 0 ) {
	
								int[] position = { currentX + dx[di], currentY + dy[di] };
	
								fieldQueue.add(position);
	
								isAdded[currentY + dy[di]][currentX + dx[di]] = true;
	
							}
	
						}
	
					}
					numArea++;
					if (numArea > 1)
						return 2;
	
				}
			}
		}
	
		return numArea;
	}
}

