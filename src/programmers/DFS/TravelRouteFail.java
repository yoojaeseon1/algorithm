package programmers.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TravelRouteFail {
	
	// time over
	
	public static void main(String[] args) {
		
		// String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK",
		// "HND"}};
		// String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO","ATL"},
		// {"ATL", "ICN"}, {"ATL","SFO"}};
		// String[][] tickets = {{"ICN","JFK"},{"ICN", "SFO"}, {"ICN", "ATL"},
		// {"SFO","ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		// String[][] tickets = { { "ICN", "COO" }, { "COO", "ICN" },{ "COO",
		// "ICN" } };
		String[][] tickets = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" }, { "DOO", "BOO" },
				{ "BOO", "ICN" }, { "COO", "BOO" } };

		
		String[] answer = solution(tickets);

		for (int ai = 0; ai < answer.length; ai++) {
			System.out.println(answer[ai]);
		}
		
	}
	
	public static String[] solution(String[][] tickets) {

		String[] answer = new String[tickets.length + 1];
		int answerIndex = 0;

		List<String[]> sameStartList = new ArrayList<>();

		String start = "ICN";
		answer[answerIndex++] = start;

		for (int ti = 0; ti < tickets.length; ti++) {
			if (start.equals(tickets[ti][0])) {
				// System.out.println("arrived : " + tickets[ti][1]);
				String[] enqueuedArray = { tickets[ti][1], Integer.toString(ti) };
				sameStartList.add(enqueuedArray);
			}
		}

		Queue<String> searchQueue = new LinkedList<>();

		if (sameStartList.size() == 1) {
			searchQueue.add(sameStartList.get(0)[0]);
			tickets[Integer.parseInt(sameStartList.get(0)[1])][0] = "";
		} else if (sameStartList.size() > 1) {
			Collections.sort(sameStartList, new ListSorting());
			searchQueue.add(sameStartList.get(0)[0]);
			tickets[Integer.parseInt(sameStartList.get(0)[1])][0] = "";
		}

		while (!searchQueue.isEmpty()) {

			sameStartList.clear();
			start = searchQueue.poll();
			// System.out.println("start : " + start);
			answer[answerIndex++] = start;

			for (int ti = 0; ti < tickets.length; ti++) {
				if (start.equals(tickets[ti][0])) {
					String[] enqueuedArray = { tickets[ti][1], Integer.toString(ti) };
					sameStartList.add(enqueuedArray);
				}
			}

			if (sameStartList.size() == 1) {
				searchQueue.add(sameStartList.get(0)[0]);
				tickets[Integer.parseInt(sameStartList.get(0)[1])][0] = "";
			} else if (sameStartList.size() > 1) {
				Collections.sort(sameStartList, new ListSorting());
				searchQueue.add(sameStartList.get(0)[0]);
				tickets[Integer.parseInt(sameStartList.get(0)[1])][0] = "";
			}
		}

//		int nullIndex = -1;
		
//		for(int ai = 0; ai < answer.length; ai++) {
//			if(answer[ai] == null) {
//				nullIndex = ai;
//				break;
//			}
//		}
		
		if(answerIndex == answer.length) {
			return answer;
		} else {
			
			String[] exceptNullAnswer = new String[answerIndex];
			
			System.arraycopy(answer, 0, exceptNullAnswer, 0, answerIndex);
			
			return exceptNullAnswer;
		}
	}
}

class ListSorting implements Comparator<String[]> {

	@Override
	public int compare(String[] o1, String[] o2) {

		return o1[0].compareTo(o2[0]);
	}
}

