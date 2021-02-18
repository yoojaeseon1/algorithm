package programmers.sorting;

import java.util.Arrays;

public class HIndex2 {

	public static void main(String[] args) {

//		 int[] citations = {3,0,6,1,5};
		// int[] citations = {0,1,3,6};
//		 int[] citations = {0,3,5,5,5,5,5,5,5,6};
//		 int[] citations = {0,1,3,5,5,5,6};
//		int[] citations = { 0, 1, 1, 1, 1, 1, 1, 1 };
		int[] citations = {3,3};

		System.out.println(solution(citations));

	}

	public static int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);
		
		for(int citationsCount = 1; citationsCount < citations[0]; citationsCount++) {
			if(citations.length >= citationsCount)
				answer = citationsCount;
		}

		for (int citationsI = 0; citationsI < citations.length; citationsI++) {
			if(citationsI > 0 && citations[citationsI-1] + 1 < citations[citationsI]){
				for(int beginNum = citations[citationsI-1]+1 ; beginNum < citations[citationsI]; beginNum++) {
					if(citations.length - citationsI >= beginNum) {
						answer = beginNum;
					}
				}
			}

			if (citations.length - citationsI >= citations[citationsI]) {
				answer = citations[citationsI];
				
			}
		}
		return answer;
	}

}
