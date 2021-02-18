package backjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7569 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Position3D> fieldQueue = new LinkedList<>();
		/*
		 * int[] dx = { 0, 1, 0, -1, 0, 0 }; int[] dy = { 1, 0, -1, 0, 0, 0 };
		 * int[] dz = { 0, 0, 0, 0, 1, -1 };
		 */
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int currentDay = 0;
		int zeroCount = 0;
		int currentX, currentY, currentZ;
		Position3D curPosition;

		StringTokenizer st = new StringTokenizer(br.readLine());

		currentX = Integer.parseInt(st.nextToken());
		currentY = Integer.parseInt(st.nextToken());
		currentZ = Integer.parseInt(st.nextToken());

		int[][][] field = new int[currentZ][currentY][currentX];

		for (int z = 0; z < field.length; z++) {
			for (int y = 0; y < field[z].length; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < field[z][y].length; x++) {
					field[z][y][x] = Integer.parseInt(st.nextToken());
					if (field[z][y][x] == 0) {
						zeroCount++;
					} else if (field[z][y][x] == 1) {
						fieldQueue.offer(new Position3D(x, y, z));
					}
				}
			}
		}

		if (zeroCount == 0) {
			System.out.println(zeroCount);
		} else {

			while (!fieldQueue.isEmpty()) {
				curPosition = fieldQueue.poll();
				currentX = curPosition.getX();
				currentY = curPosition.getY();
				currentZ = curPosition.getZ();
				currentDay = field[currentZ][currentY][currentX];
				for (int i = 0; i < dx.length; i++) {
					/*
					 * if ((currentX + dx[i] >= 0) && (currentX + dx[i] <
					 * field[currentZ][currentY].length) && (currentY + dy[i] >=
					 * 0) && (currentY + dy[i] < field[currentZ].length) &&
					 * (currentZ + dz[i] >= 0) && (currentZ + dz[i] <
					 * field.length)) {
					 */
					if ((currentX + dx[i] >= 0) && (currentX + dx[i] < field[currentZ][currentY].length)
							&& (currentY + dy[i] >= 0) && (currentY + dy[i] < field[currentZ].length)) {
						if (field[currentZ][currentY + dy[i]][currentX + dx[i]] == 0) {
							fieldQueue.offer(new Position3D(currentX + dx[i], currentY + dy[i], currentZ));
							field[currentZ][currentY + dy[i]][currentX + dx[i]] = field[currentZ][currentY][currentX]
									+ 1;
							zeroCount--;
						}
					}

					if (currentZ - 1 >= 0) {
						if (field[currentZ - 1][currentY][currentX] == 0) {
							fieldQueue.offer(new Position3D(currentX, currentY, currentZ - 1));
							field[currentZ - 1][currentY][currentX] = field[currentZ][currentY][currentX] + 1;
							zeroCount--;
						}
					}
					if (currentZ + 1 < field.length) {
						if (field[currentZ + 1][currentY][currentX] == 0) {
							fieldQueue.offer(new Position3D(currentX, currentY, currentZ + 1));
							field[currentZ + 1][currentY][currentX] = field[currentZ][currentY][currentX] + 1;
							zeroCount--;
						}
					}

				}

			}
			if (zeroCount == 0) {
				System.out.println(currentDay - 1);
			} else {
				System.out.println(-1);
			}
		}

	}

}

class Position3D {

	private int x;
	private int y;
	private int z;

	public Position3D() {
		// TODO Auto-generated constructor stub
	}

	public Position3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

}
