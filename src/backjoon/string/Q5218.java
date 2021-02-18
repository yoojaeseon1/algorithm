package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5218 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int caseCount = Integer.parseInt(br.readLine());

		StringTokenizer st;

		StringBuilder x = new StringBuilder();
		StringBuilder y = new StringBuilder();

		for (int i = 0; i < caseCount; i++) {

			st = new StringTokenizer(br.readLine());
			x.setLength(0);
			y.setLength(0);
			x.append(st.nextToken());
			y.append(st.nextToken());
			System.out.print("Distances:");
			for (int j = 0; j < x.length(); j++) {
				if ((int) x.charAt(j) > (int) y.charAt(j)) {
					System.out.print(" " + ((int) y.charAt(j) + 26 - (int) x.charAt(j)));
				} else {
					System.out.print(" " + ((int) y.charAt(j) - (int) x.charAt(j)));
				}
			}
			System.out.println();
		}
	}

}
