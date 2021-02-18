package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1120 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();

		int minDifference = 51;
		int tempDifference = 0;

		for (int bStartIndex = 0; bStartIndex <= B.length() - A.length(); bStartIndex++) {
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) != B.charAt(i + bStartIndex)) {
					tempDifference++;
				}
			}
			minDifference = Math.min(minDifference, tempDifference);
			tempDifference = 0;
		}

		System.out.println(minDifference);

	}

}
