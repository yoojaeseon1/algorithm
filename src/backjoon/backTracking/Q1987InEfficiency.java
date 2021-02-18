package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// System.arraycopy()가 시간을 많이 잡아 먹는다.

public class Q1987InEfficiency {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<NewPosition> boardStack = new Stack<>();

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int maxCount = 0;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		int curX, curY;
		int popCount = 0;

		char[][] board = new char[r][c];
		String tempInput;
		for (int i = 0; i < r; i++) {
			tempInput = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = tempInput.charAt(j);
			}
		}

		NewPosition curPosition;

		boolean[] visited = new boolean[26];

		visited[board[0][0] - 'A'] = true;
		curPosition = new NewPosition(0, 0, 1, visited);

		boardStack.push(curPosition);
		boolean[] nextVisited = new boolean[26];
		NewPosition nextPosition;
		while (!boardStack.isEmpty()) {
			popCount++;
			curPosition = new NewPosition();
			curPosition = boardStack.pop();
			curX = curPosition.getX();
			curY = curPosition.getY();
			visited = new boolean[26];
			System.arraycopy(curPosition.getVisited(), 0, visited, 0, visited.length);

			maxCount = Math.max(maxCount, curPosition.getVisitedCount());
			for (int i = 0; i < 4; i++) {
				if (curX + dx[i] >= 0 && curX + dx[i] < c && curY + dy[i] >= 0 && curY + dy[i] < r) {
					if (!visited[board[curY + dy[i]][curX + dx[i]] - 'A']) {
						nextVisited = new boolean[26];
						System.arraycopy(visited, 0, nextVisited, 0, visited.length);
						nextVisited[board[curY + dy[i]][curX + dx[i]] - 'A'] = true;
						nextPosition = new NewPosition(curX + dx[i], curY + dy[i], curPosition.getVisitedCount() + 1,
								nextVisited);
						boardStack.push(nextPosition);
					}
				}
			}
		}

		System.out.println(maxCount);
		System.out.println(popCount);
	}
}

class NewPosition {

	private int x;
	private int y;
	private int visitedCount;
	private boolean[] visited = new boolean[26];

	public NewPosition() {
		// TODO Auto-generated constructor stub
	}

	public NewPosition(int x, int y, int visitedCount, boolean[] visited) {
		this.x = x;
		this.y = y;
		this.visitedCount = visitedCount;
		System.arraycopy(visited, 0, this.visited, 0, visited.length);
		;
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

	public boolean[] getVisited() {
		return visited;
	}

	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}

	public int getVisitedCount() {
		return visitedCount;
	}

	public void setVisitedCount(int visitedCount) {
		this.visitedCount = visitedCount;
	}
}