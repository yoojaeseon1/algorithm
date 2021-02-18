package programmers.levelTest.level2;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Q2_1 {

	public static void main(String[] args) {
		
//		int[] citations = {3, 0, 6, 1, 5};
//		int[] citations = {15,12,10,8,7,6,2,1};
//		int[] citations = {15,12,10,8,7,7,7,2,1};
		int[] citations = {2,2,2,2,2};
		
		System.out.println(solution(citations));

	}
	
    public static int solution(int[] citations) {
    	
        
        Map<Integer, Integer> paperToCitation = new TreeMap<>(Collections.reverseOrder());
        
        for(int citationsI = 0; citationsI < citations.length; citationsI++) {
        	
        	int numCitation = paperToCitation.getOrDefault(citations[citationsI], 0);
        	
        	if(numCitation == 0)
        		paperToCitation.put(citations[citationsI], 1);
        	else
        		paperToCitation.put(citations[citationsI], numCitation+1);

        }
        
        Iterator<Entry<Integer,Integer>> citationIter = paperToCitation.entrySet().iterator();
        int sumBeforeCitation = 0;
        while(citationIter.hasNext()) {
        	
        	Entry<Integer, Integer> citationEntry = citationIter.next();
        	int numCitation = citationEntry.getKey();
        	System.out.println("citation : " + numCitation);
        	System.out.println("condition 1 : " + sumBeforeCitation);
        	System.out.println("condition 2 : " + (citations.length - (sumBeforeCitation + citationEntry.getValue())) );
        	System.out.println("-------");
        	
        	if(numCitation <= (sumBeforeCitation + citationEntry.getValue()) && numCitation >= (citations.length - sumBeforeCitation))
        		return numCitation;
        	
        	
        	sumBeforeCitation += citationEntry.getValue();
        	
        }

        
        return 0;
    }

}
