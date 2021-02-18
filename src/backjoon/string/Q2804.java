package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2804 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();

		byte[] duplicationCheck = new byte[26];

		for (int bi = 0; bi < b.length(); bi++) {
			duplicationCheck[(int) b.charAt(bi) - 65] = 1;
		}

		int aIndex = -1;
		int bIndex = -1;
		for (int ai = 0; ai < a.length(); ai++) {
			if (duplicationCheck[(int) a.charAt(ai) - 65] == 1) {
				bIndex = ai;
				break;
			}
		}

		aIndex = b.indexOf(Character.toString(a.charAt(bIndex)));

		char[][] crossWord = new char[b.length()][a.length()];

		for (int ci = 0; ci < crossWord.length; ci++) {
			for (int cj = 0; cj < crossWord[0].length; cj++) {
				if (ci == aIndex)
					crossWord[ci][cj] = a.charAt(cj);
				else if (cj == bIndex)
					crossWord[ci][cj] = b.charAt(ci);
				else
					crossWord[ci][cj] = '.';
			}
		}
		for (int ci = 0; ci < crossWord.length; ci++) {
			for (int cj = 0; cj < crossWord[0].length; cj++) {
				System.out.print(crossWord[ci][cj]);
			}
			System.out.println();
		}
	}

}
