package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13460 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];

		StringBuilder line = new StringBuilder();
		int rX = -1;
		int rY = -1;
		int bX = -1;
		int bY = -1;

		for (int boardI = 0; boardI < board.length; boardI++) {

			line.append(br.readLine());

			for (int boardJ = 0; boardJ < board[boardI].length; boardJ++) {
				board[boardI][boardJ] = line.charAt(boardJ);
				if (board[boardI][boardJ] == 'R') {
					rX = boardJ;
					rY = boardI;
				} else if (board[boardI][boardJ] == 'B') {
					bX = boardJ;
					bY = boardI;
				}
				// else if(board[boardI][boardJ] == 'O')
				// System.out.println(boardJ + ", " + boardI);
			}
			line.setLength(0);
		}

		// System.out.println("Red : (" + rX + ", " + rY + ")");
		// System.out.println("Blue : (" + bX + ", " + bY + ")");

		searchBoard(board, rX, rY, bX, bY, 0);

		if (minMoveCount == 11)
			System.out.println(-1);
		else
			System.out.println(minMoveCount);

		// for(int boardI = 0; boardI < board.length; boardI++) {
		//
		// for(int boardJ = 0; boardJ < board[boardI].length; boardJ++) {
		// System.out.print(board[boardI][boardJ] + "\t");
		// }
		// System.out.println();
		// }

	}

	static int minMoveCount = 11;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void searchBoard(char[][] board, int rX, int rY, int bX, int bY, int moveCount) {

		// if(board[rY][rX] == 'O' && (rX != bX || rY != bY)) {

		// if(moveCount > 3)
		// return;
		// if (board[rY][rX] == 'O' && !(rX == bX && rY == bY)) {
		if (board[rY][rX] == 'O' && board[bY][bX] != 'O') {
//			System.out.println("Red : (" + rX + ", " + rY + ")");
//			System.out.println("Blue : (" + bX + ", " + bY + ")");
//			System.out.println("moveCount : " + moveCount);
//			System.out.println("---------");
			minMoveCount = Math.min(minMoveCount, moveCount);
			return;
		}

		if (moveCount == 10 ||  board[bY][bX] == 'O')
			return;

		int beforeMoveRX = rX;
		int beforeMoveRY = rY;
		int beforeMoveBX = bX;
		int beforeMoveBY = bY;

		for (int di = 0; di < 4; di++) {

			while (true) {
//				System.out.println("1");
				if (board[rY + dy[di]][rX + dx[di]] == '#')
					break;
				else if (board[rY + dy[di]][rX + dx[di]] == 'O') {
					rX += dx[di];
					rY += dy[di];
					break;
				} else {
					rX += dx[di];
					rY += dy[di];
				}
			}

			while (true) {
//				System.out.println("2");
				if (board[bY + dy[di]][bX + dx[di]] == '#')
					break;
				else if (board[bY + dy[di]][bX + dx[di]] == 'O') {
					bX += dx[di];
					bY += dy[di];
					break;
				} else {
					bX += dx[di];
					bY += dy[di];
				}
			}

			if (rX == bX && rY == bY && board[rY][rX] != 'O') {
//				System.out.println("3");
				if (di == 0) {
					if (beforeMoveRY > beforeMoveBY)
						rY++;
					else
						bY++;
				} else if (di == 1) {
					if (beforeMoveRX < beforeMoveBX)
						rX--;
					else
						bX--;
				} else if (di == 2) {
					if (beforeMoveRY < beforeMoveBY)
						rY--;
					else
						bY--;
				} else {
					if (beforeMoveRX > beforeMoveBX)
						rX++;
					else
						bX++;
				}
			}
//			System.out.println("------");
			searchBoard(board, rX, rY, bX, bY, moveCount + 1);

			rX = beforeMoveRX;
			rY = beforeMoveRY;
			bX = beforeMoveBX;
			bY = beforeMoveBY;

		}

	}

}
