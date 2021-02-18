package programmers.greedy;

public class SportsUniform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int n = 5;

		// int[] lost = {2,4};
		// int[] reserve = {1,3,5};
		// int[] lost = {2,4};
		// int[] reserve = {3};

		int n = 3;
		int[] lost = { 2, 4 };
		int[] reserve = { 3 };

		System.out.println(solution(n, lost, reserve));

	}

	public static int solution(int n, int[] lost, int[] reserve) {

		int[] uniformCounts = new int[31];

		for (int li = 0; li < lost.length; li++) {
			uniformCounts[lost[li]] = -1;
		}

		for (int ri = 0; ri < reserve.length; ri++) {
			uniformCounts[reserve[ri]] += 2;
		}

		if (uniformCounts[1] == -1 && uniformCounts[2] == 2) {
			uniformCounts[1] = 1;
			uniformCounts[2] = 1;
		}

		for (int ui = 2; ui < uniformCounts.length; ui++) {

			if (uniformCounts[ui] == -1) {

				if (uniformCounts[ui - 1] == 2) {
					uniformCounts[ui] = 1;
					uniformCounts[ui - 1] = 1;
				} else if (uniformCounts[ui + 1] == 2) {
					uniformCounts[ui] = 1;
					uniformCounts[ui + 1] = 1;
				}
			}
		}

		if (uniformCounts[uniformCounts.length - 1] == -1 && uniformCounts[uniformCounts.length - 2] == 2) {
			uniformCounts[uniformCounts.length - 1] = 1;
			uniformCounts[uniformCounts.length - 2] = 1;
		}

		int attendableCount = n;
		for (int ui = 1; ui < uniformCounts.length; ui++) {

			if (uniformCounts[ui] == -1)
				attendableCount--;
		}
		return attendableCount;
	}
}