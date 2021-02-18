package algorithmSkills;

public class Eratos {
	
	public static void main(String[] args) {
		
	}

	
	public static int[] makePrimeArray(int maxNum) {

		int[] answer = new int[maxNum + 1];

		for (int ai = 2; ai <= maxNum; ai++) {
			answer[ai] = ai;
		}

		for (int ai = 2; ai <= maxNum; ai++) {
			if (answer[ai] == 0)
				continue;
			for (int aj = 2 * ai; aj <= maxNum; aj += ai) {
				answer[aj] = 0;
			}
		}

		return answer;
	}
	
}
