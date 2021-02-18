package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import backjoon.Position;

public class Q14502 {
	
	static List<int[][]> coordiList = new ArrayList<>();
	static int[][] field;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		field = new int[n][m];
		int[][] tempField = new int[n][m];
		int safeCount = 0;
//		Queue<Position> fieldQueue = new LinkedList<>();
		Stack<Position> fieldStack = new Stack<>();
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int maxSafeCount, tempSafeCount;
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if(field[i][j] == 0) {
					safeCount++;
				}
				if(field[i][j] == 2) {
					fieldStack.push(new Position(j, i));
				}
			}
		}
//		System.out.println("safe count : " + safeCount);
		maxSafeCount = 0;
		tempSafeCount = safeCount - 3;
		int[][] safeArr = new int[safeCount][];
		int safeIndex = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(field[i][j] == 0) {
					safeArr[safeIndex] = new int[2];
					safeArr[safeIndex][0] = i;
					safeArr[safeIndex][1] = j;
/*					System.out.print(safeArr[safeIndex][0] + " ");
					System.out.println(safeArr[safeIndex][1]);*/
					safeIndex++;
				}
			}
		}
		int[] combArr = new int[safeArr.length];
		doCombination(combArr, combArr.length, 3, 0, 0, safeArr);
		
		int[][] oneCoordi = new int[3][2];
		int curX, curY;
		Position curPosition;
		Stack<Position> tempStack;
		
		for(int i = 0; i < coordiList.size(); i++) {
//		for(int i = 0; i < 5; i++) {
			tempStack = (Stack<Position>) fieldStack.clone();
			tempField = deepCopy(field);
			oneCoordi = deepCopy(coordiList.get(i));
//			System.out.println("i : " + i);
/*			System.out.print(oneCoordi[0][0] + " " + oneCoordi[0][1] + " ");
			System.out.print(oneCoordi[1][0] + " " + oneCoordi[1][1] + " ");
			System.out.println(oneCoordi[2][0] + " " + oneCoordi[2][1]);*/
			tempField[oneCoordi[0][0]][oneCoordi[0][1]] = 1;
			tempField[oneCoordi[1][0]][oneCoordi[1][1]] = 1;
			tempField[oneCoordi[2][0]][oneCoordi[2][1]] = 1;
			
			while(!tempStack.isEmpty()) {
				curPosition = tempStack.pop();
				curX = curPosition.getX();
				curY = curPosition.getY();
				
				for(int j = 0; j < dx.length; j++) {
					if(curX + dx[j] >= 0 && curX + dx[j] < m && curY + dy[j] >= 0 && curY + dy[j] < n) {
						if(tempField[curY + dy[j]][curX + dx[j]] == 0) {
							tempStack.push(new Position(curX+dx[j], curY+dy[j]));
							tempField[curY + dy[j]][curX + dx[j]] = 2;
							tempSafeCount--;
						}
					}
				}
			}
			maxSafeCount = Math.max(maxSafeCount, tempSafeCount);
			tempSafeCount = safeCount - 3;
			
/*			for(int k = 0; k < n; k++) {
				for(int l = 0; l < m; l++) {
					System.out.print(tempField[k][l] + " ");
				}
				System.out.println();
				
			}
			System.out.println("max count : " + maxSafeCount);
			System.out.println("temp safe count : " + tempSafeCount);
			System.out.println("-----------------");*/
		}
		
		System.out.println(maxSafeCount);
	}
	
	public static void doCombination(int[] combArr, int n, int r, int index, int target, int[][] arr) {
		
//		System.out.println("=> " + n + " " + r + " " + index + " " + target);
		
		if(r == 0) {
			int[][] tempArr = new int[index][2];
			for(int i = 0; i < index; i++) {
//				System.out.print(arr[combArr[i]] + " ");
				tempArr[i][0] = arr[combArr[i]][0];
				tempArr[i][1] = arr[combArr[i]][1];
//				System.out.println("i : " + i);
//				System.arraycopy(arr[combArr[i]], 0, tempArr[i], 0, tempArr.length);
			}
			coordiList.add(tempArr);
//			System.out.println();
			
		} else if(target == n) {
			return;
		} else {
			
			combArr[index] = target;
			
			// 戮묒� 寃쎌슦
			doCombination(combArr, n, r - 1, index + 1, target + 1, arr);
			
			// �븞 戮묒� 寃쎌슦
			doCombination(combArr, n, r, index, target + 1, arr);
			
		}
	}
	
	public static int[][] deepCopy(int[][] original) {
		if(original == null) return null;
		
		int[][] result = new int[original.length][original[0].length];
		
		for(int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, result[i], 0, original[0].length);
		}
		
		return result;
	}
}

// checking combination
/*		for(int i = 0; i < coordiList.size(); i++) {
System.out.print(coordiList.get(i)[0][0] + " ");
System.out.print(coordiList.get(i)[0][1] + " ");
System.out.print(coordiList.get(i)[1][0] + " ");
System.out.print(coordiList.get(i)[1][1] + " ");
System.out.print(coordiList.get(i)[2][0] + " ");
System.out.println(coordiList.get(i)[2][1]);
}*/
