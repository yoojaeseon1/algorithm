package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1931 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int startTime, endTime;
		StringTokenizer st;

		int[][] schedule = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
			// scheduleMap.put(endTime, startTime);
		}

		Arrays.sort(schedule, new Comparator<int[]>() {

			@Override
			public int compare(int[] arr1, int[] arr2) {

				if (arr1[1] == arr2[1])
					return Integer.compare(arr1[0], arr2[0]);
				else
					return Integer.compare(arr1[1], arr2[1]);
			}
		});
		
		for(int si = 0; si < schedule.length; si++) {
			
			System.out.println(schedule[si][0] + ", " + schedule[si][1]);
		}
		
		int earlistStartTime = 0;
		int selectedCount = 0;
		for(int i = 0; i < schedule.length; i++) {
			startTime = schedule[i][0];
			endTime = schedule[i][1];
			if(earlistStartTime <= startTime) {
				earlistStartTime = endTime;
				selectedCount++;
			}
		}
		System.out.println(selectedCount);
	}

}
