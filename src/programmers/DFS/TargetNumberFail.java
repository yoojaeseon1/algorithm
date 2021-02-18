package programmers.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// using BFS(time over)

public class TargetNumberFail {

	public static void main(String[] args) {

		int[] numbers = { 1, 1, 1, 1, 1 };

		System.out.println(solution(numbers, 3));

	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		int sumOfNumbers = 0;
		// boolean[] visited = new boolean[numbers.length];

		for (int ni = 0; ni < numbers.length; ni++) {
			sumOfNumbers += numbers[ni];
		}

		// Map<Integer, boolean[]> visitedMap = new HashMap<>();

		// index 0 : currentValue
		// index 1 ; visitedCount
		Queue<Position> searchQueue = new LinkedList<>();
		boolean[] nextVisited;
		for (int vi = 0; vi < numbers.length; vi++) {
			nextVisited = new boolean[numbers.length];
			nextVisited[vi] = true;
			Position nextPosition = new Position(sumOfNumbers - (numbers[vi] * 2), nextVisited);
			searchQueue.add(nextPosition);
			// boolean[] isVisited = new boolean[numbers.length];
			// isVisited[vi] = true;
			// visitedMap.put(1, isVisited);
		}

		List<boolean[]> visitedCheckList = new ArrayList<>();
		while (!searchQueue.isEmpty()) {
			// System.out.println("enqueue");
			Position currentPosition = searchQueue.poll();
			int currentValue = currentPosition.getCurrentValue();
			boolean[] currentVisited = currentPosition.getVisited();
			if (currentValue == target)

				answer++;
			// System.out.println();

			for (int ni = 0; ni < numbers.length; ni++) {

				if (!currentVisited[ni]) {

					currentVisited[ni] = true;
					boolean isVisited = false;
					for (int ci = 0; ci < visitedCheckList.size(); ci++) {
						if (checkIsEqualArray(currentVisited, visitedCheckList.get(ci))) {
							isVisited = true;
							break;
						}
					}
					if (!isVisited) {
						nextVisited = new boolean[numbers.length];
						System.arraycopy(currentVisited, 0, nextVisited, 0, currentVisited.length);
						visitedCheckList.add(nextVisited);
						Position nextPosition = new Position(currentValue - (numbers[ni] * 2), nextVisited);
						searchQueue.add(nextPosition);
					}
					currentVisited[ni] = false;
				}

			}

		}

		return answer;
	}

	public static boolean checkIsEqualArray(boolean[] arr1, boolean[] arr2) {

		for (int ai = 0; ai < arr1.length; ai++) {

			if (arr1[ai] != arr2[ai])
				return false;
		}
		return true;
	}
}

class Position {

	private int currentValue;
	private boolean[] visited;

	public Position() {
		// TODO Auto-generated constructor stub
	}

	public Position(int currentValue, boolean[] visited) {
		this.currentValue = currentValue;
		this.visited = new boolean[visited.length];
		System.arraycopy(visited, 0, this.visited, 0, visited.length);
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}

}
