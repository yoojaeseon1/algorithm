package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1213 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder hansooName = new StringBuilder();

		hansooName.append(br.readLine());

		int[] alphabets = new int[26];
		char[] palindrome = new char[hansooName.length()];
		int indexCount = 0;
		int oddCheck = 0;

		for (int i = 0; i < hansooName.length(); i++) {
			alphabets[hansooName.charAt(i) - 65]++;
		}

		for (int i = 0; i < alphabets.length; i++) {
			if (oddCheck > 1) {
				break;
			}

			while (alphabets[i] > 0) {
				if (alphabets[i] == 1) {
					oddCheck++;
					if(oddCheck > 1) {
						break;
					}
					palindrome[hansooName.length() / 2] = (char) (i + 65);
					alphabets[i]--;
				} else {
					alphabets[i] -= 2;
					palindrome[indexCount] = (char) (i + 65);
					palindrome[hansooName.length() - indexCount - 1] = (char) (i + 65);
					indexCount++;
				}
			}
		}

		if (oddCheck > 1) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			for (int i = 0; i < palindrome.length; i++) {
				System.out.print(palindrome[i]);
			}
		}
	}
}
