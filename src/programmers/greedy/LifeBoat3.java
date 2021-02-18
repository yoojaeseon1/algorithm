package programmers.greedy;

import java.util.Arrays;

public class LifeBoat3 {

	public static void main(String[] args) {
		
		int[] people = {10,20,30,40,50,60,70,80,90};
		int limit = 100;
		
		System.out.println(solution(people,limit));

	}
	
	
    public static int solution(int[] people, int limit) {
        
        int answer = 0;
        
        Arrays.sort(people);
        
        int lastPareIndex = -1;
        
        for(int peopleI = 0; peopleI < people.length-1; peopleI++) {
            
            if(people[peopleI] + people[peopleI+1] <= limit) {
                answer++;
                peopleI++;
            }
            else {
                lastPareIndex = peopleI;
                break;
            }
        }
        
        if(lastPareIndex >= 0) {
            answer += people.length - lastPareIndex;
        } else if(people.length % 2 == 1) {
            answer++;
        }
        
        return answer;
    }
}
