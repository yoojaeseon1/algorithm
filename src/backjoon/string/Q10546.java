package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q10546 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		String tempInput;

		for (int i = 0; i < n; i++) {
			tempInput = br.readLine();
			if (!map.containsKey(tempInput)) {
				map.put(tempInput, 1);
			} else {
				map.put(tempInput, map.get(tempInput) + 1);
			}
		}

		for (int i = 0; i < n - 1; i++) {
			tempInput = br.readLine();
			if (map.get(tempInput) > 1) {
				map.put(tempInput, map.get(tempInput) - 1);
			} else {
				map.remove(tempInput);
			}
		}

		List<String> failList = new ArrayList<>(map.keySet());

		System.out.println(failList.get(0));
		
		// list 사용하면 시간초과

		//
		// int entry = Integer.parseInt(br.readLine());
		//
		// List<String> entryList = new ArrayList<>();
		//
		// for(int i = 0; i < entry; i++) {
		// entryList.add(br.readLine());
		// }
		// for(int i = 0; i < entry-1; i++) {
		// entryList.remove(br.readLine());
		// }
		//
		// System.out.println(entryList.get(0));
	}
}
