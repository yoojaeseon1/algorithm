package programmers.levelTest.level1;

public class Q2 {
	
	public static void main(String[] args) {
		
	
		
		
	}
	
    public long[] solution(int x, int n) {
        
    	long[] answer = new long[n];
        
    	answer[0] = x;
        
    	for(int answerI = 1; answerI < answer.length; answerI++) {
    		
    		answer[answerI] = answer[answerI-1] + x;
    		
    	}
    	
        
        return answer;
    }

}
