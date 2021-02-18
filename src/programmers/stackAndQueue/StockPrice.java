package programmers.stackAndQueue;

public class StockPrice {

	public static void main(String[] args) {

		int[] prices = {1, 2, 3, 2, 3 };
//		int[] prices = {1,5,6,7,8,4,9,10};

		System.out.println(solution(prices));

	}

	public static int[] solution(int[] prices) {

		int[] priceKeepCounts = new int[prices.length];

		for (int pi = 0; pi < prices.length; pi++) {
			int keepPriceCount = 1;

			for (int pj = pi + 1; pj < prices.length; pj++) {
				if (prices[pj] >= prices[pi]) {
					keepPriceCount++;
				} else {
					priceKeepCounts[pi] = keepPriceCount;
					break;
				}
			}
			
			if(keepPriceCount == priceKeepCounts.length - pi) 
				priceKeepCounts[pi] = keepPriceCount - 1;
		}
		
		priceKeepCounts[priceKeepCounts.length - 1] = 0;

		return priceKeepCounts;
	}
}