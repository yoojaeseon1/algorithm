package programmers;

public class StealingRetry {

	public static void main(String[] args) {
		
		int[] money = {1, 2, 3, 1};
		
		System.out.println(solution(money));

	}

	public static int solution(int[] money) {
		int answer = 0;

		int[][] sumMoney = new int[money.length][4];

		sumMoney[0][0] = money[0];
		sumMoney[0][1] = 0;
		sumMoney[0][2] = 0;
		sumMoney[0][3] = 0;

		for (int moneyI = 1; moneyI < money.length - 1; moneyI++) {

			sumMoney[moneyI][0] = sumMoney[moneyI - 1][1] + money[moneyI];
			sumMoney[moneyI][1] = Math.max(sumMoney[moneyI - 1][0], sumMoney[moneyI - 1][1]);
			sumMoney[moneyI][2] = sumMoney[moneyI - 1][3] + money[moneyI];
			sumMoney[moneyI][3] = Math.max(sumMoney[moneyI - 1][2], sumMoney[moneyI - 1][3]);
			

		}

		for (int moneyI = 0; moneyI < 4; moneyI++) {
			answer = Math.max(answer, sumMoney[sumMoney.length - 2][moneyI]);
		}

		answer = Math.max(answer, sumMoney[sumMoney.length - 2][3] + money[money.length - 1]);

		return answer;
	}

}
