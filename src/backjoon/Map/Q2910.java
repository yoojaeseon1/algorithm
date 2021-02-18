package backjoon.Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Q2910 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		LinkedHashMap<Integer, Integer> numMap = new LinkedHashMap<>();

		List<int[]> numList = new ArrayList<>();

		while (st.hasMoreTokens()) {

			int currentNum = Integer.parseInt(st.nextToken());

			if (numMap.containsKey(currentNum)) {
				numMap.put(currentNum, numMap.get(currentNum) + 1);
			} else {
				numMap.put(currentNum, 1);
			}

		}

		Iterator<Integer> numIter = numMap.keySet().iterator();

		while (numIter.hasNext()) {
			int currentNum = numIter.next();

			int[] currentArray = { currentNum, numMap.get(currentNum) };

			numList.add(currentArray);
		}

		Collections.sort(numList, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o2[1] > o1[1])
					return 1;
				else if (o2[1] == o1[1])
					return 0;
				else
					return -1;
			}
		});

		for (int ni = 0; ni < numList.size(); ni++) {
			
			int currentNum = numList.get(ni)[0];
			int frequency = numList.get(ni)[1];
			
			for (int numCount = 1; numCount <= frequency; numCount++) {
				System.out.print(currentNum + " ");
			}
		}

	}

}
