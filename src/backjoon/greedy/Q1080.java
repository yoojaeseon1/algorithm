package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1080 {
	
	static boolean[][] arrayA;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder tempLine = new StringBuilder();

		arrayA = new boolean[N][M];
		boolean[][] arrayB = new boolean[N][M];

		for (int ai = 0; ai < arrayA.length; ai++) {
			tempLine.append(br.readLine());
			for (int aj = 0; aj < arrayA[0].length; aj++) {
				if (tempLine.charAt(aj) == '1')
					arrayA[ai][aj] = true;
				else
					arrayA[ai][aj] = false;
			}
			tempLine.setLength(0);
		}
		for (int bi = 0; bi < arrayB.length; bi++) {
			tempLine.append(br.readLine());
			for (int bj = 0; bj < arrayB[0].length; bj++) {
				if (tempLine.charAt(bj) == '1')
					arrayB[bi][bj] = true;
				else
					arrayB[bi][bj] = false;
			}
			tempLine.setLength(0);
		}

		int calculationCount = 0;
		boolean breakCheck = false;
		for (int ai = 0; ai < arrayA.length - 2; ai++) {
			for (int aj = 0; aj < arrayA[0].length - 2; aj++) {
				if (checkEqualTwoArray(arrayA, arrayB)) {
					breakCheck = true;
					break;
				}
				calculationCount++;
				reverseArray(ai, aj);
			}
			if (breakCheck)
				break;
		}
		System.out.println(calculationCount);
	}

	public static void reverseArray(int startI, int startJ) {

		for (int ai = startI; ai < startI + 3; ai++) {
			for (int aj = startJ; aj < startJ + 3; aj++) {
				arrayA[ai][aj] = !arrayA[ai][aj];
			}
		}
	}

	public static boolean checkEqualTwoArray(boolean[][] arr1, boolean[][] arr2) {

		for (int ai = 0; ai < arr1.length; ai++) {
			for (int aj = 0; aj < arr1[0].length; aj++) {
				if (arr1[ai][aj] != arr2[ai][aj])
					return false;
			}
		}
		return true;
	}

}
