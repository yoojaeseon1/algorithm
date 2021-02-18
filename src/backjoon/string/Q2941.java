package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2941 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder inputString = new StringBuilder(br.readLine());
		char curChar;
		int totalCount = 0;
		int startIndex = 0;

		for (int i = 1; i < inputString.length(); i++) {
			curChar = inputString.charAt(i);
			if (curChar == '=' || curChar == '-' || curChar == 'j') {
				if (curChar == '=') {
					if (i != 1 && inputString.charAt(i - 1) == 'z' && inputString.charAt(i - 2) == 'd') {
						totalCount++; // 위의 if문 한번 걸치고 온다.
						totalCount += (i - 2) - startIndex;
						startIndex = i + 1;
					} else if (inputString.charAt(i - 1) == 'c' || inputString.charAt(i - 1) == 's'
							|| inputString.charAt(i - 1) == 'z') {
						totalCount++;
						totalCount += (i - 1) - startIndex;
					}
					startIndex = i + 1;
				} else if (curChar == '-') {
					if (inputString.charAt(i - 1) == 'c' || inputString.charAt(i - 1) == 'd') {
						totalCount++;
						totalCount += (i - 1) - startIndex;
						startIndex = i + 1;
					}
				} else if (curChar == 'j') {
					if (inputString.charAt(i - 1) == 'l' || inputString.charAt(i - 1) == 'n') {
						totalCount++;
						totalCount += (i - 1) - startIndex;
						startIndex = i + 1;
					}
				}
			}
		}
		if (startIndex != inputString.length()) {
			totalCount += inputString.length() - startIndex;
		}
		System.out.println(totalCount);

		// ----------------------------- another answer

		// String inputString = br.readLine();
		//
		// String[] croatias = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=",
		// "z="};
		//
		// for(int i = 0; i < croatias.length; i++) {
		// inputString = inputString.replace(croatias[i], "0"); // 계속 String
		// 인스턴스 생성(실행할 때마다 heap영역에 쌓인다.)
		// }
		//
		// System.out.println(inputString);
		// System.out.println(inputString.length());
	}
}
