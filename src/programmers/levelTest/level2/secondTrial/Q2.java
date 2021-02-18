package programmers.levelTest.level2.secondTrial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q2 {

	public static void main(String[] args) {

		String expression = "100-200*300-500+20";
//		String expression = "50*6-3*2";

		// String[] numbers = expression.split("[^0-9]");

		// System.out.println(Arrays.toString(numbers));
		// System.out.println(Arrays.toString(symbols));

		System.out.println(solution(expression));
		
//		List<Integer> numbers = new LinkedList<>();
		
//		numbers.add(1);
//		numbers.add(2);
//		numbers.add(3);
//		numbers.add(4);
//	
//		numbers.remove(1);
//		numbers.remove(1);
//		
//		numbers.add(1, 5);
//		
//		
//		System.out.println(numbers);
//		
//		System.out.println(computeNumber("-5", "-10", '+'));

	}

	public static long solution(String expression) {
        long answer = 0;
        
//		String[] numbers = expression.split("\\D");
		String[] numbers = expression.split("[^0-9]");
		List<String> numberList = new LinkedList<>();
		
		Collections.addAll(numberList, numbers);
        
		
		
        List<Character> symbols = new LinkedList<>();
        
        for(int expI = 0; expI < expression.length(); expI++) {
        	char currentChar = expression.charAt(expI);
        	if(currentChar == '+' || currentChar == '-' || currentChar == '*')
        		symbols.add(currentChar);
        }
        
        List<Character> copiedSymbols = new LinkedList<>(symbols);
        
//        System.out.println(symbols);
        
        
        List<String> computedCases = new ArrayList<>();
        
        computedCases.add("+-*");
        computedCases.add("+*-");
        computedCases.add("-+*");
        computedCases.add("-*+");
        computedCases.add("*+-");
        computedCases.add("*-+");
         
        
        for(int computedI = 0; computedI < computedCases.size(); computedI++) {
        	
        	String computedCase = computedCases.get(computedI);
        	
        	for(int caseI = 0; caseI < computedCase.length(); caseI++) {
        		char currentSymbol = computedCase.charAt(caseI);
//        		System.out.println("currentSymbol : " + currentSymbol);
        		for(int symbolsI = 0; symbolsI < symbols.size(); symbolsI++) {
        			
        			char symbol = symbols.get(symbolsI);
        			
        			if(symbol == currentSymbol) {
        				
//        				for(int symbolsJ = 0; symbolsJ < symbols.size(); symbolsJ++) {
//        					System.out.print(symbols.get(symbolsJ) + " ");
//        				}
//        				System.out.println();
        				
        				long computedNumber = computeNumber(numberList.get(symbolsI), numberList.get(symbolsI+1), symbol);
//        				System.out.println("computedNumber : " + computedNumber);
        				
        				numberList.remove(symbolsI);
        				numberList.remove(symbolsI);
        				numberList.add(symbolsI, Long.toString(computedNumber));
        				
        				symbols.remove(symbolsI);
        				symbolsI--;
        				
//        				for(int symbolsJ = 0; symbolsJ < symbols.size(); symbolsJ++) {
//        					System.out.print(symbols.get(symbolsJ) + " ");
//        				}
//        				System.out.println();
        			}
        		}
        	}
//        	System.out.println("last computedNumber : " + numberList.get(0));
        	answer = Math.max(answer, Math.abs(Long.parseLong(numberList.get(0))));
//        	System.out.println("symbols's size : " + symbols.size());
        	numberList = new LinkedList<>();
        	Collections.addAll(numberList, numbers);
        	symbols = new LinkedList<>(copiedSymbols);
//        	System.out.println("answer : " + answer);
//        	System.out.println("---------");
        	
        }
        
        
        return answer;
    }

	public static long computeNumber(String operand1, String operand2, char symbol) {

		long parsedOperand1 = Long.parseLong(operand1);
		long parsedOperand2 = Long.parseLong(operand2);

		long computedValue = 0;

		switch (symbol) {
			case '+':
				computedValue = parsedOperand1 + parsedOperand2;
				break;
			case '-':
				computedValue = parsedOperand1 - parsedOperand2;
				break;
			case '*':
				computedValue = parsedOperand1 * parsedOperand2;
				break;
		}

		return computedValue;

	}

}
