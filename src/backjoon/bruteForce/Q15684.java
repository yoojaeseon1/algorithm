package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15684 {

	static int maxLaidRow;

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

		
		for(maxLaidRow = 0; maxLaidRow <= 3; maxLaidRow++) {
			
			
			layRowLine(ladder, 0,0,0);
			
			if(isFinished)
				break;
		}
		
		System.out.println(isFinished ? maxLaidRow : -1);

	}
	

	static boolean isFinished;
	
	public static void layRowLine(boolean[][] ladder, int x, int y,  int layCount) {
		
		if(isFinished)
			return;
		
		if (isStreaightLadder(ladder)) {
			isFinished = true;
			return;
		}
		
		if(maxLaidRow == layCount) 
			return;
		
		
		
		for(int ladderI = 0; ladderI < ladder.length; ladderI++) {
			
			for(int ladderJ = 0; ladderJ < ladder[ladderI].length-1; ladderJ++) {
				
				if(ladderJ == 0) {
					if(!ladder[ladderI][ladderJ] && !ladder[ladderI][ladderJ+1]) {
						ladder[ladderI][ladderJ] = true;
						layRowLine(ladder, ladderJ, ladderI, layCount+1);
						ladder[ladderI][ladderJ] = false;
					}
				} else {
					if(!ladder[ladderI][ladderJ] && !ladder[ladderI][ladderJ+1] && !ladder[ladderI][ladderJ-1]) {
						ladder[ladderI][ladderJ] = true;
						layRowLine(ladder, ladderJ, ladderI, layCount+1);
						ladder[ladderI][ladderJ] = false;
					}
				}
			}
		}
	}

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
			}

			if (currentPosition != ladderJ)
				return false;

		}

		return true;

	}
}
