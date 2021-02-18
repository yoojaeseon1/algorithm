package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11656 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		String[] tales = new String[input.length()];
		// List<String> talesList = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			tales[i] = input.substring(i);
			// talesList.add(input.substring(i));
		}

		Arrays.sort(tales);
		// Collections.sort(talesList);

		for (int i = 0; i < tales.length; i++) {
			System.out.println(tales[i]);
		}

		// for(int i = 0; i < talesList.size(); i++) {
		// System.out.println(talesList.get(i));
		// }

	}
}
