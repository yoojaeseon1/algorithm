package programmers.DFS;

import java.util.ArrayList;
import java.util.List;

// using combination

// https://programmers.co.kr/learn/courses/30/lessons/43165

public class TargetNumberFail2 {
	
	
	static List<List<Integer>> combiList;
	
	public static void main(String[] args) {
		
		int[] source = {1,1,1,1,1};
		
		System.out.println(solution(source, 3));

	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		combiList = new ArrayList<>();
		
		int[] selectedIndices = new int[numbers.length];
		
		for(int ni = 1; ni <= numbers.length; ni++) {
			
			doCombination(numbers, numbers.length, ni, selectedIndices, 0, 0);
			
		}
		
		int sumOfNumbers = 0;
		
		for(int ni = 0; ni < numbers.length; ni++) {
			sumOfNumbers += numbers[ni];
		}
		
		
		for(int ci = 0; ci < combiList.size(); ci++) {
			int minucedSum = sumOfNumbers;
			for(int cj = 0; cj < combiList.get(ci).size(); cj++) {
				minucedSum -= (numbers[combiList.get(ci).get(cj)] * 2);
			}
			if(target == minucedSum) {
				answer++;
			}
		}
		return answer;
	}
	

	
	
	public static void doCombination(int[] source, int n, int r, int[] selectedIndices, int selectedIndex,  int target) {
		
		if(r == 0) {
			
			List<Integer> currentCombiList = new ArrayList<>();
			for(int si = 0; si < selectedIndex; si++) {
				currentCombiList.add(selectedIndices[si]);

			}

			combiList.add(currentCombiList);
			
		} else if(n == target) return;
		else {
			
			selectedIndices[selectedIndex] = target;
			doCombination(source, n, r-1, selectedIndices, selectedIndex+1, target+1);
			
			doCombination(source, n, r, selectedIndices, selectedIndex, target+1);

		}
	
	}

}
