package backjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5585 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] kindOfCoin = { 500, 100, 50, 10, 5, 1 };
		int amount = Integer.parseInt(br.readLine());
		int changedAmount = 1000 - amount;
		int totalCoinCount = 0;
		int tempCoinCount;
		for (int i = 0; i < kindOfCoin.length; i++) {
			if (changedAmount / kindOfCoin[i] > 0) {
				tempCoinCount = changedAmount / kindOfCoin[i];
				totalCoinCount += tempCoinCount;
				changedAmount -= kindOfCoin[i] * tempCoinCount;
			}
		}
		System.out.println(totalCoinCount);
	}

}
