package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitToHangle {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// StringBuilder inputNum = new StringBuilder(br.readLine());
		String inputNum = "10000";
		int reversedIndex = 0;
		char currentDigit;
		StringBuilder result = new StringBuilder();

		String[] digits = { "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };

		String[] units = { "", "만", "억", "조", "경" };
		int unitCheck = 1;

		String[] units2 = { "", "십", "백", "천" };

		for (int i = inputNum.length() - 1; i >= 0; i--) {
			currentDigit = inputNum.charAt(i);
			System.out.println("currentDigit : " + currentDigit);
			if (currentDigit != '0') {
				unitCheck++;
			}
			if (reversedIndex % 4 != 0) {
				if (currentDigit != '0') {
					result.insert(0, units2[reversedIndex % 4]);
				}
				if (currentDigit != '1') {
					result.insert(0, digits[(int) currentDigit - 48]);
				}
				System.out.println(result);
			} else {
				if (unitCheck == 0) {
					result.delete(0, 1);
				}
				result.insert(0, units[reversedIndex / 4]);
				if(reversedIndex != 0) {
					unitCheck = 0;
				}
				result.insert(0, digits[(int) currentDigit - 48]);
				System.out.println(result);
			}
			reversedIndex++;
		}

		System.out.println(result);

	}

}
