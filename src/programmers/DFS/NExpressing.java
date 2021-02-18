package programmers.DFS;

public class NExpressing {

	public static void main(String[] args) {

		// int[] nnn = new int[8];
		// int N = 5;
		//
		// StringBuilder addedDigitN = new StringBuilder();
		//
		// // addedDigitN.append(N);
		//
		// for (int i = 0; i < 8; i++) {
		// // nnn[i] = Integer.parseInt(Integer.toBinaryString((int)
		// // Math.pow(2, i + 1) - 1)) * N;
		//
		// addedDigitN.append(N);
		// nnn[i] = Integer.parseInt(addedDigitN.toString());
		//
		// System.out.println(nnn[i]);
		//
		// }

//		int n = 5;
//		int number = 12;
		int n = 2;
		int number = 11;

		System.out.println(solution(n, number));

	}

	private static int result;

	public static int solution(int N, int number) {

		result = -1;

		int[] addedDigitNs = new int[8];

		StringBuilder addedDigitN = new StringBuilder();

		// addedDigitN.append(N);

		for (int addedI = 0; addedI < addedDigitNs.length; addedI++) {
			// nnn[i] = Integer.parseInt(Integer.toBinaryString((int)
			// Math.pow(2, i + 1) - 1)) * N;

			addedDigitN.append(N);
			addedDigitNs[addedI] = Integer.parseInt(addedDigitN.toString());

			// System.out.println(addedDigitNs);

		}

		doDFS(addedDigitNs, 0, 0, number);

		return result;

	}

	public static void doDFS(int[] addedDigitNs, int numDigit, int computedNum, int number) {

		if (numDigit > 8)
			return;
		else if (computedNum == number) {
			if (numDigit < result || result == -1) {
				result = numDigit;
			}
			return;
		} else {

			for (int addedI = 0; addedI < addedDigitNs.length; addedI++) {

				doDFS(addedDigitNs, numDigit + addedI + 1, computedNum + addedDigitNs[addedI], number);
				doDFS(addedDigitNs, numDigit + addedI + 1, computedNum - addedDigitNs[addedI], number);
				doDFS(addedDigitNs, numDigit + addedI + 1, computedNum * addedDigitNs[addedI], number);
				doDFS(addedDigitNs, numDigit + addedI + 1, computedNum / addedDigitNs[addedI], number);
			}
		}
	}

}
