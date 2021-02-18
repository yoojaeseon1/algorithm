package programmers.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class TheBiggestNumber {

	public static void main(String[] args) {

//		 int[] numbers = { 6, 10, 2 };
		int[] numbers = { 3, 30, 34, 5, 9 };

		System.out.println(solution(numbers));

	}

	public static String solution(int[] numbers) {

		StringBuilder answer = new StringBuilder();

		String[] numbersToStr = new String[numbers.length];

		for (int ni = 0; ni < numbersToStr.length; ni++) {
			numbersToStr[ni] = Integer.toString(numbers[ni]);
		}

		Arrays.sort(numbersToStr, (o1,o2)->(o2+o1).compareTo(o1+o2));
		
		
//		Arrays.sort(numbersToStr, (o1,o2)->o1.compareTo(o2));
		
		Arrays.sort(numbersToStr, new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				
				return arg0.compareTo(arg1);
			}
			
		});

		for (int ni = 0; ni < numbersToStr.length; ni++) {
			System.out.println(numbersToStr[ni]);
			answer.append(numbersToStr[ni]);
		}
		
		System.out.println("----------");
		System.out.println(numbersToStr[2].compareTo(numbersToStr[3]));

		return answer.toString();
	}

}
