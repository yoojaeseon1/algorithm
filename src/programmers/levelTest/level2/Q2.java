package programmers.levelTest.level2;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Q2 {

	public static void main(String[] args) {
		
//		int[] citations = {3, 0, 6, 1, 5};
		int[] citations = {15,12,10,8,7,6,2,1};
//		int[] citations = {15,12,10,8,7,7,7,2,1};
//		int[] citations = {2,2,2,2,2};
		
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
        
        if(paperToCitation.size() == 1) {
        	Entry<Integer, Integer> citationEntry = citationIter.next();
        	int paper = citationEntry.getKey();
        	int numCitation = citationEntry.getValue();
        	
        	if(paper <= (sumBeforeCitation + numCitation) && paper >= citations.length - numCitation)
        		return paper;
        	else 
        		return 0;
        }
        	
        
        
        
        while(citationIter.hasNext()) {
        	
        	Entry<Integer, Integer> citationEntry = citationIter.next();
        	int paper = citationEntry.getKey();
        	
        	System.out.println("numCitation : " + paper);
        	System.out.println("contition 1 : " + (sumBeforeCitation + citationEntry.getValue()));
        	System.out.println("contition 2 : " + (citations.length - (sumBeforeCitation + citationEntry.getValue())));
        	System.out.println("------");
        	
        	if(paper <= (sumBeforeCitation + citationEntry.getValue()) && paper >= (citations.length - (sumBeforeCitation + citationEntry.getValue())))
        		return paper;
        	
        	
        	sumBeforeCitation += citationEntry.getValue();
        	
        }

        
        return 0;
    }

}
