package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2875 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int answer = 0;

		while (k > 0) {
			if (m > n / 2) {
				m--;
				k--;
			} else {
				n -= 2;
				k -= 2;
			}
		}
		// if(n > m*2) System.out.println(m);
		// else System.out.println(n/2);
		answer = n > m * 2 ? m : n / 2;

		System.out.println(answer);
	}

}
