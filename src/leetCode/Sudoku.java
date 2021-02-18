package leetCode;

public class Sudoku {
	
	public static void main(String[] args) {

//		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
//				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
//				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
//				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
//				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		
		char[][] board = 	{
				  {'8','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		System.out.println(isValidSudoku(board));

	}

	public static boolean isValidSudoku(char[][] board) {

		boolean[] isUsed = new boolean[10];

		for (int boardI = 0; boardI < board.length; boardI++) {
			isUsed = new boolean[10];
			// System.out.println("boardI : " + boardI);
			for (int boardJ = 0; boardJ < board[boardI].length; boardJ++) {
				// System.out.println("boardJ : " + boardJ);
				int positionNumber = (int) board[boardI][boardJ] - 48;
				if (positionNumber > 0 && positionNumber < 10) {

					if (!isUsed[positionNumber])
						isUsed[positionNumber] = true;
					else
						return false;
				}

			}
			// System.out.println("------");
		}
		for (int boardI = 0; boardI < board.length; boardI++) {
			isUsed = new boolean[10];
			for (int boardJ = 0; boardJ < board[boardI].length; boardJ++) {
				int positionNumber = (int) board[boardJ][boardI] - 48;
				if (positionNumber > 0 && positionNumber < 10) {
					if (!isUsed[positionNumber])
						isUsed[positionNumber] = true;
					else {
						return false;
					}
				}
			}
			// System.out.println("------");
		}

		int[][] blockNumber = { { 0, 0 }, { 0, 3 }, { 0, 6 }, { 3, 0 }, { 3, 3 }, { 3, 6 }, { 6, 0 }, { 6, 3 },
				{ 6, 6 } };

		for (int blockI = 0; blockI < blockNumber.length; blockI++) {
			int startI = blockNumber[blockI][0];
			int startJ = blockNumber[blockI][1];
			isUsed = new boolean[10];
			for (int boardI = startI; boardI < startI + 3; boardI++) {
				for (int boardJ = startJ; boardJ < startJ + 3; boardJ++) {
					int positionNumber = (int) board[boardI][boardJ] - 48;
					if (positionNumber > 0 && positionNumber < 10) {
						if (!isUsed[positionNumber])
							isUsed[positionNumber] = true;
						else {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
