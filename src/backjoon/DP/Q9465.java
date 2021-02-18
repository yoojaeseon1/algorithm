package backjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseCount = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int cases = 0; cases < caseCount; cases++) {
			
			int caseLength = Integer.parseInt(br.readLine());
			
			int[][] stickers = new int[2][caseLength];
			
			st = new StringTokenizer(br.readLine());
			for(int si = 0; si < stickers[0].length; si++) {
				stickers[0][si] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int si = 0; si < stickers[0].length; si++) {
				stickers[1][si] = Integer.parseInt(st.nextToken());
			}

			int[][] selectedStickers = new int[2][caseLength];
			
			selectedStickers[0][0] = stickers[0][0];
			selectedStickers[1][0] = stickers[1][0];
			selectedStickers[0][1] = stickers[0][1] + stickers[1][0];
			selectedStickers[1][1] = stickers[1][1] + stickers[0][0];
			
			for(int si = 2; si < selectedStickers[0].length; si++){
				
				selectedStickers[0][si] += (stickers[0][si] + Math.max(selectedStickers[1][si-1],selectedStickers[1][si-2]));
				selectedStickers[1][si] += (stickers[1][si] + Math.max(selectedStickers[0][si-1],selectedStickers[0][si-2]));
			}
			
			
			System.out.println(Math.max(selectedStickers[0][selectedStickers[0].length-1], selectedStickers[1][selectedStickers[1].length-1]));
			
		}
	}

}
