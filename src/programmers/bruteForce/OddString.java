package programmers.bruteForce;

public class OddString {
	
	public static void main(String[] args) {
		
		String s = "try hello world";
		
		System.out.println(solution(s));
		
	}
	
    public static String solution(String s) {
    	
        StringBuilder answer = new StringBuilder();
        
        int currentWordIndex = 0;
        for(int si = 0; si < s.length(); si++) {
        	
        	char currentChar = s.charAt(si);
        	
        	if(currentChar == ' ') {
        		currentWordIndex = 0;
        		answer.append(' ');
        		continue;
        	}
        	
        	if(currentWordIndex % 2 == 0)
        		answer.append(Character.toUpperCase(currentChar));
        	else
        		answer.append(Character.toLowerCase(currentChar));
        	
        	currentWordIndex++;
        	
        }
        
        
        return answer.toString();
    }

}
