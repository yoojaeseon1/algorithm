package programmers.DP;

public class NExpressingRetry {

	public static void main(String[] args) {

		int N = 2;
		int number = 11;

		System.out.println(solution(N, number));

	}

	// static final int finalN;

	static int answer;

	public static int solution(int N, int number) {

		answer = 9;

		doDFS(N, 0, 0, number);

		if (answer == 9)
			return -1;

		return answer;
	}

	public static void doDFS(int N, int numN, int calculatedValue, int number) {

		if (numN > 8)
			return;
		else if (calculatedValue == number) {
			answer = Math.min(answer, numN);
			return;
		}

		String operandString = "";

		for (int operandLength = 1; operandLength <= 8; operandLength++) {

			operandString += Integer.toString(N);
			int operand = Integer.parseInt(operandString);

			doDFS(N, numN + operandLength, calculatedValue + operand, number);
			doDFS(N, numN + operandLength, calculatedValue - operand, number);
			doDFS(N, numN + operandLength, calculatedValue * operand, number);
			doDFS(N, numN + operandLength, calculatedValue / operand, number);

		}

	}

}
