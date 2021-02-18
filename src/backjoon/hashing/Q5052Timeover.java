package backjoon.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5052Timeover {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int testCases = 1; testCases <= t; testCases++) {

			int n = Integer.parseInt(br.readLine());

			String[] phoneNumbers = new String[n];

			for (int phoneI = 0; phoneI < n; phoneI++) {
				phoneNumbers[phoneI] = br.readLine();
			}

//			Arrays.sort(phoneNumbers);

			boolean isConsistent = true;
			
			for (int pi = 0; pi < phoneNumbers.length; pi++) {

//				String baseNumber = phone_book[pi];

				for (int pj = pi + 1; pj < phoneNumbers.length; pj++) {

					if (phoneNumbers[pj].length() > phoneNumbers[pi].length()) {
						if (isEqualChars(phoneNumbers[pi], phoneNumbers[pj]))
							isConsistent = false;
					} else {
						if (isEqualChars(phoneNumbers[pj], phoneNumbers[pi]))
							isConsistent = false;
					}

				}
			}
			if(isConsistent)
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}
	
	public static boolean isEqualChars(String str1, String str2) {

		for (int si = 0; si < str1.length(); si++) {
			if (str1.charAt(si) != str2.charAt(si))
				return false;
		}
		return true;
	}

}
