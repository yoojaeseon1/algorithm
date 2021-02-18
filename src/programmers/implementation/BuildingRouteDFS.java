package programmers.implementation;


// 12 / 23 fail(all timeover)

public class BuildingRouteDFS {

	public static void main(String[] args) {

//		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

//		 int[][] board =
//		 {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};

		// int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};

		// int[][] board =
		// {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},/{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};

		
		int[][] board = new int[25][25];
		System.out.println(solution(board));

	}

	static int answer;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static int solution(int[][] board) {
		answer = Integer.MAX_VALUE;

		boolean[][] isVisited = new boolean[board.length][board[0].length];

		isVisited[0][0] = true;

		if (board[1][0] == 0)
			doDFS(board, isVisited, 0, 1, true, 100);

		if (board[0][1] == 0)
			doDFS(board, isVisited, 1, 0, false, 100);

		return answer;
	}

	public static void doDFS(int[][] board, boolean[][] isVisited, int currentX, int currentY, boolean beforeDirection,
			int cost) {

		if (currentX == board[0].length - 1 && currentY == board.length - 1) {
			answer = Math.min(answer, cost);

//			for (int visitedI = 0; visitedI < isVisited.length; visitedI++) {
//				for (int visitedJ = 0; visitedJ < isVisited.length; visitedJ++) {
//					System.out.print(isVisited[visitedI][visitedJ] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("cost : " + cost);
//			System.out.println("------------------");

			return;
		}

		for (int di = 0; di < dx.length; di++) {

			if (currentX + dx[di] >= 0 && currentX + dx[di] < board[0].length && currentY + dy[di] >= 0
					&& currentY + dy[di] < board.length && board[currentY + dy[di]][currentX + dx[di]] == 0
					&& !isVisited[currentY + dy[di]][currentX + dx[di]]) {
				isVisited[currentY + dy[di]][currentX + dx[di]] = true;

				if (beforeDirection && di >= 2) {
					doDFS(board, isVisited, currentX + dx[di], currentY + dy[di], false, cost + 600);
				} else if (!beforeDirection && di < 2) {
					doDFS(board, isVisited, currentX + dx[di], currentY + dy[di], true, cost + 600);
				} else
					doDFS(board, isVisited, currentX + dx[di], currentY + dy[di], beforeDirection, cost + 100);
				isVisited[currentY + dy[di]][currentX + dx[di]] = false;
			}
		}
	}
}
