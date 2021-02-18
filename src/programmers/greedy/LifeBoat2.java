package programmers.greedy;

import java.util.Arrays;

public class LifeBoat2 {

	public static void main(String[] args) {
		
		int[] people = {10,20,30,40,50,60,70,80,90};
		int limit = 100;
		
		System.out.println(solution(people, limit));

	}
	
    public static int solution(int[] people, int limit) {
        int answer = 1;
        
        Arrays.sort(people);
        
        int addedWeight = 0;
        int numPeople = 0;
        
        for(int weight : people) {
            
            addedWeight += weight;
            numPeople++;
            
            if(addedWeight > limit) {
                addedWeight = weight;
                numPeople = 1;
                answer++;
            } else if(numPeople == 2){
                addedWeight = 0;
                numPeople = 0;
                answer++;
            }
        }
        
        return answer;
    }

}
