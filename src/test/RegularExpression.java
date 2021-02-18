package test;

import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		
		
//		String expression = "100-200*300-500+20";
		String expression = "100-200+300+500-20";
		
		
		
		
//		String[] splitedExpression = expression.split("\\d{2}");
//		String[] splitedExpression = expression.split("[^' ']");
//		String[] splitedExpression = expression.split("[-]");
//		
//		for(String number : splitedExpression) {
//			
//			System.out.println("value : " + number);
//			
//		}

		String pattern = "[0-9A-Za-z]{1,15}@[a-z]{1,10}.[a-z]{1,5}";
		
		String input = "you8054@nate.com";
		boolean validationofInput = Pattern.matches(pattern, input);
		System.out.println(validationofInput);
		
		input = "you8054@nate.com.com";
		validationofInput = Pattern.matches(pattern, input);
		System.out.println(validationofInput);
		
		pattern = "\\d{6}-[1-4]\\d{6}";
		input = "930114-1216014";
		validationofInput = Pattern.matches(pattern, input);
		
		System.out.println(validationofInput);
		
		input = "930114-5216014";
		validationofInput = Pattern.matches(pattern, input);
		
		System.out.println(validationofInput);
		
	}

}
