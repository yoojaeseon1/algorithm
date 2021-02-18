package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1157 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder word = new StringBuilder();
		char result = ' ';
		int max = 0;
		boolean dupCheck = false;

		int[] alpha = new int[26];

		word.append(br.readLine().toUpperCase());

		for (int i = 0; i < word.length(); i++) {
			alpha[(int) word.charAt(i) - 65]++;
		}

		for (int i = 0; i < alpha.length; i++) {
			max = Math.max(max, alpha[i]);
		}

		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] == max && dupCheck) {
				result = '?';
				break;
			}
			if (alpha[i] == max) {
				result = (char) (i + 65);
				dupCheck = true;
			}
		}

		System.out.println(result);
	}

}
