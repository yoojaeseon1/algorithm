package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GemsShopping {
	
	public static void main(String[] args) {

		// String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD",
		// "SAPPHIRE", "DIA"};
		// String[] gems = { "AA", "AB", "AC", "AA", "AC" };
		String[] gems = { "AB", "AC", "AB", "AC", "AA" };
		// String[] gems = {"XYZ", "XYZ", "XYZ"};
		// String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

		System.out.println(Arrays.toString(solution(gems)));

	}

	public static int[] solution(String[] gems) {

		int[] answer = new int[2];
		int currentMinLength = gems.length + 1;

		Map<String, Integer> gemsToCount = new HashMap<>();

		for (int gemsI = 0; gemsI < gems.length; gemsI++)
			gemsToCount.put(gems[gemsI], 0);

		if (gemsToCount.size() == 1) {
			answer[0] = 1;
			answer[1] = 1;
			return answer;
		}

		int numZero = gemsToCount.size();
		int numTypeOfGems = numZero;
		int beginIndex = 0;
		int endIndex = -1;
		gemsToCount.clear();

		for (int gemsI = 0; gemsI < gems.length; gemsI++) {
			String gem = gems[gemsI];

			int numStoredGem = gemsToCount.getOrDefault(gem, 0);
			if (numStoredGem == 0) {
				gemsToCount.put(gem, 1);
				numZero--;
			} else
				gemsToCount.put(gem, numStoredGem + 1);

			endIndex++;

			if (numZero == 0) {
				while (true) {
					int currentRangeLength = endIndex - beginIndex + 2;

					if (numZero == 0) {
						int numCurrentGem = gemsToCount.get(gems[beginIndex]);
						gemsToCount.put(gems[beginIndex], numCurrentGem - 1);
						beginIndex++;
						if (numCurrentGem == 1)
							numZero++;

					} else {
						if (currentRangeLength < currentMinLength) {
							currentMinLength = currentRangeLength;
							answer[0] = beginIndex;
							answer[1] = endIndex + 1;
						}

						if (currentMinLength == numTypeOfGems)
							return answer;

						break;

					}
				}
			}
		}

		return answer;
	}

}
