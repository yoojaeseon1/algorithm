package programmers.bruteForce;

public class TrialExam {
	
	public static void main(String[] args) {

		// int[] answers = {1,2,3,4,5};
		int[] answers = { 1, 3, 2, 4, 2 };

		solution(answers);

	}

	public static int[] solution(int[] answers) {
		

		int[] studentOne = { 1, 2, 3, 4, 5 };
		int[] studentTwo = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] studentThree = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		Integer[] points = new Integer[4];
		points[0] = new Integer(0);
		points[1] = new Integer(0);
		points[2] = new Integer(0);
		points[3] = new Integer(0);

		for (int ai = 0; ai < answers.length; ai++) {
			if (answers[ai] == studentOne[ai % studentOne.length])
				points[1]++;
			if (answers[ai] == studentTwo[ai % studentTwo.length])
				points[2]++;
			if (answers[ai] == studentThree[ai % studentThree.length])
				points[3]++;
		}

//		Arrays.sort(points, Collections.reverseOrder());

		int highestPoint = -1;
		int firstCount = 0;
		
		for(int pi = 0; pi < points.length; pi++) {
			highestPoint = Math.max(highestPoint, points[pi]);
		}

		for (int pi = 0; pi < points.length; pi++) {
			if (highestPoint == points[pi])
				firstCount++;
		}

		int[] answer = new int[firstCount];
		int answerIndex = 0;
		
//		System.out.println("firstCount : " + firstCount);
		
		for(int pi = 1; pi < points.length; pi++) {
			if(highestPoint == points[pi]) answer[answerIndex++] = pi;
		}
		
		for(int ai = 0; ai < answer.length; ai++) {
			System.out.println(answer[ai]);
		}
		
		return answer;
	}

}
