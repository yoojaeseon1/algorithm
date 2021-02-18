package programmers.DP;

public class FromSeoulToGyeongsan {

	public static void main(String[] args) {

//		int[][] travel = { { 500, 200, 200, 100 }, { 800, 370, 300, 120 }, { 700, 250, 300, 90 } };
//
//		int K = 1650;
		
		int[][] travel = {{1000, 2000, 300, 700}, {1100, 1900, 400, 900}, {900, 1800, 400, 700}, {1200, 2300, 500, 1200}};
		int K = 3000;

		System.out.println(solution(K, travel));

	}

	public static int solution(int K, int[][] travel) {

		int[][] dp = new int[travel.length][K+1];

		dp[0][travel[0][0]] = travel[0][1];
		dp[0][travel[0][2]] = travel[0][3];	

		int answer = 0;

		for (int travelI = 1; travelI < travel.length; travelI++) {

			for (int sumBeforeDistance = 1; sumBeforeDistance <= K; sumBeforeDistance++) {

				if (dp[travelI - 1][sumBeforeDistance] == 0)
					continue;

				if (sumBeforeDistance + travel[travelI][0] <= K) {
					dp[travelI][sumBeforeDistance + travel[travelI][0]] = Math.max(
							dp[travelI][sumBeforeDistance + travel[travelI][0]],
							dp[travelI - 1][sumBeforeDistance] + travel[travelI][1]);
					answer = Math.max(answer, dp[travelI][sumBeforeDistance + travel[travelI][0]]);
				}

				if (sumBeforeDistance + travel[travelI][2] <= K) {
					dp[travelI][sumBeforeDistance + travel[travelI][2]] = Math.max(
							dp[travelI][sumBeforeDistance + travel[travelI][2]],
							dp[travelI - 1][sumBeforeDistance] + travel[travelI][3]);
					answer = Math.max(answer, dp[travelI][sumBeforeDistance + travel[travelI][2]]);
				}
			}
		}

		return answer;
	}

}
