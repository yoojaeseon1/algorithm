package backjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1026 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int s = 0;
//		int[] a = new int[n];
//		int[] b = new int[n];
		
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[n];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(a);
//		Arrays.sort(b);
//		Arrays.sort(b, Collections.reverseOrder());
//		Arrays.sort(b, new Descending());
		Arrays.sort(b, new Comparator<Integer> () {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) {
					return -1;
				} else if(o1 == o2) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		
		for(int i = 0; i < a.length; i++) {
			s += a[i] * b[i];
		}
		
//		for(int i = 0; i < n; i++) {
//			s += a[i] * b[n-i-1];
//		}
		
		
//		List<Integer> a = new ArrayList<>();
//		List<Integer> b = new ArrayList<>();
//		List<Integer> tempList;
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < n; i++) {
//			a.add(Integer.parseInt(st.nextToken()));
//		}
		
		
//		st = new StringTokenizer(br.readLine());
		
		
//		for(int i = 0; i < n; i++) {
//			b.add(Integer.parseInt(st.nextToken()));
//		}
		
//		Collections.sort(a, (o1,o2)->(o2-o1));
//		Collections.sort(b);
		
		
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		
//		for(int i = 0; i < n; i++) {
//			if(!map.containsKey(a.get(i))) {
//				tempList = new ArrayList<>();
//				tempList.add(b.get(i));
//				map.put(a.get(i), tempList);
//			} else {
//				map.get(a.get(i)).add(b.get(i));
//			}
//		}
//		
//		tempList = new ArrayList<>(map.keySet());
//		int tempKey;
//		for(int i = 0; i < tempList.size(); i++) {
//			tempKey = tempList.get(i);
//			for(int j = 0; j < map.get(tempKey).size(); j++) {
//				s += tempKey * map.get(tempKey).get(j);
//			}
//		}
		
		System.out.println(s);
		
	}
}

class Descending implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		
		if(o1 > o2) {
			return -1;
		} else if(o1 == o2) {
			return 0;
		} else {
			return 1;
		}
	}
}
