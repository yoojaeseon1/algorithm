package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14501{

	static List<List<Integer>> combinations;

	public static void main(String[] args) throws IOException {

		combinations = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N];
		int[] P = new int[N];

		StringTokenizer st;

		for (int TI = 0; TI < N; TI++) {
			st = new StringTokenizer(br.readLine());

			T[TI] = Integer.parseInt(st.nextToken());
			P[TI] = Integer.parseInt(st.nextToken());

		}

		int[] selectedIndices = new int[N];

		for (int r = 1; r <= N; r++) {

			computeCombination(T, N, r, selectedIndices, 0, 0);

		}

		int maxProfit = 0;

		for (int combinationsI = 0; combinationsI < combinations.size(); combinationsI++) {

			for (int combinationsJ = 0; combinationsJ < combinations.get(combinationsI).size(); combinationsJ++) {
				maxProfit = Math.max(maxProfit, computeProfit(T, P, combinations.get(combinationsI)));

			}
		}

		System.out.println(maxProfit);

	}

	public static int computeProfit(int[] T, int[] P, List<Integer> schedule) {

		int profit = 0;
		for (int scheduleIndex = 0; scheduleIndex < schedule.size(); scheduleIndex++) {

			int currentTime = schedule.get(scheduleIndex);
			int usingTime = T[currentTime];

			for (int counselTime = currentTime + 1; counselTime < currentTime + usingTime; counselTime++) {
				if (schedule.contains(counselTime) || counselTime >= T.length)
					return 0;
			}

			profit += P[currentTime];

		}

		return profit;
	}

	public static void computeCombination(int[] source, int n, int r, int[] selectedIndices, int selectedIndex,
			int targetIndex) {

		if (r == 0) {

			List<Integer> combiList = new ArrayList<>();

			for (int si = 0; si < selectedIndex; si++) {
				combiList.add(selectedIndices[si]);
			}

			combinations.add(combiList);

		} else if (targetIndex == n)
			return;
		else {

			selectedIndices[selectedIndex] = targetIndex;

			computeCombination(source, n, r - 1, selectedIndices, selectedIndex + 1, targetIndex + 1);

			computeCombination(source, n, r, selectedIndices, selectedIndex, targetIndex + 1);

		}

	}

}
