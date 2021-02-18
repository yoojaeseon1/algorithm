package backjoon.BFS;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import backjoon.Position;

public class Q7562 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int caseCount = Integer.parseInt(br.readLine());
		int arrSize;
		int curX, curY;
		boolean endCheck;
		int[][][] fields = new int[caseCount][][];
		Position[][] startEnd = new Position[caseCount][2];
		Queue<Position> fieldQueue;
		Position curPosition;
		int[] dx = {1,2,2,1,-1,-2,-2,-1};
		int[] dy = {-2,-1,1,2,2,1,-1,-2};
		
		
		for(int i = 0; i < caseCount; i++) {
			arrSize = Integer.parseInt(br.readLine());
			fields[i] = new int[arrSize][arrSize];
			st = new StringTokenizer(br.readLine());
			startEnd[i][0] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			startEnd[i][1] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		for(int i = 0; i < caseCount; i++) {
			endCheck = false;
			if(startEnd[i][0].getX() == startEnd[i][1].getX() && startEnd[i][0].getY() == startEnd[i][1].getY()) {
				System.out.println(0);
				continue;
			}
			
			fieldQueue = new LinkedList<>();
			
			fields[i][startEnd[i][0].getY()][startEnd[i][0].getX()] = 1; // starting position
			fields[i][startEnd[i][1].getY()][startEnd[i][1].getX()] = -1; // end position
			
			fieldQueue.add(new Position(startEnd[i][0].getX(), startEnd[i][0].getY()));
			
			while(!fieldQueue.isEmpty() && !endCheck) {
				curPosition = fieldQueue.poll();
				curX = curPosition.getX();
				curY = curPosition.getY();
				
				for(int j = 0; j < dx.length; j++) {
					if(curX + dx[j] >= 0 && curY + dy[j] >= 0 && curX + dx[j] < fields[i].length && curY + dy[j] < fields[i].length) {
						if(fields[i][curY + dy[j]][curX + dx[j]] == -1) {
							System.out.println(fields[i][curY][curX]);
							endCheck = true;
							break;
						}
						
						if(fields[i][curY + dy[j]][curX + dx[j]] == 0) {
							
							fields[i][curY + dy[j]][curX + dx[j]] = fields[i][curY][curX] + 1;
							fieldQueue.add(new Position(curX+dx[j], curY+dy[j]));
						}
					}
				}
			}
		}
	}
}
