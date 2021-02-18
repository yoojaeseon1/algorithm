package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


// map 대신 char배열을 사용하는 것도 좋다.(알파벳, 숫자(0~9)는 아스키코드 값으로 인덱스에 접근 가능하니까)

public class Q1969 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());

		String[] DNAs = new String[N]; // 자체가 약어일 때 변수명 짓는 방법 알아보자

		for (int di = 0; di < N; di++) {
			DNAs[di] = br.readLine();
		}

		int hamDistanceSum = 0;
		StringBuilder resultDNA = new StringBuilder();

		for (int charI = 0; charI < M; charI++) {
			Map<Character, Integer> DNAMap = new HashMap<>();
			for (int DNAsI = 0; DNAsI < N; DNAsI++) {
				char currentChar = DNAs[DNAsI].charAt(charI);
				if (DNAMap.containsKey(currentChar))
					DNAMap.put(currentChar, DNAMap.get(currentChar) + 1);
				else
					DNAMap.put(currentChar, 1);
			}
			List<Integer> hammingList = new ArrayList<>(DNAMap.values());
			int maxHammingValue = 0;
			for (int hi = 0; hi < hammingList.size(); hi++) {
				maxHammingValue = Math.max(maxHammingValue, hammingList.get(hi));
			}
			List<Character> maxDNAList = new ArrayList<>();

			Iterator DNAIter = DNAMap.keySet().iterator();

			while (DNAIter.hasNext()) {
				char currentDNA = (char) DNAIter.next();
				if (DNAMap.get(currentDNA) == maxHammingValue)
					maxDNAList.add(currentDNA);
			}
			Collections.sort(maxDNAList);

			resultDNA.append(maxDNAList.get(0));
			hamDistanceSum += (N - DNAMap.get(maxDNAList.get(0)));
		}
		System.out.println(resultDNA);
		System.out.println(hamDistanceSum);

	}

}
