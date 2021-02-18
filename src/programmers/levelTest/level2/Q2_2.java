package programmers.levelTest.level2;

import java.util.Arrays;
import java.util.Collections;

public class Q2_2 {

	public static void main(String[] args) {
		
//		int[] citations = {3, 0, 6, 1, 5};
//		int[] citations = {15,12,10,8,7,6,2,1};
//		int[] citations = {15,12,10,8,7,7,7,2,1};
		int[] citations = {2,2,2,2,2};
//		int[] citations = {3,3,2,1,1,1,1,1,1};
//		int[] citations = {5,5,5,5};
//		int[] citations = {0,0,0,0,0};
		
		System.out.println(solution(citations));

	}
	
    public static int solution(int[] citations) {
    	
    	Integer[] boxedCitations = new Integer[citations.length];
    	
    	for(int citationsI = 0; citationsI < citations.length; citationsI++) 
    		boxedCitations[citationsI] = citations[citationsI];
    		
    	Arrays.sort(boxedCitations, Collections.reverseOrder());
    	
    	for(int citationsI = 0; citationsI < citations.length - 1; citationsI++){
    		
    		int currentPaper = boxedCitations[citationsI];
    		
    		if(currentPaper != boxedCitations[citationsI+1] && currentPaper <= citationsI+1)
    			return boxedCitations[citationsI];
    		
    	}
    	
    	return boxedCitations.length;
    }

}
