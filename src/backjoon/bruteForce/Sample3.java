package backjoon.bruteForce;

import java.io.*;
import java.util.*;

public class Sample3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Integer N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean chkZero = false;
		boolean[] brk = new boolean[10];
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int chk = Integer.parseInt(st.nextToken());
				if (chk == 0)
					chkZero = true;
				brk[chk] = true;
			}
		}
		
		
		int ans = Math.abs(N - 100);
		
		for (int i = 0; i <= 1000000; i++) {
			int channel = i, chTemp = i;
			int length = 0;
			if (i == 0) {
				if (chkZero)
					length = 0;
				else
					length = 1;
			}
			while (chTemp > 0) {
				if (brk[chTemp % 10]) {
					length = 0;
					break;
				}
				length++;
				chTemp = chTemp / 10;
			}
			if (length > 0) {
				ans = Math.min(ans, length + Math.abs(channel - N));
			}
		}
		
		
		bw.write(ans + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
