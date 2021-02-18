package backjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//예외처리
//
//8
//6
//1 4
//1 5
//2 4
//4 6
//4 8
//5 7
//
//>>> 6(2,4,5,6,7,8)

public class Q5567 {

	public static void main(String[] args) throws Exception {
		
		// answer 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int friendsCnt = 0;
		boolean[][] friends = new boolean[n + 1][n + 1];
		boolean[] visited = new boolean[n + 1];

		int temp1, temp2;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			friends[temp1][temp2] = true;
			friends[temp2][temp1] = true;
			if (temp1 == 1) {
				list.add(temp2);
				visited[temp2] = true;
				friendsCnt++;
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 2; j < friends[0].length; j++) {
				if(friends[list.get(i)][j] && !visited[j]) {
					visited[j] = true;
					friendsCnt++;
				}
			}
		}
		
		System.out.println(friendsCnt);
		
		
		
		
		// answer 2
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		int n = Integer.parseInt(br.readLine());
//		int m = Integer.parseInt(br.readLine());
//		int friendsCnt = 0;
//
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		int temp1, temp2;
//		List<Integer> list;
//		for (int i = 0; i < m; i++) {
//			st = new StringTokenizer(br.readLine());
//			temp1 = Integer.parseInt(st.nextToken());
//			temp2 = Integer.parseInt(st.nextToken());
//			if (!map.containsKey(temp1)) {
//				list = new ArrayList<>();
//				list.add(temp2);
//				map.put(temp1, list);
//			} else {
//				map.get(temp1).add(temp2);
//			}
//			if (!map.containsKey(temp2)) {
//				list = new ArrayList<>();
//				list.add(temp1);
//				map.put(temp2, list);
//			} else {
//				map.get(temp2).add(temp1);
//			}
//			
//		}
//
//		boolean[] friends = new boolean[n + 1];
//		boolean[] friends2 = new boolean[n + 1];
//
//		if (map.containsKey(1)) {
//			for (int i = 0; i < map.get(1).size(); i++) {
//				friends[map.get(1).get(i)] = true;
//			}
//			for (int i = 2; i < friends.length; i++) {
//				if (friends[i] && map.containsKey(i)) {
//					for (int j = 0; j < map.get(i).size(); j++) {
//						friends2[map.get(i).get(j)] = true;
//						
//					}
//				}
//			}
//		}
//
//
//		for (int i = 2; i < friends.length; i++) {
//			if (friends[i] || friends2[i]) {
//				friendsCnt++;
//			}
//		}
//
//		System.out.println(friendsCnt);
		
	}
}
