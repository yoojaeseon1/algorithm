package programmers.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// time over

public class TheBiggestNumberFail {
	
	static List<String> combineList;

	public static void main(String[] args) {

		int[] numbers = { 6, 10, 2 };

		System.out.println(solution(numbers));

	}

	public static String solution(int[] numbers) {

		StringBuilder answer = new StringBuilder();
		
		combineList = new ArrayList<>();
		
		boolean[] isVisited = new boolean[numbers.length];
		int[] selectedIndices = new int[numbers.length];
		
		doPermutation(numbers, numbers.length, numbers.length, isVisited, selectedIndices, 0);
		
		Collections.sort(combineList, Collections.reverseOrder());
		
		return combineList.get(0);
	}

	public static void doPermutation(int[] source, int n, int r, boolean[] isVisited, int[] selectedIndices,
			int selectedIndex) {
		
		if(r==0) {
			StringBuilder combinedString = new StringBuilder();
			for(int si = 0; si < selectedIndex; si++) {
				combinedString.append(source[selectedIndices[si]]);
			}
//			System.out.println(combinedString);
			combineList.add(combinedString.toString());
			
			return;
			
		}
		else {
			
			for(int vi = 0; vi < n; vi++) {
				
				if(!isVisited[vi]) {
					isVisited[vi] = true;
					selectedIndices[selectedIndex] = vi;
					doPermutation(source, n, r-1, isVisited, selectedIndices, selectedIndex+1);
					isVisited[vi] = false;
					selectedIndices[selectedIndex] = 0;
				}
			}
		}
	}

}
