package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1541 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder formula = new StringBuilder(br.readLine());
		StringBuilder tempOperand = new StringBuilder();
		long tempSum = 0;
		long resultSum = 0;
		boolean minusFlag = false;
		int formulaIndex = 0;
		char sign = ' ';

		while (formula.charAt(formulaIndex) != '+' && formula.charAt(formulaIndex) != '-') {
			tempOperand.append(formula.charAt(formulaIndex));
			formulaIndex++;
			if (formulaIndex == formula.length()) // not exist operator(ex)
													// input : 12345)
				break;
		}

		resultSum += Integer.parseInt(tempOperand.toString());
		tempOperand.setLength(0);

		for (int fi = formulaIndex; fi < formula.length(); fi++) {
			sign = formula.charAt(fi);
			int fj = fi + 1; // 한 번의 루프마다 지워지고 생성되는 건지 아니면 루프마다 생성되고 전체가 끝나면 한
								// 번에 다 지워지는 건지 확인
			while (fj < formula.length() && formula.charAt(fj) != '+' && formula.charAt(fj) != '-') {
				tempOperand.append(formula.charAt(fj));
				fj++;
			}
			if (sign == '+') {
				if (minusFlag) {
					tempSum += Integer.parseInt(tempOperand.toString());
					tempOperand.setLength(0);
				} else {
					resultSum += Integer.parseInt(tempOperand.toString());
					tempOperand.setLength(0);
				}
			} else { // sign == '-'
				if (minusFlag) {
					resultSum -= tempSum;
					tempSum = Integer.parseInt(tempOperand.toString());
					tempOperand.setLength(0);
					minusFlag = true;
				} else {
					tempSum += Integer.parseInt(tempOperand.toString());
					tempOperand.setLength(0);
					minusFlag = true;
				}
			}
			fi = fj - 1;
		}

		if (minusFlag)
			resultSum -= tempSum;

		System.out.println(resultSum);
		
		
//		String getEx = br.readLine();
//		String[] tokenStrMinus = getEx.split("-");
//		
//		int result = countStr(tokenStrMinus[0]);
//		
//		for(int i = 1; tokenStrMinus.length > i; i++) {
//			result -= countStr(tokenStrMinus[i]);
//		}
//		
//		System.out.println(result);
		
		
	}
	
	
//	public static int countStr(String str) {
//		String[] tokenStrPlus = str.split("\\+");
//		int sum = 0;
//		for(int i = 0; i < tokenStrPlus.length; i++) {
//			sum += Integer.parseInt(tokenStrPlus[i]);			
//		}
//		
//		return sum;
//	}

}
