package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15684Retry {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		boolean[][] ladder = new boolean[H][N];

		if (M > 0) {
			for (int row = 1; row <= M; row++) {

				st = new StringTokenizer(br.readLine());
				int columnNumber = Integer.parseInt(st.nextToken()) - 1;
				int rowNumber = Integer.parseInt(st.nextToken()) - 1;
				ladder[columnNumber][rowNumber] = true;

			}
		}

		if (isStreaightLadder(ladder))
			System.out.println(0);
		else {
			int minLaidNewLow = 4;

			// System.out.println(isStreaightLadder(ladder));

			List<int[]> layableRows = new ArrayList<>();

			for (int ladderI = 0; ladderI < ladder.length; ladderI++) {
				for (int ladderJ = 0; ladderJ < ladder[ladderI].length; ladderJ++) {

					if (ladderJ == 0) {
						if (!ladder[ladderI][ladderJ]) {
							int[] row = { ladderJ, ladderI };
							layableRows.add(row);
						}
					} else if (ladderJ == ladder[ladderI].length - 1) {
						if (!ladder[ladderI][ladderJ - 1]) {
							int[] row = { ladderJ - 1, ladderI };
							layableRows.add(row);
						}
					} else {
						if (!ladder[ladderI][ladderJ] && !ladder[ladderI][ladderJ - 1]) {
							int[] row = { ladderJ, ladderI };
							layableRows.add(row);
						}
					}
				}
			}
			
			// using loop
			
			int layableRowSize = layableRows.size();
			
			List<int[]> selectedIndices = new ArrayList<>();
			
			for(int laybleI = 0; laybleI < layableRowSize; laybleI++) {
				
				if(minLaidNewLow == 1)
					break;
				
				int[] selectedFirstIndex = layableRows.get(laybleI);
				
				ladder[selectedFirstIndex[1]][selectedFirstIndex[0]] = true;
				
				if(isCorrectLadder(ladder) && isStreaightLadder(ladder))
					minLaidNewLow = 1;
				
				for(int laybleJ = laybleI+1; laybleJ < layableRowSize; laybleJ++) {
					
					if(minLaidNewLow <= 2)
						break;
					int[] selectedSecondIndex = layableRows.get(laybleJ);
					
					ladder[selectedSecondIndex[1]][selectedSecondIndex[0]] = true;
					if(isCorrectLadder(ladder) && isStreaightLadder(ladder))
						minLaidNewLow = 2;
					
					for(int laybleK = laybleJ+1; laybleK < layableRowSize; laybleK++) {
						
						if(minLaidNewLow <= 3)
							break;
						
						int[] selectedThirdIndex = layableRows.get(laybleK);
						ladder[selectedThirdIndex[1]][selectedThirdIndex[0]] = true;
						if(isCorrectLadder(ladder) && isStreaightLadder(ladder))
							minLaidNewLow = 3;
						
						ladder[selectedThirdIndex[1]][selectedThirdIndex[0]] = false;
					}
					ladder[selectedSecondIndex[1]][selectedSecondIndex[0]] = false;
				}
				ladder[selectedFirstIndex[1]][selectedFirstIndex[0]] = false;
			}
			
//			if(minLaidNewLow == 4)
//				System.out.println(-1);
//			else
//				System.out.println(minLaidNewLow);
			
			
			// using combination

//			for (int r = 1; r <= 3; r++) {
//				int[] selectedIndices = new int[r];
//				selectedRowIndices = new ArrayList<>();
//				doCombination(layableRows.size(), r, selectedIndices, 0, 0);
//
//				for (int selectedI = 0; selectedI < selectedRowIndices.size(); selectedI++) {
//
//					int[] selectedRowIndex = selectedRowIndices.get(selectedI);
//
//					for (int selectedJ = 0; selectedJ < r; selectedJ++) {
//						int[] selectedIndex = layableRows.get(selectedRowIndex[selectedJ]);
//						ladder[selectedIndex[1]][selectedIndex[0]] = true;
//					}
//
//					if (isCorrectLadder(ladder) && isStreaightLadder(ladder)) {
//						minLaidNewLow = r;
//						break;
//					}
//
//					for (int selectedJ = 0; selectedJ < r; selectedJ++) {
//						int[] selectedIndex = layableRows.get(selectedRowIndex[selectedJ]);
//						ladder[selectedIndex[1]][selectedIndex[0]] = false;
//					}
//
//				}
//				
//				if(minLaidNewLow < 4)
//					break;
//
//			}
			
			if(minLaidNewLow == 4)
				System.out.println(-1);
			else
				System.out.println(minLaidNewLow);
			
		}

	}

//	static List<int[]> selectedRowIndices;
//
//	public static void doCombination(int n, int r, int[] selectedIndices, int selectedIndex, int targetIndex) {
//
//		if (r == 0) {
//
//			int[] selectedRowIndex = new int[selectedIndex];
//
//			for (int si = 0; si < selectedIndex; si++) {
//				selectedRowIndex[si] = selectedIndices[si];
//			}
//
//			selectedRowIndices.add(selectedRowIndex);
//
////			System.out.println(Arrays.toString(selectedRowIndices.get(selectedRowIndices.size() - 1)));
//
//		} else if (targetIndex == n) {
//			return;
//
//		} else {
//			selectedIndices[selectedIndex] = targetIndex;
//
//			doCombination(n, r - 1, selectedIndices, selectedIndex + 1, targetIndex + 1);
//
//			doCombination(n, r, selectedIndices, selectedIndex, targetIndex + 1);
//		}
//	}

	public static boolean isStreaightLadder(boolean[][] ladder) {

		int rowLength = ladder[0].length;

		for (int ladderJ = 0; ladderJ < rowLength; ladderJ++) {

			int currentPosition = ladderJ;

			for (int ladderI = 0; ladderI < ladder.length; ladderI++) {

				if (currentPosition == 0) {

					if (ladder[ladderI][currentPosition])
						currentPosition++;

				} else if (currentPosition == rowLength) {
					if (ladder[ladderI][currentPosition - 1])
						currentPosition--;
				} else {
					if (ladder[ladderI][currentPosition])
						currentPosition++;
					else if (ladder[ladderI][currentPosition - 1])
						currentPosition--;
				}

				// if(ladderI == ladder.length - 1)
				// System.out.print(currentPosition + " ");
			}

			if (currentPosition != ladderJ)
				return false;

		}

		// for(int ladderJ = 0; ladderJ < ladder[0].length; ladderJ++)
		// System.out.print(ladder[0][ladderJ] + " ");

		return true;

	}

	public static boolean isCorrectLadder(boolean[][] ladder) {

		for (int ladderI = 0; ladderI < ladder.length; ladderI++) {
			for (int ladderJ = 1; ladderJ < ladder[ladderI].length - 1; ladderJ++) {
				if (ladder[ladderI][ladderJ] && ladder[ladderI][ladderJ - 1])
					return false;
			}
		}

		return true;

	}

}
