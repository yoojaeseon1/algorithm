package backjoon.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5052 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int testCases = 1; testCases <= t; testCases++) {

			int n = Integer.parseInt(br.readLine());

			String[] phoneNumbers = new String[n];

			for (int phoneI = 0; phoneI < n; phoneI++) {
				phoneNumbers[phoneI] = br.readLine();
			}

			Arrays.sort(phoneNumbers);

			boolean isConsistent = true;
			for (int phoneI = 0; phoneI < phoneNumbers.length - 1; phoneI++) {

				if (phoneNumbers[phoneI].length() < phoneNumbers[phoneI + 1].length()
						&& phoneNumbers[phoneI + 1].indexOf(phoneNumbers[phoneI]) >= 0) {
					isConsistent = false;
					break;
				}
			}

			if (isConsistent)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

}
