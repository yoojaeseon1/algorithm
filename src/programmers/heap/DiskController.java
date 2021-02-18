package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {

	public static void main(String[] args) {

		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

		Integer[][] jobsCopied = new Integer[jobs.length][jobs[0].length];

		System.out.println(solution(jobs));

	}

	public static int solution(int[][] jobs) {


		Arrays.sort(jobs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				else
					return Integer.compare(o1[0], o2[0]);

			}
		});

		int jobsI = 0;
		int computedTime = 0;

		int startTime = jobs[jobsI][0];
		int endTime = jobs[jobsI][0];

		Queue<int[]> jobsQueue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[1], o2[1]);
			}

		});

		while (jobsI < jobs.length && jobs[jobsI][0] == startTime) {
			jobsQueue.add(jobs[jobsI++]);
		}

		while (!jobsQueue.isEmpty()) {

			while (!jobsQueue.isEmpty()) {
				int[] currentJob = jobsQueue.poll();
				startTime = endTime;
				endTime = startTime + currentJob[1];
				computedTime += endTime - currentJob[0];
				while (jobsI < jobs.length && jobs[jobsI][0] > startTime
						&& jobs[jobsI][0] <= endTime) {
					jobsQueue.add(jobs[jobsI++]);
				}
			}

			if (jobsI < jobs.length){
				startTime = jobs[jobsI][0];
				endTime = jobs[jobsI][0];
			}

			while (jobsI < jobs.length && jobs[jobsI][0] == startTime) {
				jobsQueue.add(jobs[jobsI++]);
			}

		}

		return computedTime / jobs.length;
	}

}
