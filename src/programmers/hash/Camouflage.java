package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// time over in a case
// annotaion is a correct answer
public class Camouflage {
	static int answer;

	
	public static void main(String[] args) {

		String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		// String[][] clothes = { { "crow_mask", "face" }, { "blue_sunglasses",
		// "face" }, { "smoky_makeup", "face" } };

		System.out.println(solution(clothes));

	}

	public static int solution(String[][] clothes) {
		answer = 0;
//		int answer = 1;

		Map<String, Integer> clothesToCount = new HashMap<>();

		for (int ci = 0; ci < clothes.length; ci++) {

			if (clothesToCount.containsKey(clothes[ci][1]))
				clothesToCount.put(clothes[ci][1], clothesToCount.get(clothes[ci][1]) + 1);
			else
				clothesToCount.put(clothes[ci][1], 1);

		}

		int[] typeCount = new int[clothesToCount.size()];
		int typeCountIndex = 0;
		Iterator<Integer> clothesCountIter = clothesToCount.values().iterator();
		while (clothesCountIter.hasNext()) {

			typeCount[typeCountIndex++] = clothesCountIter.next();

		}


		for (int r = 1; r <= typeCount.length; r++) {

			// r means nCr 
			
			int[] selectedIndices = new int[r];

			doCombination(typeCount, typeCount.length, r, selectedIndices, 0, 0);

		}
		
//		for(int ti = 0; ti < typeCount.length; ti++) {
//            answer *= typeCount[ti] + 1;
//        }
//        
//        answer--;
		
		
		return answer;
	}

	public static void doCombination(int[] source, int n, int r, int[] selectedIndices, int selectedIndexCount,
			int targetIndex) {

		if (r == 0) {
			int numCases = 1;
			for (int si = 0; si < selectedIndexCount; si++) {
				// System.out.println("index : " + selectedIndices[si]);
				// System.out.println("source : " +
				// source[selectedIndices[si]]);
				numCases *= source[selectedIndices[si]];
			}
			answer += numCases;
			// System.out.println("----------");

		} else if (targetIndex == n)
			return;
		else {

			selectedIndices[selectedIndexCount] = targetIndex;

			doCombination(source, n, r - 1, selectedIndices, selectedIndexCount + 1, targetIndex + 1);

			doCombination(source, n, r, selectedIndices, selectedIndexCount, targetIndex + 1);

		}

	}

}
