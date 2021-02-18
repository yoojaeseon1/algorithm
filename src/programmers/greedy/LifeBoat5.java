package programmers.greedy;

import java.util.Arrays;


// all cases success (LifeBoat1~4 fail)

public class LifeBoat5 {

	public static void main(String[] args) {
		
		
		
//		int[] people = {10,20,30,40,50,60,70,80,90};
//		int limit = 100;
//		int[] people = {70,80,50};
//		int limit = 100;
		int[] people = {20,30,40,65,66,67,68,70,80};
		int limit = 100;
		
		System.out.println(solution(people, limit));
		
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);

		int lastStartIndex = people.length - 1;
		
		// added source ---
		int beforeLastIndex = people.length - 1;
		// -----
		
		for (int peopleI = 0; peopleI < people.length; peopleI++) {

			for (int peopleJ = lastStartIndex; peopleJ > peopleI; peopleJ--) {

				if (people[peopleI] + people[peopleJ] <= limit) {
					answer++;
					lastStartIndex = peopleJ - 1;
					break;
				} else
					answer++;
			}
			
			
			if (peopleI == lastStartIndex)
				break;
			if (peopleI + 1 == lastStartIndex || beforeLastIndex == lastStartIndex) {
				answer++;
				break;
			}
			// added source --- 
			
			beforeLastIndex = lastStartIndex;
			// ----
		}

		return answer;
	}
}