package programmers.levelTest.level2.secondTrial;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Q1 {
	
	public static void main(String[] args) {
		
//		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
//		System.out.println(Arrays.toString(solution(3,words)));
		
//		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
//		System.out.println(Arrays.toString(solution(5,words)));
//
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		
		System.out.println(Arrays.toString(solution(2,words)));
		
	}
	
	
    public static int[] solution(int n, String[] words) {
        
    	int[] answer = new int[2];

        String beforeWord = words[0];
        Set<String> duplicatingCheckSet = new HashSet<>();
        duplicatingCheckSet.add(words[0]);
        int beforeSetSize = 1;
        
        for(int wordsI = 1; wordsI < words.length; wordsI++) {
        	
        	duplicatingCheckSet.add(words[wordsI]);
        	
        	if(words[wordsI].charAt(0) != beforeWord.charAt(beforeWord.length()-1) || duplicatingCheckSet.size() == beforeSetSize) {
//        		System.out.println("wordsI : " + wordsI);

        		answer[0] = (wordsI % n) +1;
        		answer[1] = (wordsI / n) + 1 ;
        		return answer;
        	} else{
        		beforeWord = words[wordsI];
        		duplicatingCheckSet.add(beforeWord);
        		beforeSetSize++;
        	}
        		
        }
    
        return answer;
    }

}
