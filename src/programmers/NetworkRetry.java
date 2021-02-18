package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class NetworkRetry {

	public static void main(String[] args) {
		
		
//		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		System.out.println(solution(n, computers));

	}
	
	
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] isEnqueued = new boolean[computers.length];
        
        Queue<Integer> searchQueue = new LinkedList<>();
        
        for(int computersI = 0; computersI < computers.length; computersI++) {
        	
        	if(!isEnqueued[computersI]) {
        		
        		searchQueue.add(computersI);
        		isEnqueued[computersI] = true;
        		
        		while(!searchQueue.isEmpty()) {
        			
        			int currentNode = searchQueue.poll();
        			
        			for(int computersJ = 0; computersJ < computers.length; computersJ++) {
        				
        				if(computers[currentNode][computersJ] == 1 && !isEnqueued[computersJ]) {
        					
        					searchQueue.add(computersJ);
        					isEnqueued[computersJ] = true;
        					
        				}
        			}
        		}
        		
        		answer++;
        	}
        		
        }
        return answer;
    }

}
