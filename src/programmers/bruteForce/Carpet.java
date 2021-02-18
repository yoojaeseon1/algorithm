package programmers.bruteForce;

public class Carpet {

	public static void main(String[] args) {
		
		int[] answer = solution(16,9);
//		int[] answer = solution(17,8);
		
		System.out.println(answer[0] + ", " + answer[1]);

	}

	public static int[] solution(int brown, int red) {
		int width = 0;
		int height = 0;

		for (int i = 1; i <= red / 2 + 1; i++) {
			width = i;
			height = (red % i == 0) ? red / i : red / i + 1;
//			System.out.println("i : " + i);
//			System.out.println("calculated brown : " + (2 * width + 2 * height + 4));
			if (2 * width + 2 * height + 4 == brown)
				break;

		}

		int[] answer = { Math.max(width, height) + 2, Math.min(width, height) + 2 };

		return answer;
	}
}
