package programmers.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LifeBoat4 {

	public static void main(String[] args) {
		
		int[] people = {10,20,30,40,50,60,70,80,90};
		int limit = 100;
		
		System.out.println(solution(people,limit));

	}
	
    public static int solution(int[] people, int limit) {
        
        int answer = 0;
        
        Arrays.sort(people);
        
        Queue<Integer> peopleQueue = new LinkedList<>();
        
        
        for(int weight : people)
            peopleQueue.add(weight);
        
        boolean addOneFlag = true;
        
        while(peopleQueue.size() >= 2){
            int weight1 = peopleQueue.poll();
            int weight2 = peopleQueue.poll();
            
            if(weight1 + weight2 <= limit)
                answer++;
            else{
                answer += peopleQueue.size()+2;
                addOneFlag = false;
                break;
            }
        }
        
//        System.out.println(peopleQueue.size());
        
        if(peopleQueue.size() == 1 && addOneFlag)
            answer++;
            
        return answer;
        
    }

}
