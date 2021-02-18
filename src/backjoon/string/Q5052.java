package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q5052 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= testCases; testCase++) {

			int numPhoneNumbers = Integer.parseInt(br.readLine());

			String[] phoneNumbers = new String[numPhoneNumbers];

			for (int phoneI = 0; phoneI < phoneNumbers.length; phoneI++)
				phoneNumbers[phoneI] = br.readLine();

			Arrays.sort(phoneNumbers);
			if (isConsistentNumbers(phoneNumbers))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	public static boolean isConsistentNumbers(String[] phoneNumbers) {

		String currentNumber = phoneNumbers[0];
		for (int phoneI = 1; phoneI < phoneNumbers.length; phoneI++) {
			
			String comparedNumber = phoneNumbers[phoneI];
			
			if(currentNumber.length() >= comparedNumber.length()) {
				currentNumber = comparedNumber;
				continue;
			}
			
			if(currentNumber.equals(comparedNumber.substring(0,currentNumber.length())))
				return false;
			
			currentNumber = comparedNumber;
			
		}

		return true;

	}

}
