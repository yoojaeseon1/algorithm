package backjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q1159 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Map<Character, Integer> nameMap = new HashMap<>();
		String tempString;
		for (int i = 0; i < n; i++) {
			tempString = br.readLine();
			if (nameMap.containsKey(tempString.charAt(0))) {
				nameMap.put(tempString.charAt(0), nameMap.get(tempString.charAt(0)) + 1);
			} else {
				nameMap.put(tempString.charAt(0), 1);
			}
		}

		Set<Character> keySet = nameMap.keySet();

		Iterator keyIter = keySet.iterator();
		List<Character> entryList = new ArrayList<>();

		while (keyIter.hasNext()) {
			char key = (char) keyIter.next();
			if (nameMap.get(key) >= 5) {
				entryList.add(key);
			}
		}

		if (entryList.size() >= 1) {
			Collections.sort(entryList);

			for (int i = 0; i < entryList.size(); i++) {
				System.out.print(entryList.get(i));
			}
		} else {
			System.out.println("PREDAJA");
		}
	}
}
