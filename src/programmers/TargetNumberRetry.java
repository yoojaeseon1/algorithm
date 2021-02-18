package programmers;

import java.util.Arrays;

public class TargetNumberRetry {

	public static void main(String[] args) {

//		 int[] numbers = {1, 1, 1, 1, 1};
//		 int target = 3;
		 int[] numbers = {1, 2,3,4,5};
		 int target = 9;
//		int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };
//		int target = 20;

		System.out.println(solution(numbers, target));

	}

	static int answer;

	public static int solution(int[] numbers, int target) {
		answer = 0;

		int sumNumbers = 0;

		for (int number : numbers) {
			sumNumbers += number;
		}
//
//		System.out.println("calculatedNumber : " + calculatedNumber);

		// doDFS(numbers, calculatedNumber, target);
		
		int[] selectedIndices;
		
		for(int r = 1; r <= numbers.length; r++) {
			selectedIndices = new int[numbers.length];
			doCombination(numbers, numbers.length, r, selectedIndices, 0, 0, target, sumNumbers);
			
		}

		return answer;
	}

	public static void doCombination(int[] source, int n, int r, int[] selectedIndices, int selectedIndex,
			int targetIndex, int target, int sumNumbers) {
		
		
		if(r == 0) {
			
			for(int selectedI = 0; selectedI < selectedIndex; selectedI++) {
				
				sumNumbers -= source[selectedIndices[selectedI]] * 2;
				
			}
			
			if(sumNumbers == target) 
				answer++;

			return;
			
		} else if(targetIndex == n)
			return;
		
		
		selectedIndices[selectedIndex] = targetIndex;
		
		doCombination(source, n, r-1, selectedIndices, selectedIndex+1, targetIndex+1, target, sumNumbers);
		doCombination(source, n, r, selectedIndices, selectedIndex, targetIndex+1, target, sumNumbers);
		
		

	}
	
	// can't solve by using DFS

	// public static void doDFS(int[] numbers, int calculatedValue, int target)
	// {
	//
	// System.out.println(Arrays.toString(numbers));
	// if(calculatedValue < target)
	// return;
	// else if(calculatedValue == target) {
	// answer++;
	// return;
	// }
	//
	// for(int numbersI = 0; numbersI < numbers.length; numbersI++) {
	//
	// if(numbers[numbersI] > 0) {
	// calculatedValue -= numbers[numbersI] * 2;
	// numbers[numbersI] *= -1;
	// doDFS(numbers, calculatedValue, target);
	//// numbers[numbersI] *= -1;
	//// calculatedValue += numbers[numbersI] * 2;
	// }
	// }
	// }

}
