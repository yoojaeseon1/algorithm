package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4948 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNum;
		int primeCount = 0;
		int max = 123456 * 2;
		boolean[] primeCheck = new boolean[max + 1];

		for (int i = 2; i <= max; i++) {
			if (!primeCheck[i]) {
				for (int j = i + i; j <= max; j += i) {
					primeCheck[j] = true;
				}
			}
		}

		while (true) {
			inputNum = Integer.parseInt(br.readLine());
			if (inputNum == 0)
				break;

			for (int i = inputNum + 1; i <= inputNum * 2; i++) {
				if (!primeCheck[i]) {
					primeCount++;
				}
			}
			System.out.println(primeCount);
			primeCount = 0;
		}
		
		// correct but very slow

		// boolean primeCheck = true;
		// int sqrtOfInput;
		// int startNum;

		// while (true) {
		// inputNum = Integer.parseInt(br.readLine());
		// if (inputNum == 0)
		// break;
		// // sqrtOfInput = (int)Math.sqrt(inputNum);
		// if (inputNum == 1 || inputNum == 2 || inputNum == 3 || inputNum == 5
		// || inputNum == 7) {
		// primeCount = 1;
		// } else {
		// for (int i = inputNum + 1; i <= inputNum * 2; i++) {
		// if (i % 2 == 1) {
		// for (int j = 3; j <= (int) Math.sqrt(i); j += 2) {
		// if (i % j == 0) {
		// primeCheck = false;
		// break;
		// }
		// }
		// if (primeCheck)
		// primeCount++;
		// else
		// primeCheck = true;
		// }
		// }
		// }
		// System.out.println(primeCount);
		// primeCount = 0;
		// }

		// timeover

//		 while (true) {
//		 inputNum = Integer.parseInt(br.readLine());
//		 if (inputNum == 0)
//		 break;
//		 if (inputNum % 2 == 0)
//		 startNum = inputNum + 1;
//		 else
//		 startNum = inputNum + 2;
//		 for (int i = startNum; i <= inputNum * 2; i += 2) {
//		 if (i % 2 == 1) {
//		 for (int j = 3; j < i; j += 2) {
//		 if (i % j == 0) {
//		 primeCheck = false;
//		 break;
//		 }
//		 }
//		 if (primeCheck)
//		 primeCount++;
//		 else
//		 primeCheck = true;
//		 }
//		 }
//		 System.out.println(primeCount);
//		 primeCount = 0;
//		 }
	}
}
