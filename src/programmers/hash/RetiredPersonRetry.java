package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RetiredPersonRetry {

	public static void main(String[] args) {

		
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
//		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//		String[] completion = {"josipa", "filipa", "marina", "nikola"};
//				
//		String[] participant = {"mislav", "stanko", "mislav", "ana"};
//		String[] completion = {"stanko", "ana", "mislav"};
		
		
	}

	public static String solution(String[] participant, String[] completion) {
		
        String answer = "";
        
        Map<String, Integer> participantToCount = new HashMap<>();
        Map<String, Integer> completionToCount = new HashMap<>();
        
        for(int participantI = 0; participantI < participant.length; participantI++) {
            
            String participantPerson = participant[participantI];
            int personCount = participantToCount.getOrDefault(participantPerson, 0);
            
            if(personCount > 0) {
                participantToCount.put(participantPerson, personCount+1);
            } else {
                participantToCount.put(participantPerson, 1);
            }
            
        }
        
        for(int completionI = 0; completionI < completion.length; completionI++) {
            
            String completionPerson = completion[completionI];
            int personCount = completionToCount.getOrDefault(completionPerson, 0);
            
            if(personCount > 0) {
                completionToCount.put(completionPerson, personCount+1);
            } else {
                completionToCount.put(completionPerson, 1);
            }
        }
        
        Iterator<Entry<String, Integer>> participantIter = participantToCount.entrySet().iterator();
        
        while(participantIter.hasNext()) {
            
            Entry<String, Integer> participantEntry = participantIter.next();
            String participantPerson = participantEntry.getKey();
            int participantCount = participantEntry.getValue();
            
            int completionCount = completionToCount.getOrDefault(participantPerson, 0);
            
            if(completionCount == 0 || completionCount == participantCount-1)
                return participantPerson;
            
        }
        
        
        return answer;
	}

}
