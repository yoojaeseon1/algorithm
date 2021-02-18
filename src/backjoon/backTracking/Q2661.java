package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2661 {

	static int n;
	static StringBuilder answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sequence = new StringBuilder();

		 n = Integer.parseInt(br.readLine());

		answer = new StringBuilder();
		dfs(sequence);
		System.out.println(answer);
	}

	public static void dfs(StringBuilder sequence) {
		if (answer.length() > 0) {
			return;
		} else if (sequence.length() == n) {
			answer.append(sequence);
		} else {
			for (int i = 1; i <= 3; i++) {
				sequence.append(i);
				if (checkGood(sequence)) {
					dfs(sequence);
				}
				sequence.deleteCharAt(sequence.length() - 1);
			}
		}
	}

	public static boolean checkGood(StringBuilder sequence) {
		
		int seqLength = sequence.length();
		int start = seqLength - 1;
		int end = seqLength;

		for (int i = 1; i <= seqLength / 2; i++) { // i의 의미 : 비교하는 문자열의 길이, 범위의 의미 : 비교해야하는 문자열의 최대 길이
			if (sequence.substring(start - i, end - i).equals(sequence.substring(start, end))) {
				return false;
			}
			start--;
		}
		return true;
	}
}
