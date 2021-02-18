package programmers.stackAndQueue;

public class Stick {

	public static void main(String[] args) {
		
		System.out.println(solution("()(((()())(())()))(())"));

	}
	
	public static int solution(String arrangement) {
        int cuttedCount = 0; // answer
        
        int currentStickCount = 0;
        int endStickCount = 0;
        char beforeArgState = arrangement.charAt(0);
        for(int ai = 0; ai < arrangement.length(); ai++) {
        	char currentArgState = arrangement.charAt(ai);
        	if(currentArgState == '(') currentStickCount++;
        	else if(currentArgState == ')' && beforeArgState == ')') endStickCount++;
        	else {
        		cuttedCount += --currentStickCount;
        		currentStickCount -= endStickCount;
        		endStickCount = 0;
        	}
        	beforeArgState = currentArgState;
        }
        
        cuttedCount += currentStickCount;
        
        return cuttedCount;
    }

}
