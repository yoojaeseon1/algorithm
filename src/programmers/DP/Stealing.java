package programmers.DP;

public class Stealing {

	public static void main(String[] args) {

		int[] money = { 1, 2, 3, 1 };

		// int[] money = {1,3,5,100,3,9};

		// int[] money = {7,5,0,4,10000};

		// int[] money = { 10000,11300,200,100,1000000};

		System.out.println(solution(money));

	}

	public static int solution(int[] money) {

		int answer = 0;
		if (money.length == 3) {

			answer = Math.max(money[0], money[1]);
			answer = Math.max(answer, money[2]);

		} else {

			int[][] maxMoneyRoute = new int[money.length][2];

            // [i][0] : maxSumMoney(0~i), first house attend 
            // [i][1] : maxSumMoney(0~i), first house don't attend

			maxMoneyRoute[0][0] = money[0];
			maxMoneyRoute[0][1] = 0;

			maxMoneyRoute[1][0] = money[0];
			maxMoneyRoute[1][1] = money[1];

			for (int maxMoneyI = 2; maxMoneyI < maxMoneyRoute.length - 1; maxMoneyI++) {

				maxMoneyRoute[maxMoneyI][0] = Math.max(money[maxMoneyI] + maxMoneyRoute[maxMoneyI - 2][0],
						maxMoneyRoute[maxMoneyI - 1][0]);
				maxMoneyRoute[maxMoneyI][1] = Math.max(money[maxMoneyI] + maxMoneyRoute[maxMoneyI - 2][1],
						maxMoneyRoute[maxMoneyI - 1][1]);

			}

			answer = Math.max(maxMoneyRoute[maxMoneyRoute.length - 2][0],
					money[money.length - 1] + maxMoneyRoute[maxMoneyRoute.length - 3][1]);
			answer = Math.max(answer, maxMoneyRoute[maxMoneyRoute.length - 2][1]);

		}

		return answer;
	}

}
