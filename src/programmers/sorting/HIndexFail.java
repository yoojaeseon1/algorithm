package programmers.sorting;

import java.util.Arrays;


// some test cases fail

public class HIndexFail {

	public static void main(String[] args) {
		
//		int[] citations = {3, 0, 6, 1, 5};
		int[] citations = {3,0,6,1,5,6};
//		int[] citations = {6,6,6,6};
//		
		System.out.println(solution(citations));

	}

	public static int solution(int[] citations) {
		int answer = -1;

		Arrays.sort(citations);

		int maxCitationCount = citations[citations.length - 1];

		int[] citationCounts = new int[maxCitationCount + 1];
		System.out.println("maxCitationCount : "+maxCitationCount);
		citationCounts[0] = citations.length;
		int currentCitationCount = 1;
		int beforeCheckIndex = 0;

		for (int ci = 0; ci < citations.length - 1; ci++) {
				System.out.println("ci : "+ci);

			if (citations[ci] == citations[ci + 1])
				currentCitationCount++;
			else {
				System.out.println("into else");
				for (int cci = beforeCheckIndex + 1; cci <= citations[ci+1]; cci++) {
					citationCounts[cci] = citationCounts[beforeCheckIndex] - currentCitationCount;
//					System.out.println("cci : " + cci);
//					System.out.println("citationCount : " + citationCounts[cci]);
					if(cci >= citationCounts[cci]) {
						answer = citationCounts[cci];
						break;
					}
				}
				if(answer >= 0) break;
				currentCitationCount = 1;
				beforeCheckIndex = citations[ci+1];
//				System.out.println("------------");
			}
		}
		
		if(citationCounts[maxCitationCount] == 0 && answer == -1) {
//			System.out.println("citationCounts[maxCitationCount] == 0");
//			System.out.println("beforeIndex : " + beforeCheckIndex);
//			System.out.println("currentCitationCount : " + currentCitationCount);
			for (int cci = beforeCheckIndex + 1; cci <= maxCitationCount; cci++) {
				citationCounts[cci] = currentCitationCount;
//				System.out.println("cci : " + cci);
//				System.out.println("citationCount : " + citationCounts[cci]);
				if(cci >= citationCounts[cci]) {
					answer = citationCounts[cci];
					break;
				}
			}
		}
		
//		System.out.println("loop end----------");
//		
		for(int cci = 0; cci < citationCounts.length; cci++) {
			System.out.println(citationCounts[cci]);
		}
		System.out.println("-------");

		return answer;
	}

}
