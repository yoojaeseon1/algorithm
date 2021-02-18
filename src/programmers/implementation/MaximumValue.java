package programmers.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaximumValue {

	public static void main(String[] args) {

		String expression = "100-200*300-500+20";
//		String expression = "50*6-3*2";

		System.out.println(solution(expression));
		
		
//		calculateNum("100", "200", '*');

	}

	public static long solution(String expression) {
		long answer = 0;

		List<String> numbers = new LinkedList<>();
		List<String> signs = new LinkedList<>();
		List<String> signSequences = new ArrayList<>();

		signSequences.add("+-*");
		signSequences.add("+*-");
		signSequences.add("-*+");
		signSequences.add("-+*");
		signSequences.add("*+-");
		signSequences.add("*-+");

		Collections.addAll(signs, expression.split("[0-9]+"));
		signs.remove(0);
		Collections.addAll(numbers, expression.split("[^0-9]+"));

		// for(String sign : signs) {
		// System.out.println(sign);
		// }

		// for(String number : numbers) {
		// System.out.println(number);
		// }
		
		List<String> copiedNumbers = new LinkedList<>();
		List<String> copiedSigns = new LinkedList<>();
		
		for(int sequencesI = 0; sequencesI < signSequences.size(); sequencesI++) {
			copiedNumbers = new LinkedList<>(numbers);
			copiedSigns = new LinkedList<>(signs);
			
			String sequence = signSequences.get(sequencesI);
			
			for(int sequenceI = 0; sequenceI < sequence.length(); sequenceI++) {
				
				String sign = sequence.substring(sequenceI, sequenceI+1);
				
				for(int signsI = 0; signsI < copiedSigns.size(); signsI++ ) {
					
					if(copiedSigns.get(signsI).equals(sign)) {
						
						String calculatedValue = calculateNum(copiedNumbers.get(signsI), copiedNumbers.get(signsI+1), sign);
						
						copiedNumbers.set(signsI, calculatedValue);
						
						copiedNumbers.remove(signsI+1);
						
						copiedSigns.remove(signsI);
						signsI--;
						
					}
					
				}
			}
			
			answer = Math.max(answer, Math.abs(Long.parseLong(copiedNumbers.get(0))));
			
			
//			System.out.println("calculatedValue : " + copiedNumbers.get(0));
			
		}

		return answer;
	}

	public static String calculateNum(String number1, String number2, String sign) {

		long calculatedValue = 0;
		long parsedNumber1 = Long.parseLong(number1);
		long parsedNumber2 = Long.parseLong(number2);

		switch (sign) {
		case "+":
			calculatedValue = parsedNumber1 + parsedNumber2;
			break;
		case "-":
			calculatedValue = parsedNumber1 - parsedNumber2;
			break;
		case "*":
			calculatedValue = parsedNumber1 * parsedNumber2;
			break;
		}

		String answer = Long.toString(calculatedValue);
//		System.out.println("answer : " + answer);
		
		return answer;
	}

}
