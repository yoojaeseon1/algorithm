package programmers.DFS;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/42839

public class SearchingPrime {
	
	static Set<Integer> permuSet;

	public static void main(String[] args) {

		 System.out.println(solution("17"));

	}

	public static int solution(String numbers) {

		permuSet = new HashSet<>();

		for (int ni = 1; ni <= numbers.length(); ni++) {

			boolean[] visited = new boolean[numbers.length()];
			int[] selectedIndices = new int[ni];
			doPermutation(numbers, numbers.length(), ni, selectedIndices, 0, visited);
		}

		Iterator<Integer> permuIter = permuSet.iterator();
		int maxNum = 0;
		while (permuIter.hasNext()) {
			int currentNum = (int) permuIter.next();
			maxNum = Math.max(maxNum, currentNum);
		}

		int[] prime = makePrimeArray(maxNum);
		int answer = 0;
		permuIter = permuSet.iterator();
		while (permuIter.hasNext()) {
			int currentNum = (int) permuIter.next();
			if (prime[currentNum] != 0)
				answer++;
		}

		return answer;
	}

	public static void doPermutation(String source, int n, int r, int[] selectedIndices, int selectedIndex,
			boolean[] visited) {

		if (r == selectedIndex) {
			StringBuilder permuStr = new StringBuilder();
			for (int si = 0; si < selectedIndex; si++) {
				permuStr.append(source.charAt(selectedIndices[si]));
			}
			permuSet.add(Integer.parseInt(permuStr.toString()));
			return;
		}
		for (int vi = 0; vi < n; vi++) {
			if (!visited[vi]) {
				visited[vi] = true;
				selectedIndices[selectedIndex] = vi;
				doPermutation(source, n, r, selectedIndices, selectedIndex + 1, visited);
				visited[vi] = false;
				selectedIndices[selectedIndex] = 0;
			}
		}
	}

	public static boolean checkIsPrime(int num) {

		if (num == 2)
			return true;
		else if (num <= 1 || num % 2 == 0)
			return false;
		else {
			
			for(int checkNum = 3; checkNum <= num / 2; checkNum++) {
				if(num % checkNum == 0)
					return false;
			}
			return true;
		}
	}

	public static int[] makePrimeArray(int maxNum) {

		int[] answer = new int[maxNum + 1];

		for (int ai = 2; ai <= maxNum; ai++) {
			answer[ai] = ai;
		}

		for (int ai = 2; ai <= maxNum; ai++) {
			if (answer[ai] == 0)
				continue;
			for (int aj = 2 * ai; aj <= maxNum; aj += ai) {
				answer[aj] = 0;
			}
		}

		return answer;
	}

}