package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1032 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringBuilder fileInDir = new StringBuilder(br.readLine());

		char[] patternChars = new char[fileInDir.length()];

		for (int pi = 0; pi < fileInDir.length(); pi++) {
			patternChars[pi] = fileInDir.charAt(pi);
		}

		for (int fileCount = 0; fileCount < N - 1; fileCount++) {
			fileInDir.setLength(0);
			fileInDir.append(br.readLine());
			for (int ci = 0; ci < fileInDir.length(); ci++) {
				if (fileInDir.charAt(ci) != patternChars[ci])
					patternChars[ci] = ' ';
			}
		}

		StringBuilder pattern = new StringBuilder();

		for (int pi = 0; pi < patternChars.length; pi++) {
			if (patternChars[pi] == ' ')
				pattern.append('?');
			else
				pattern.append(patternChars[pi]);
		}
		System.out.println(pattern);
	}
}
