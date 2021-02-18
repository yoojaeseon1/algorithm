package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q1062 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char tempChar;
		String studiedChar = "antic";
		String[] words = new String[n];
		Map<Character, Integer> charMap = new HashMap<>();
		ValueComparator vc = new ValueComparator(charMap);
		Map<Character, Integer> sortedMap = new TreeMap<>(vc);
		
		
		StringBuilder containedChar = new StringBuilder();
		

		if (k > 5) {

			for (int i = 0; i < n; i++) {
				words[i] = br.readLine();
			}

			for (int i = 0; i < n; i++) {

				for (int j = 4; j < words[i].length() - 4; j++) {
					tempChar = words[i].charAt(j);
					if (studiedChar.indexOf(tempChar) == -1 && (containedChar.indexOf(Character.toString(tempChar)) == -1)) {
						if (!charMap.containsKey(words[i].charAt(j))) {
							charMap.put(tempChar, 1);
							containedChar.append(tempChar);
						} else {
							charMap.put(tempChar, charMap.get(tempChar) + 1);
							containedChar.append(tempChar);
						}
					}
				}
				containedChar.setLength(0);
			}
			sortedMap.putAll(charMap);
		}
		System.out.println(sortedMap);
		
		ArrayList<Character> keys = new ArrayList<>(sortedMap.keySet());
		ArrayList<Integer> values = new ArrayList<>(sortedMap.values());
	}

}


class ValueComparator implements Comparator<Character> {

	Map<Character, Integer> map;

	public ValueComparator(Map<Character, Integer> map) {

		this.map = map;

	}

	@Override
	public int compare(Character o1, Character o2) {

		if (map.get(o1) >= map.get(o2)) {
			return 1;
		} else {
			return -1;
		}
		
//		return map.get(o2) - map.get(o1); // 이러면 안됨 왜지??
	}

}