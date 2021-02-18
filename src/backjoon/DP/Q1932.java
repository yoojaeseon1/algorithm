package backjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n][n];
		int tokenCount;
		int maxSum = 0; 
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			tokenCount = st.countTokens();
			for(int j = 0; j < tokenCount; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 1; i < n; i++) {
			
			graph[i][0] += graph[i-1][0];
			graph[i][i] += graph[i-1][i-1];
			
			for(int j = 1; j < i; j++) {
				graph[i][j] += Math.max(graph[i-1][j], graph[i-1][j-1]);
			}
			
		}
		
		for(int i = 0; i < n; i++) {
			maxSum = Math.max(maxSum, graph[n-1][i]);
		}
		System.out.println(maxSum);
		

		// memory overflow - using DFS
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Stack<int[]> graphStack = new Stack<>();
//		StringTokenizer st;
//		int n = Integer.parseInt(br.readLine());
//		int[] curValues = new int[n];
//		int[][] graph = new int[n][n];
//		int[] curPosition = new int[2];
//		int maxSum = 0;
//		int tempSum = 0;
//		int curValue;
//		int beforeLevel;
//		int tokenCount;
//		int currentX, currentY;
//
//		for (int i = 0; i < graph.length; i++) {
//			st = new StringTokenizer(br.readLine());
//			tokenCount = st.countTokens();
//			for (int j = 0; j < tokenCount; j++) {
//				graph[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		curValues[0] = graph[0][0];
//		curPosition[0] = 0;
//		curPosition[1] = 0;
//		beforeLevel = -1;
//		graphStack.push(curPosition);
//
//		while (!graphStack.isEmpty()) {
//			System.arraycopy(graphStack.pop(), 0, curPosition, 0, curPosition.length);
//			currentX = curPosition[0];
//			currentY = curPosition[1];
//			curValue = graph[currentY][currentX];
//			if (currentY == beforeLevel) {
//				tempSum -= curValues[beforeLevel];
//			} else if (currentY < beforeLevel) {
//				for (int i = beforeLevel; i >= currentY; i--) {
//					tempSum -= curValues[i];
//				}
//			}
//
//			if (currentY < n - 1) {
//
//				curPosition = new int[2];
//				curPosition[0] = currentX;
//				curPosition[1] = currentY + 1;
//				graphStack.push(curPosition);
//
//				curPosition = new int[2];
//				curPosition[0] = currentX + 1;
//				curPosition[1] = currentY + 1;
//				graphStack.push(curPosition);
//
//				tempSum += curValue;
//				curValues[currentY] = curValue;
//			} else {
//				tempSum += curValue;
//				curValues[currentY] = curValue;
//				maxSum = Math.max(maxSum, tempSum);
//			}
//			beforeLevel = currentY;
//			System.out.println("--------------");
//		}
//
//		System.out.println(maxSum);

	}
}
