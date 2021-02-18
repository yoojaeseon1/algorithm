package backjoon.BFS;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import backjoon.Position;

public class Q7576 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int oneCount = 0;
		int notAvailable = 0;

		int[][] fieldArr = new int[n][m];
		Queue<Position> fieldQueue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				fieldArr[i][j] = Integer.parseInt(st.nextToken());
				if (fieldArr[i][j] == 1) {
					fieldQueue.add(new Position(j,i));
					oneCount++;
				} else if(fieldArr[i][j] == -1) {
					notAvailable++;
				}
				// System.out.print(fieldArr[i][j] + " ");
			}
			// System.out.println();
		}
		
		int available = (m*n) - notAvailable;
//		System.out.println("available : " + available);
		int newOneCount = 0;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int maturedCount = oneCount;
		int dayCount = -1;
		Position curPosition;
		int curX, curY;
		
		while(!fieldQueue.isEmpty()) {
			for(int i = 0; i < oneCount; i++) {
				curPosition = fieldQueue.poll();
				for(int j = 0; j < 4; j++) {
					curX = curPosition.getX() + dx[j];
					curY = curPosition.getY() + dy[j];
//					System.out.println("curX : " + curX);
//					System.out.println("curY : " + curY);
					if(curX >= 0 && curX < m && curY >= 0 && curY < n) {
						if(fieldArr[curY][curX] == 0) {
							fieldQueue.add(new Position(curX, curY));
							fieldArr[curY][curX] = 1;
							newOneCount++;
						}
					}
				}
			}
			maturedCount += newOneCount;
			oneCount = newOneCount;
			newOneCount = 0;
			dayCount++;
		}
		
		/*System.out.println("available : " + available);
		System.out.println("maturedCount : " + maturedCount);*/
		if(maturedCount == available) {
			System.out.println(dayCount);			
		} else {
			System.out.println(-1);
		}
		

	}
}