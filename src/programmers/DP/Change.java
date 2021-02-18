package programmers.DP;

public class Change {

	public static void main(String[] args) {
		
		int n = 5;
		int[] money = {1,2,5};
		
		System.out.println(solution(n,money));

	}
	
	public static int solution(int n, int[] money) {
		int answer = 0;

		long[][] dp = new long[money.length][n + 1];

		for (int di = 0; di <= n; di++) {
			dp[0][di] = (di % money[0] == 0) ? 1 : 0;
		}

		for (int mi = 1; mi < money.length; mi++) {
			for (int increasingN = 0; increasingN <= n; increasingN++) {
				dp[mi][increasingN] = dp[mi - 1][increasingN];
				for (int coinCount = 1; coinCount <= increasingN / money[mi]; coinCount++) {
					dp[mi][increasingN] += dp[mi - 1][increasingN - (money[mi] * coinCount)];
					
				}
			}
		}

		answer = (int) (dp[money.length - 1][n] % 1000000007);

		return answer;
	}

}
