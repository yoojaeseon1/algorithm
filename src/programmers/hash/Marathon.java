package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Marathon {
	
	public static void main(String[] args) {
		
		
		String[] participant = {"leo", "kiki", "eden"};
		
		String[] completion = {"eden", "kiki"};
		
		System.out.println(solution(participant, completion));
		
	}
	
	
	public static String solution(String[] participant, String[] completion) {
        String retiredPerson = "";
        
        Map<String, Integer> completionCheck = new HashMap<>();
        
        for(int pi = 0; pi < participant.length; pi++) {
        	
        	if(completionCheck.containsKey(participant[pi]))
        		completionCheck.put(participant[pi],completionCheck.get(participant[pi]) + 1);
        	else
        		completionCheck.put(participant[pi], 1);
        	
        }
        
       for(int ci = 0; ci < completion.length; ci++) {
    	   
    	   completionCheck.put(completion[ci], completionCheck.get(completion[ci]) - 1);
    	   
       }
       
       Iterator<Entry<String, Integer>> completionIter = completionCheck.entrySet().iterator();
       
       while(completionIter.hasNext()) {
    	   
    	   Entry<String, Integer> currentPerson = (Entry<String, Integer>)completionIter.next();
    	   
    	   int numCompletion = (Integer)currentPerson.getValue();
    	   
    	   if(numCompletion == 1){
    		   retiredPerson = (String)currentPerson.getKey();
    	   }
       }
        
        return retiredPerson;
    }
	
	
}
