package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12100 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		StringTokenizer st;
		
		for(int boardI = 0; boardI < N; boardI++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int boardJ = 0; boardJ < N; boardJ++) {
				board[boardI][boardJ] = Integer.parseInt(st.nextToken());
			}
		}
		
		searchBoard(board, 0);
		
		
		System.out.println(maxPoint);
	}
	
	private static int maxPoint = 0;
	
	public static void searchBoard(int[][] board, int moveCount) {
		
		
		if(moveCount == 5) {
			int currentMaxPoint = 0;
			for(int boardI = 0; boardI < board.length; boardI++) {
				
				for(int boardJ = 0; boardJ < board[0].length; boardJ++) {
					currentMaxPoint = Math.max(currentMaxPoint, board[boardI][boardJ]);
				}
				
			}
			
			maxPoint = Math.max(maxPoint, currentMaxPoint);
			return;
		}
		
		boolean[][] isAdded = new boolean[board.length][board[0].length];
		int[][] copiedBoard = deepCopy2Dimension(board);
		
		// top
		for(int boardX = 0; boardX < board[0].length; boardX++) {
			for(int boardY = 1; boardY < board.length; boardY++) {
				
				int currentY = boardY;
				
				while(currentY > 0) {
					if(board[currentY - 1][boardX] == 0) {
						board[currentY - 1][boardX] = board[currentY][boardX];
						board[currentY][boardX] = 0;
						currentY--;
					} else if(board[currentY-1][boardX] == board[currentY][boardX] && !isAdded[currentY-1][boardX]) {
						isAdded[currentY-1][boardX] = true;
						board[currentY - 1][boardX] *= 2;
						board[currentY][boardX] = 0;
						break;
					} else
						break;
				}
				
			}
		}
		
		
		searchBoard(board, moveCount+1);
		board = deepCopy2Dimension(copiedBoard);
		isAdded = new boolean[board.length][board[0].length];
		
		// bottom
		
		for(int boardX = 0; boardX < board[0].length; boardX++) {
			for(int boardY = board.length-2; boardY >= 0; boardY--) {
				
				int currentY = boardY;
				
				while(currentY < board.length-1) {
					if(board[currentY+1][boardX] == 0) {
						board[currentY+1][boardX] = board[currentY][boardX];
						board[currentY][boardX] = 0;
						currentY++;
					} else if(board[currentY+1][boardX] == board[currentY][boardX] && !isAdded[currentY+1][boardX]) {
						isAdded[currentY+1][boardX] = true;
						board[currentY+1][boardX] *= 2;
						board[currentY][boardX] = 0;
						break;
					} else
						break;
				}
				
			}
		}
		
		searchBoard(board, moveCount+1);
		board = deepCopy2Dimension(copiedBoard);
		isAdded = new boolean[board.length][board[0].length];
		
		
		// left
		
		for(int boardY = 0; boardY < board.length; boardY++) {
			
			for(int boardX = 1; boardX < board[0].length; boardX++) {
				
				
				int currentX = boardX;
				
				while(currentX > 0) {
					
					if(board[boardY][currentX-1] == 0) {
						board[boardY][currentX-1] = board[boardY][currentX];
						board[boardY][currentX] = 0;
						currentX--;
					} else if(board[boardY][currentX-1] == board[boardY][currentX] && !isAdded[boardY][currentX-1]) {
						isAdded[boardY][currentX-1] = true;
						board[boardY][currentX-1] *= 2;
						board[boardY][currentX] = 0;
						break;
					} else
						break;
				}
			}
			
		}
		
		searchBoard(board, moveCount+1);
		board = deepCopy2Dimension(copiedBoard);
		isAdded = new boolean[board.length][board[0].length];
		
		// right
		
		for(int boardY = 0; boardY < board.length; boardY++) {
			
			for(int boardX = board[0].length - 2; boardX >= 0; boardX--) {
				
				
				int currentX = boardX;
				
				while(currentX < board[0].length-1) {
					
					if(board[boardY][currentX+1] == 0) {
						board[boardY][currentX+1] = board[boardY][currentX];
						board[boardY][currentX] = 0;
						currentX++;
					} else if(board[boardY][currentX+1] == board[boardY][currentX] && !isAdded[boardY][currentX+1]) {
						isAdded[boardY][currentX+1] = true;
						board[boardY][currentX+1] *= 2;
						board[boardY][currentX] = 0;
						break;
					} else
						break;
				}
			}
			
		}
		
		searchBoard(board, moveCount+1);
		
		
	}
	
	public static int[][] deepCopy2Dimension(int[][] source){
		
		int[][] copied = new int[source.length][];
		
		for(int copiedI = 0; copiedI < copied.length; copiedI++) {
			
			copied[copiedI] = new int[source[copiedI].length];
 			System.arraycopy(source[copiedI], 0, copied[copiedI], 0, copied[copiedI].length);
			
			
		}
		
		return copied;
		
		
	}
}
