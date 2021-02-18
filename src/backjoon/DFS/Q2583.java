// baekjoon 2583

package backjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import backjoon.Position;

public class Q2583 {

	static int[][] mapArr;
	static Stack<Position> dfsStack;
	static Position curPosition;
	static int m, n;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); // ����
		n = Integer.parseInt(st.nextToken()); // ����
		mapArr = new int[m][n];
		int occupiedCnt = Integer.parseInt(st.nextToken());
		int areaCnt = 0;

		int startX, startY, endX, endY;

		for (int i = 0; i < occupiedCnt; i++) {
			st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			for (int j = startY; j < endY; j++) {
				for (int k = startX; k < endX; k++) {
					mapArr[j][k] = 1;
				}
			}
		}

		dfsStack = new Stack<Position>();
		curPosition = new Position();
		List<Integer> areaVolumes = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mapArr[i][j] == 0) {
					dfsStack.push(new Position(j, i));
				}
				while (!dfsStack.isEmpty()) {
					curPosition = dfsStack.pop();

					areaCnt++;
					mapArr[curPosition.getY()][curPosition.getX()] = 3;
					searchAround();
				}
				if (areaCnt != 0) {
					areaVolumes.add(areaCnt);
					areaCnt = 0;
				}
			}
		}
		Collections.sort(areaVolumes);
		
		Collections.sort(areaVolumes, (o1,o2)->o2-01);
		
		System.out.println(areaVolumes.size());

		for (int i = 0; i < areaVolumes.size(); i++) {
			System.out.print(areaVolumes.get(i) + " ");
		}
	}

	static void searchAround() {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		int curX = curPosition.getX();
		int curY = curPosition.getY();

		for (int i = 0; i < dx.length; i++) {
			if ((curX + dx[i]) >= 0 && (curY + dy[i]) >= 0 && (curX + dx[i]) < n && (curY + dy[i]) < m) {

				if (mapArr[curY + dy[i]][curX + dx[i]] == 0 && mapArr[curY + dy[i]][curX + dx[i]] != 2) {

					dfsStack.push(new Position(curX + dx[i], curY + dy[i]));
					mapArr[curY + dy[i]][curX + dx[i]] = 2;
				}
			}
		}

	}
}