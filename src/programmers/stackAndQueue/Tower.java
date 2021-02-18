package programmers.stackAndQueue;

public class Tower {
	
	public static void main(String[] args) {
		
		int[] heights = {6,9,5,7,4};
//		int[] heights = {3,9,9,3,5,7,2};
//		int[] heights = {1,5,3,6,7,6,5};
//		int[] heights = {1,1,2,1,1,2,1};
//		int[] heights = {5,1,1,1,1,1,1};
//		int[] heights = {5,1,1,1,4};
		
		solution(heights);
		
		int min_length = 1;
		int minLength = 1;

	}

	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		for (int hi = heights.length - 1; hi > 0; hi--) {

			for (int hj = hi - 1; hj >= 0; hj--) {
				if (heights[hi] < heights[hj]) {
					answer[hi] = hj+1;
					break;
				}
			}
		}
		
		for(int ai = 0; ai < heights.length; ai++) {
			System.out.print(answer[ai] + " ");
		}	
		return answer;
	}
}
