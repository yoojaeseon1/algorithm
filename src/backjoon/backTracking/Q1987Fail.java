package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


// route 체크를 StringBuilder 또는 Map을 사용하는 것보다 boolean[26]로 각 알파벳의 인덱스를 아스키코드로 접근하는 것이 훨씬 빠르다.

public class Q1987Fail {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Object[]> boardStack = new Stack<>();

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int maxCount = 0;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		int curX, curY;
		int popCount = 0;

		String[][] board = new String[r][c];
		String tempInput;
		for (int i = 0; i < r; i++) {
			tempInput = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = tempInput.substring(j, j + 1);
			}
		}

		Object[] curPosition = new Object[3];
		StringBuilder movedRoute = new StringBuilder();
		// Map<String, Boolean> routeMap = new HashMap<>();
		movedRoute.append(board[0][0]);
		// movedRoute.append(board[0][0]);
		// routeMap.put(board[0][0], true);
		curPosition[0] = 0;
		curPosition[1] = 0;
		curPosition[2] = movedRoute;

		// curPosition[0] = 0;
		// curPosition[1] = 0;
		// curPosition[2] = routeMap;
		
		// Object[] nextPosition;
		// StringBuilder nextRoute;
		// StringBuilder maxRoute = new StringBuilder();
		// Map<String, Boolean> nextRouteMap = new HashMap<>();
		boardStack.push(curPosition);
		Object[] nextPosition;
		StringBuilder nextRoute;
		StringBuilder maxRoute = new StringBuilder();
		while (!boardStack.isEmpty()) {
			popCount++;
			curPosition = boardStack.pop();
			curX = (int) curPosition[0];
			curY = (int) curPosition[1];
			movedRoute = (StringBuilder) curPosition[2];
			// System.out.println("maxCount : " + maxCount);
			// System.out.println("movedRoute : " + movedRoute);
			if (movedRoute.length() > maxCount) { // 경로 확인용 나중에 제거
				maxCount = Math.max(maxCount, movedRoute.length()); // 이거 빼고 조건문
																	// 다 제거
				maxRoute.setLength(0);
				maxRoute.append(movedRoute);
			}

			for (int i = 0; i < 4; i++) {
				if (curX + dx[i] >= 0 && curX + dx[i] < c && curY + dy[i] >= 0 && curY + dy[i] < r) {
					if (movedRoute.indexOf(board[curY + dy[i]][curX + dx[i]]) == -1) {
						nextPosition = new Object[3];
						nextRoute = new StringBuilder();
						nextRoute.append(movedRoute);
						nextRoute.append(board[curY + dy[i]][curX + dx[i]]);
						nextPosition[0] = curX + dx[i];
						nextPosition[1] = curY + dy[i];
						nextPosition[2] = nextRoute;
						// nextPosition = new Object[3];
						// nextRouteMap = new HashMap<>();
						// nextRouteMap.putAll(routeMap);
						// nextRouteMap.put(board[curY + dy[i]][curX + dx[i]],
						// true);
						// nextPosition[0] = curX + dx[i];
						// nextPosition[1] = curY + dy[i];
						// nextPosition[2] = nextRouteMap;
						// System.out.println(nextRoute);
						// System.out.println("-------------");
						boardStack.push(nextPosition);
						
					}
				}
			}
		}

		System.out.println(maxCount);
		System.out.println(popCount);
		// System.out.println(maxRoute);

		// for(int i = 0; i < r; i++) {
		// for(int j = 0; j < c; j++) {
		// System.out.print(board[i][j] + " ");
		// }
		// System.out.println();
		// }
	}

}
