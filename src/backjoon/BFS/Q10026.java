package backjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import backjoon.Position;

public class Q10026 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());

		int[][] field = new int[size][size];
		boolean[][] visited = new boolean[size][size];
		StringBuilder input = new StringBuilder();
		char tempInput;
		for (int i = 0; i < size; i++) {
			input.append(br.readLine());
			for (int j = 0; j < size; j++) {
				tempInput = input.charAt(j);
				if (tempInput == 'R') {
					field[i][j] = 1;
				} else if (tempInput == 'G') {
					field[i][j] = 2;
				} else if (tempInput == 'B') {
					field[i][j] = 3;
				}
			}
			input.setLength(0);
		}

		int curColur;
		Queue<Position> fieldQueue = new LinkedList<>();
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		boolean checkRG = false;
		int rgCount = 0;
		int rgbCount = 0;
		int curColor;
		Position curPosition;
		int curX, curY;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited[i][j]) {
					fieldQueue.add(new Position(j, i));
					while (!fieldQueue.isEmpty()) {
						curPosition = fieldQueue.poll();
						curX = curPosition.getX();
						curY = curPosition.getY();
						curColor = field[curY][curX];
						for (int k = 0; k < 4; k++) {
							if ((curX + dx[k]) >= 0 && (curX + dx[k]) < size && (curY + dy[k]) >= 0
									&& (curY + dy[k]) < size) {
								if (field[curY + dy[k]][curX + dx[k]] == curColor
										&& !visited[curY + dy[k]][curX + dx[k]]) {
									fieldQueue.add(new Position(curX + dx[k], curY + dy[k]));
									visited[curY + dy[k]][curX + dx[k]] = true;
								} 
							}
						}
					}
					if (checkRG) {
						rgCount++;
						checkRG = false;
					}
					rgbCount++;
				}
			}
		}
		
		visited = new boolean[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited[i][j]) {
					fieldQueue.add(new Position(j, i));
					while (!fieldQueue.isEmpty()) {
						curPosition = fieldQueue.poll();
						curX = curPosition.getX();
						curY = curPosition.getY();
						curColor = field[curY][curX];
						for (int k = 0; k < 4; k++) {
							if ((curX + dx[k]) >= 0 && (curX + dx[k]) < size && (curY + dy[k]) >= 0
									&& (curY + dy[k]) < size) {
								if (field[curY + dy[k]][curX + dx[k]] == curColor
										&& !visited[curY + dy[k]][curX + dx[k]]) {
									fieldQueue.add(new Position(curX + dx[k], curY + dy[k]));
									visited[curY + dy[k]][curX + dx[k]] = true;
								} 
								else if (field[curY + dy[k]][curX + dx[k]] <= 2 && curColor <= 2
										&& !visited[curY + dy[k]][curX + dx[k]]) {
									if (field[curY + dy[k]][curX + dx[k]] != curColor) {
										fieldQueue.add(new Position(curX + dx[k], curY + dy[k]));
										visited[curY + dy[k]][curX + dx[k]] = true;
										checkRG = true;
									}
								}
							}
						}
					}
					rgCount++;
				}
			}
		}

		System.out.println(rgbCount + " " + rgCount);
	}
}