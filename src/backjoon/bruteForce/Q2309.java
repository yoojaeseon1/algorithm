package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {
	
	static int[] answer;
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int sumHeight = 0;
		int[] heights = new int[9];
		for(int heightsI = 0; heightsI < 9; heightsI++) {
			int height = Integer.parseInt(br.readLine());
			heights[heightsI] = height;
			sumHeight += height;
		}
		
		answer = new int[7];
		
		selectPerson(heights, sumHeight);
		
		Arrays.sort(answer);
		
		for(int answerI = 0; answerI < answer.length; answerI++)
			System.out.println(answer[answerI]);
		
		
	}
	
	
	public static void selectPerson(int[] heights, int sumHeight) {
		
		for(int heightsI = 0; heightsI < heights.length; heightsI++) {
			
			sumHeight -= heights[heightsI];
			
			for(int heightsJ = heightsI+1; heightsJ < heights.length;heightsJ++) {
				
				sumHeight -= heights[heightsJ];
				
				if(sumHeight == 100) {
					int answerI = 0;
					
					for(int heightK = 0; heightK < heights.length; heightK++) {
						if(!(heightK == heightsI || heightK == heightsJ))
							answer[answerI++] = heights[heightK];
					}
					
					return;
					
					
				}
				sumHeight += heights[heightsJ];
			}
			sumHeight += heights[heightsI];
		}
		
	}

}
