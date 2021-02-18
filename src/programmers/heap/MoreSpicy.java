package programmers.heap;

import java.util.PriorityQueue;

public class MoreSpicy {

	public static void main(String[] args) {

		
		
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;

		System.out.println(solution(scoville, K));
	}

	public static int solution(int[] scoville, int K) {

		PriorityQueue<Integer> scovilles = new PriorityQueue<>();

		int numUnderK = 0;

		for (int scovilleI = 0; scovilleI < scoville.length; scovilleI++) {

			if (scoville[scovilleI] < K)
				numUnderK++;

			scovilles.add(scoville[scovilleI]);
		}

		int numMix = 0;

		while (scovilles.size() > 1 && numUnderK > 0) {

			int leastScoville = scovilles.poll();
			int secondLeastScoville = scovilles.poll();

			if (leastScoville < K)
				numUnderK--;
			if (secondLeastScoville < K)
				numUnderK--;

			int mixedScoville = leastScoville + (secondLeastScoville * 2);

			if (mixedScoville < K)
				numUnderK++;

			scovilles.add(mixedScoville);

			numMix++;

		}

		if (numUnderK > 0)
			return -1;
		else
			return numMix;
	}

}
