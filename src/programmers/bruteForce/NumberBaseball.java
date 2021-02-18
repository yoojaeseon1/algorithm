package programmers.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseball {
	
	public static void main(String[] args) {
		
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(solution(baseball));
		
	}
	
	
	
	public static int solution(int[][] baseball) {
		int answer = 0;

		List<String> caseList = new ArrayList<>();

		for (int third = 1; third < 10; third++) {
			for (int second = 1; second < 10; second++) {
				for (int first = 1; first < 10; first++) {
					if (first != second && second != third && first != third) {
						caseList.add(Integer.toString(third * 100 + second * 10 + first));
						// System.out.println(caseList.get(caseList.size()-1));
					}
				}
			}
		}

		for (int ci = 0; ci < caseList.size(); ci++) {

			String currentSource = caseList.get(ci);
			int caseCorrectCount = 0;
				for (int bi = 0; bi < baseball.length; bi++) {
				String currentCompared = Integer.toString(baseball[bi][0]);
				int strikeCount = getStrikeCount(currentSource, currentCompared);
				int ballCount = getBallCount(currentSource, currentCompared);

				if (baseball[bi][1] == strikeCount && baseball[bi][2] == ballCount)
					caseCorrectCount++;
			}

			if (baseball.length == caseCorrectCount++) {
				System.out.println(currentSource);
				answer++;
			}

		}

		return answer;
	}

	public static int getStrikeCount(String source, String compared) {
		int strikeCount = 0;

		for (int si = 0; si < source.length(); si++) {

			if (source.charAt(si) == compared.charAt(si))
				strikeCount++;

		}

		return strikeCount;
	}

	public static int getBallCount(String source, String compared) {
		int ballCount = 0;

		for (int ci = 0; ci < compared.length(); ci++) {
			String currentCompared = compared.substring(ci, ci + 1);
			if (source.contains(currentCompared) && source.indexOf(currentCompared) != ci) {
				ballCount++;
			}
		}

		return ballCount;
	}

}
