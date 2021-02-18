package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1509 {

	static StringBuilder input;
	static List<StringBuilder> answerList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = "haha";
		input = new StringBuilder(br.readLine());
		answerList = new ArrayList<>();

		checkPalin(0, input.length(), input);

		System.out.println("answer's size : " + answerList.size());

		// System.out.println(input.length());
	}

	static void checkPalin(int startIndex, int endIndex, StringBuilder splited) {
		System.out.println("start index : " + startIndex);
		System.out.println("end index : " + endIndex);

		StringBuilder splitedInput = new StringBuilder();
		StringBuilder oneOfAnswer = new StringBuilder();
		StringBuilder tempPalin = new StringBuilder();
		splitedInput.append(splited.subSequence(startIndex, endIndex));
		int centerIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		boolean oneDigitCheck = false;
		if (splitedInput.length() == 1) {
			System.out.println("added");
			answerList.add(splitedInput);
			oneDigitCheck = true;
		} else if (splitedInput.length() % 2 == 0) {
			leftIndex = (splitedInput.length() / 2) - 1;
			rightIndex = splitedInput.length() / 2;
		} else {
			centerIndex = splitedInput.length() / 2;
//			oneOfAnswer.append(splitedInput.charAt(centerIndex));
			leftIndex = centerIndex - 1;
			rightIndex = centerIndex + 1;
		}
		System.out.println("splited input : " + splitedInput);
		System.out.println("splited input's length : " + splitedInput.length());
		System.out.println("center index : " + centerIndex);
		System.out.println("right index : " + rightIndex);
		System.out.println("left index : " + leftIndex);

		if (splitedInput.length() == 1) {
			System.out.println("length is 1");
			oneOfAnswer.append(splitedInput.subSequence(0, 1));
			System.out.println("added");
			answerList.add(oneOfAnswer);
			return;
		} else if (splitedInput.length() == 2) {
			System.out.println("length is 2");
			if (splited.toString().equals(splited.reverse().toString())) {
				oneOfAnswer.append(splited.subSequence(0, 2));
				System.out.println("added");
				answerList.add(oneOfAnswer);
				return;
			} else {
				oneOfAnswer.append(splited.subSequence(0, 1));
				System.out.println("added");
				System.out.println("added");
				answerList.add(oneOfAnswer);
				answerList.add(oneOfAnswer);
				return;
			}
		}

		while (leftIndex >= 0 && !oneDigitCheck) { // equals rightIndex <
													// input.length()
			tempPalin.setLength(0);
			tempPalin.append(splitedInput.substring(leftIndex, rightIndex + 1));
			System.out.println("temp paline : " + tempPalin);
			System.out.println("reversed temp paline : " + tempPalin.reverse());
			System.out.println(tempPalin.toString().equals(tempPalin.reverse().toString()));
			if (tempPalin.toString().equals(tempPalin.reverse().toString())) {
				System.out.println("palin!!");
				rightIndex++;
				leftIndex--;
			} else {
				if (tempPalin.length() == 2) {
					// oneOfAnswer.append(tempPalin.subSequence(0, 2)); //
					// equals
					// subSequence(leftIndex + 1, rightIndex)
					System.out.println("false left : " + leftIndex);
					System.out.println("false right : " + rightIndex);
					checkPalin(0, leftIndex + 1, splitedInput);
					checkPalin(rightIndex, splitedInput.length(), splitedInput);
				} else if (tempPalin.length() == 3) {
//					System.out.println("before one of answer : " + oneOfAnswer);
					System.out.println("splited : " + splitedInput.subSequence(leftIndex + 1, rightIndex));
					oneOfAnswer.append(splitedInput.subSequence(leftIndex + 1, rightIndex));
					System.out.println("added word 3: " + oneOfAnswer);
					answerList.add(oneOfAnswer);
					checkPalin(0, leftIndex + 1, splitedInput);
					checkPalin(rightIndex, splitedInput.length(), splitedInput);
				} else {
					// else if(tempPalin.length() == 3) {
					oneOfAnswer.append(splitedInput.subSequence(leftIndex + 1, rightIndex));
					System.out.println("added word else: " + oneOfAnswer);
					answerList.add(oneOfAnswer);
					checkPalin(0, leftIndex + 1, splitedInput);
					checkPalin(rightIndex, splitedInput.length(), splitedInput);
				}
				// }
				// oneOfAnswer.append(splitedInput.subSequence(leftIndex + 1,
				// rightIndex));
				// oneOfAnswer.append(tempPalin.subSequence(start, end))
				// System.out.println("one of answer : " + oneOfAnswer);
				// answerList.add(oneOfAnswer);
				// checkPalin(0, leftIndex + 1);
				// checkPalin(rightIndex, input.length());
				break;
			}
			// if(splitedInput.substring(leftIndex,
			// rightIndex+1).equals(splitedInput.substring(leftIndex,
			// rightIndex+1).))
		}
		// if (tempPalin.length() == splitedInput.length()) {
		// answerList.add(tempPalin);
		// }
	}
}
