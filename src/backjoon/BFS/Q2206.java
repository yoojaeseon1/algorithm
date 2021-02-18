package backjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][][] field = new int[N][M][2];

		StringBuilder oneLine = new StringBuilder();
		for (int fieldI = 0; fieldI < field.length; fieldI++) {
			oneLine.append(br.readLine());
			for (int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {
				if (oneLine.charAt(fieldJ) == '0') {
					field[fieldI][fieldJ][0] = 0;
				} else {
					field[fieldI][fieldJ][0] = 1;
				}
				field[fieldI][fieldJ][1] = 2;
			}
			oneLine.setLength(0);
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		Queue<Coordinate> fieldQueue = new LinkedList<>();

		field[0][0][0] = 1;
		field[0][0][1] = 0;
		fieldQueue.add(new Coordinate(0, 0, 1, 0));
		int minDistance = 0;
		while (!fieldQueue.isEmpty()) {
			Coordinate currentPosition = fieldQueue.poll();

			int currentX = currentPosition.getX();
			int currentY = currentPosition.getY();

			if (currentX == M - 1 && currentY == N - 1) {
				minDistance = currentPosition.getDistance();
				break;
			}

			for (int di = 0; di < dx.length; di++) {

				if (currentX + dx[di] >= 0 && currentX + dx[di] < field[0].length && currentY + dy[di] >= 0
						&& currentY + dy[di] < field.length) {
					if (field[currentY + dy[di]][currentX + dx[di]][1] <= currentPosition.getNumDestroy())
						continue;

					if (field[currentY + dy[di]][currentX + dx[di]][0] == 0) {

						field[currentY + dy[di]][currentX + dx[di]][1] = currentPosition.getNumDestroy();

						fieldQueue.add(new Coordinate(currentX + dx[di], currentY + dy[di],
								currentPosition.getDistance() + 1, currentPosition.getNumDestroy()));

					} else if (field[currentY + dy[di]][currentX + dx[di]][0] == 1
							&& currentPosition.getNumDestroy() == 0) {

						field[currentY + dy[di]][currentX + dx[di]][1] = 1;
						fieldQueue.add(new Coordinate(currentX + dx[di], currentY + dy[di], currentPosition.getDistance()+1,
								currentPosition.getNumDestroy() + 1));

					}
				}
			}
		}

		if (minDistance == 0)
			System.out.println(-1);
		else
			System.out.println(minDistance);
	}

}

class Coordinate {

	private int x;
	private int y;
	private int distance;
	private int numDestroy;

	public Coordinate() {

	}

	public Coordinate(int x, int y, int distance, int numDestroy) {

		this.x = x;
		this.y = y;
		this.distance = distance;
		this.numDestroy = numDestroy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getNumDestroy() {
		return numDestroy;
	}

	public void setNumDestroy(int numDestroy) {
		this.numDestroy = numDestroy;
	}

}
