package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1100 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[][] chessBoard = new boolean[8][8];

		StringBuilder tempInput = new StringBuilder();
		int poneCount = 0;

		for (int i = 0; i < 8; i++) {
			tempInput.append(br.readLine());
			for (int j = 0; j < 8; j++) {
				if (tempInput.charAt(j) == 'F')
					chessBoard[i][j] = true;
			}
			tempInput.setLength(0);
		}

		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) { // even
				for (int j = 0; j < 8; j++) {
					if (j % 2 == 0 && chessBoard[i][j])
						poneCount++;
				}
			} else { // odd
				for (int j = 0; j < 8; j++) {
					if (j % 2 == 1 && chessBoard[i][j])
						poneCount++;
				}
			}
		}
		
		// divide even and odd

		// // even index
		//
		// for (int i = 0; i < 8; i += 2) {
		// for (int j = 0; j < 8; j++) {
		// if (j % 2 == 0 && chessBoard[i][j])
		// poneCount++;
		// }
		// }
		//
		// // odd index
		// for (int i = 1; i < 8; i += 2) {
		// for (int j = 0; j < 8; j++) {
		// if (j % 2 == 1 && chessBoard[i][j])
		// poneCount++;
		// }
		// }

		System.out.println(poneCount);

	}

}
