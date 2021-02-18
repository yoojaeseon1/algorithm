package backjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1697 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int curPosition;
		int result = 0;
		int tryCnt = 0;

		int[] coordinate = new int[100001];
//		Queue<Integer> positionQueue = new LinkedList<Integer>();
		 Stack<Integer> positionStack = new Stack<Integer>();

//		positionQueue.offer(n);
		 positionStack.push(n);
		if (n != k) {
//			while (!positionQueue.isEmpty()) {
				 while (!positionStack.isEmpty()) {
//				curPosition = positionQueue.poll();
				 curPosition = positionStack.pop();
				 System.out.println("try count : " + tryCnt);
				 System.out.println("current position : " + curPosition);
				 
				tryCnt++;
				
//				if(curPosition == 18) {
//					System.out.println("16's count : " + coordinate[18]);
//					break;
//				}
				if (curPosition >= 1 && (coordinate[curPosition - 1]) == 0) {
					if ((curPosition - 1) == k) {
						result = coordinate[curPosition] + 1;
						break;
					} else {
						coordinate[curPosition - 1] = coordinate[curPosition] + 1;
//						positionQueue.offer(curPosition - 1);
						 positionStack.push(curPosition - 1);
						 System.out.println("-1 : " + (curPosition - 1));
					}
				}

				if (curPosition + 1 <= 100000 && (coordinate[curPosition + 1]) == 0) {
					if ((curPosition + 1) == k) {
						result = coordinate[curPosition] + 1;
						break;
					} else {
						coordinate[curPosition + 1] = coordinate[curPosition] + 1;
//						positionQueue.offer(curPosition + 1);
						 positionStack.push(curPosition + 1);
						 System.out.println("+1 : " + (curPosition + 1));
					}
				}

				if (curPosition * 2 <= 100000 && (coordinate[curPosition * 2]) == 0) {
					if ((curPosition * 2) == k) {
						result = coordinate[curPosition] + 1;
						break;
					} else {
						coordinate[curPosition * 2] = coordinate[curPosition] + 1;
//						positionQueue.offer(curPosition * 2);
						 positionStack.push(curPosition * 2);
						 System.out.println("*2 : " + (curPosition * 2));
					}
				}
				System.out.println("------------------");
				
//				if(tryCnt == 5) {
//					break;
//				}
			}
		} else {
			result = 0;
		}
		System.out.println(result);
		
		System.out.println("10 : " + coordinate[10]);
		System.out.println("9 : " + coordinate[9]);
		System.out.println("18 : " + coordinate[18]);
		
		for(int i = 0; i < coordinate.length; i++) {
			if(coordinate[i] == 3) {
				System.out.println("i : " +  i);
			}
		}
		
		System.out.println("try count : " + tryCnt); // if 5 17, BFS : 14, DFS : 99985
	}
}
