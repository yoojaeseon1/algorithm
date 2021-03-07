package algorithmSkills;

public class LcmGcd {
	
	
	public static void main(String[] args) {
		
		int[] arr = {6,12,18};
		
		
		
		System.out.println(solution(arr));
		
		
//		System.out.println(gcd(arr));

	}
	
	public static int solution(int[] arr) {
		
	      int answer = calculdateLcm(arr);
	      
	      return answer;
	  }
	
	//lcm(multiple numbers)
	
	public static int calculdateLcm(int[] numbers) {
		
		int answer = numbers[0];
		
		for(int numbersI = 1; numbersI < numbers.length ; numbersI++ ){

			int smaller = Math.min(answer,  numbers[numbersI]);
			int bigger = Math.max(answer, numbers[numbersI]);
			
			answer = (smaller * bigger) / calculateGcd(smaller, bigger);
		}
		
		return answer;
		
	}
	
	// gcd(two numbers)
	
	public static int calculateGcd(int number1, int number2) {
		
		int answer = 0;

		int smaller = Math.min(number1, number2);
		int bigger = Math.max(number1, number2);

		for(int divider = 1; divider <= smaller; divider++) {
			if(smaller % divider == 0 && bigger % divider == 0)
				answer = divider;
		}

		return answer;
	}
	
	// gcd(multiple numbers)
	
	public static int calculateGcd(int[] numbers) {
		
		int answer = numbers[0];
		
		for(int numbersI = 1; numbersI < numbers.length; numbersI++) {
			
			answer = calculateGcd(answer, numbers[numbersI]);
			
		}

		return answer;

	}

}
