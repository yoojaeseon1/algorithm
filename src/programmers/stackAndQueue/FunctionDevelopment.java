package programmers.stackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class FunctionDevelopment {
	
	public static void main(String[] args) {

		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		System.out.println(solution(progresses, speeds));

	}

	public static int[] solution(int[] progresses, int[] speeds) {

		int[] requiredDates = new int[progresses.length];
		int currentRequiredDate = 0;
		for (int pi = 0; pi < progresses.length; pi++) {
			currentRequiredDate = 0;
			while (progresses[pi] < 100) {
				progresses[pi] += speeds[pi];
				currentRequiredDate++;
			}
			requiredDates[pi] = currentRequiredDate;
		}

		List<Integer> progressesList = new ArrayList<>();
		int currentDate = requiredDates[0];
		int progressCount = 1;
		for (int ci = 1; ci < requiredDates.length; ci++) {

			if (requiredDates[ci] <= currentDate)
				progressCount++;
			else {
				progressesList.add(progressCount);
				currentDate = requiredDates[ci];
				progressCount = 1;
			}
		}
		progressesList.add(progressCount);
		
		int[] answer = new int[progressesList.size()];
		for (int ai = 0; ai < answer.length; ai++) {
			answer[ai] = progressesList.get(ai);
		}

		return answer;
	}

}
