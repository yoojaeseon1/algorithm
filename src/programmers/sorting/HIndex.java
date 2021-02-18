package programmers.sorting;

import java.util.Arrays;

public class HIndex {
	
	public static void main(String[] args) {
		
//		int[] citations = {3, 0, 6, 1, 5};
//		int[] citations = {3,0,6,1,5,6};
		int[] citations = {6,6,6,6};
//		
		System.out.println(solution(citations));

	}
	
    public static int solution(int[] citations) {

    	int answer = 0;
        int citationCount = 0;
        int paperCount = 0;
        
        Arrays.sort(citations);

        for (int ci = 0; ci < citations.length; ci++) {
        	citationCount = citations[ci];
            paperCount =  citations.length - ci;
            if (paperCount <= citationCount) {
                answer = paperCount;
                break;
            }
        }
        return answer;
    }
}
