package programmers.DP;

public class CardGame {

	public static void main(String[] args) {

		int[] left = { 3, 2, 5 };

		int[] right = { 2, 4, 1 };

		System.out.println(solution(left, right));

	}


	public static int solution(int[] left, int[] right) {
		
		int[][] cache = new int[left.length+1][left.length+1];
		
		for(int leftI = 0; leftI < left.length; leftI++) {
			for(int rightI = 0; rightI < right.length; rightI++) {
				
				if(left[leftI] > right[rightI] && cache[leftI][rightI+1] < cache[leftI][rightI] + right[rightI])
					cache[leftI][rightI+1] = cache[leftI][rightI] + right[rightI];
				
				if(cache[leftI][rightI] > cache[leftI+1][rightI])
					cache[leftI+1][rightI] = cache[leftI][rightI];
				
				if(cache[leftI][rightI] > cache[leftI+1][rightI+1])
					cache[leftI+1][rightI+1] = cache[leftI][rightI];
				
			}
		}
		
		
		int maxPoint = 0;
		
		for(int cacheI = 0; cacheI < cache.length; cacheI++) {
			
			maxPoint = Math.max(maxPoint, cache[cacheI][cache.length-1]);
			maxPoint = Math.max(maxPoint, cache[cache.length-1][cacheI]);
		}
		return maxPoint;
	}

}
