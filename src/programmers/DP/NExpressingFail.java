package programmers.DP;

public class NExpressingFail {

	public static void main(String[] args) {

		System.out.println(solution(5, 12));

	}

	public static int solution(int N, int number) {
		int answer = 0;

		int numLeftOperand = 1;
		int numRightOperand = 1;

		int rightOperand = N;
		int leftOperand = N;

		int[] minCounts = new int[number + 1];

		for (int minCountsI = 1; minCountsI < N; minCountsI++) {
			minCounts[minCountsI] = minCountsI + 1;
		}

		for (int minCountsI = N + 1; minCountsI < minCounts.length; minCountsI++) {
			minCounts[minCountsI] = 9;
		}

		minCounts[N] = 1;

		numRightOperand++;
		int computed = (int) Math.pow(N, numRightOperand);

		while (computed <= number && computed <= 32000) {

			minCounts[computed] = numRightOperand;

			numRightOperand++;

			computed = (int) Math.pow(N, numRightOperand);

		}

		numLeftOperand = 0;
		numRightOperand = 1;

		while (leftOperand <= number) {
			numLeftOperand++;
			numRightOperand = 1;

			leftOperand = addDigit(N, numLeftOperand);
			rightOperand = addDigit(N, numRightOperand);

			computed = leftOperand * rightOperand;

			// System.out.println("1. computed : " + computed);
			while (computed <= number) {

				minCounts[computed] = Math.min(minCounts[computed], numLeftOperand + numRightOperand);
				// numRightOperand++;
				rightOperand = addDigit(N, ++numRightOperand);

				computed = leftOperand * rightOperand;
				// System.out.println("2. computed : " + computed);

			}
		}

		numLeftOperand = 0;
		numRightOperand = 1;

		while (leftOperand <= number) {
			numLeftOperand++;
			numRightOperand = 1;

			leftOperand = addDigit(N, numLeftOperand);
			rightOperand = addDigit(N, numRightOperand);

			computed = leftOperand + rightOperand;

			// System.out.println("1. computed : " + computed);
			while (computed <= number) {

				minCounts[computed] = Math.min(minCounts[computed], numLeftOperand + numRightOperand);
				// numRightOperand++;
				rightOperand = addDigit(N, ++numRightOperand);

				computed = leftOperand + rightOperand;
				// System.out.println("2. computed : " + computed);

			}
		}

		numLeftOperand = 2;
		numRightOperand = 1;

		leftOperand = addDigit(N, numLeftOperand);
		rightOperand = addDigit(N, numRightOperand);

		computed = leftOperand / rightOperand;

		while (computed <= number) {

			minCounts[computed] = Math.min(minCounts[computed], numLeftOperand + numRightOperand);

			leftOperand = addDigit(N, numLeftOperand);
			rightOperand = addDigit(N, numRightOperand);

			numLeftOperand++;

			computed = leftOperand + rightOperand;
			// System.out.println("2. computed : " + computed);

		}

		for (int minCountsI = 0; minCountsI < minCounts.length; minCountsI++) {

			System.out.println("index : " + minCountsI);
			System.out.println("value : " + minCounts[minCountsI]);

		}

		if (minCounts[number] == 9) {

			for (int operand = 1; operand <= number / 2; operand++) {

				minCounts[number] = Math.min(minCounts[number], minCounts[operand] + minCounts[number - operand]);
				System.out.println("minCount : " + minCounts[number]);
			}

		}

		return minCounts[number];
	}

	public static int addDigit(int n, int numDigit) {

		StringBuilder computedNum = new StringBuilder();
		computedNum.append(n);
		// System.out.println(computedNum);

		for (int increasingDigit = 2; increasingDigit <= numDigit; increasingDigit++) {

			computedNum.append(n);
			// System.out.println("appended");

		}

		return Integer.parseInt(computedNum.toString());

	}

}
