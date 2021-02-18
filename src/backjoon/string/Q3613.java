package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3613 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder variable = new StringBuilder(br.readLine());

		boolean isJava = false;
		boolean isCpp = false;
		boolean underBarCheck = false;
		char tempChar;

		if (!((int) variable.charAt(0) >= 97 && (int) variable.charAt(0) <= 122) || variable.charAt(variable.length() - 1) =='_') {
			System.out.println("Error!");
		} else {
			for (int i = 1; i < variable.length(); i++) {
				if (isJava && isCpp) {
					break;
				}
				tempChar = variable.charAt(i);

				if ((int) tempChar >= 65 && (int) tempChar <= 90) {
					variable.replace(i, i + 1, "_" + (char) ((int) tempChar + 32));
					isJava = true;
					i++;
				} else if (tempChar == '_') {
					if(variable.charAt(i+1) == '_' || (variable.charAt(i+1) >= 65 && (int) variable.charAt(i+1) <= 90)) {
						underBarCheck = true;
						break;
					}
					variable.replace(i, i + 2, "" + (char) ((int) variable.charAt(i + 1) - 32));
					isCpp = true;
				}
			}

			if ((isJava && isCpp) || underBarCheck) {
				System.out.println("Error!");
			} else {
				System.out.println(variable);
			}
		}
	}

}
