package programmers;

public class WordChangingRetry {

	public static void main(String[] args) {
		
		String begin = "abcdeeffg";
		String target = "abcdeeffg";
		
//		String begin = "hit";
//		String target = "cog";
		
//		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		
//		System.out.println(solution(begin, target, words));

	}
	
	static int answer;
	
    public static int solution(String begin, String target, String[] words) {
        answer = words.length+1;
        
        boolean[] isVisited = new boolean[words.length];
        
        searchWords(words, isVisited, 0, begin, target);
        
        
        if(answer == words.length+1)
        	return 0;
        
        return answer;
    }
    
    
    public static void searchWords(String[] words, boolean[] isVisited, int numVisited,  String begin, String target) {
    	
    	if(begin.equals(target)) {
    		answer = Math.min(answer, numVisited);
    		return;
    	}
    	
    	for(int wordsI = 0; wordsI < words.length; wordsI++) {
    		
    		if(!isVisited[wordsI] && isDifferentOneWord(begin, words[wordsI])) {
    			
    			isVisited[wordsI] = true;
    			searchWords(words, isVisited, numVisited+1, words[wordsI], target);
    			isVisited[wordsI] = false;
    			
    		}
    		
    		
    	}
    	
    	
    }
    
    public static boolean isDifferentOneWord(String word1, String word2) { 	
    	
    	int numDifferentChar = 0;
    	
    	for(int wordI = 0; wordI < word1.length(); wordI++) {
    		
    		if(word1.charAt(wordI) != word2.charAt(wordI))
    			numDifferentChar++;
    		
    	}
    	
    	if(numDifferentChar == 1)
    		return true;
    	
    	
    	return false;

    	
    	
    	
    	
    }
	

}
