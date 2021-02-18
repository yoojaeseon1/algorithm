package programmers.stackAndQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Printer {

	public static void main(String[] args){
		
//		int[] priorities = {2,1,3,2};
//		int location = 2;
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		System.out.println(solution(priorities, location));
		
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 1;
        
        List<Integer> prioritiesList = new ArrayList<>();
        Queue<int[]> printer = new LinkedList<>();
        
        
        for(int pi = 0; pi < priorities.length; pi++) {
        	int[] print = {priorities[pi], pi};
        	printer.add(print);
        	
        	prioritiesList.add(priorities[pi]);
        }
        
        Collections.sort(prioritiesList, Collections.reverseOrder());
        
       
        while(!printer.isEmpty()){
        	
        	int[] currentPrint = printer.poll();
        	
        	if(currentPrint[0] == prioritiesList.get(0)) {
        		if(location == currentPrint[1]) return answer;
        		else {
        			answer++;
        			prioritiesList.remove(0);
        		}
        	} else{
        		printer.add(currentPrint);
        	}
        }
        return answer;
    }
	
}
