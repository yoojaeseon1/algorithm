package programmers;

import java.util.Stack;

public class NetworkRetry2 {

	public static void main(String[] args) {
		
		
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		System.out.println(solution(n, computers));

	}
	
	
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] isPushed = new boolean[computers.length];
        
        Stack<Integer> searchStack = new Stack<>();
        
        for(int computersI = 0; computersI < computers.length; computersI++) {
        	
        	if(!isPushed[computersI]) {
        		
        		searchStack.add(computersI);
        		isPushed[computersI] = true;
        		
        		while(!searchStack.isEmpty()) {
        			
        			int currentNode = searchStack.pop();
        			
        			for(int computersJ = 0; computersJ < computers.length; computersJ++) {
        				
        				if(computers[currentNode][computersJ] == 1 && !isPushed[computersJ]) {
        					
        					searchStack.add(computersJ);
        					isPushed[computersJ] = true;
        					
        				}
        			}
        		}
        		
        		answer++;
        	}
        		
        }
        return answer;
    }

}
