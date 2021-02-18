package backjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1057 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int rountNum = Integer.parseInt(st.nextToken());
		
		int kimNum = Integer.parseInt(st.nextToken());
		int limNum = Integer.parseInt(st.nextToken());
		
		kimNum = (int) Math.ceil(kimNum / 2.0);
		limNum = (int) Math.ceil(limNum / 2.0);
		int roundCount = 1;
		
		while(kimNum != limNum) {
			kimNum = (int) Math.ceil(kimNum / 2.0);
			limNum = (int) Math.ceil(limNum / 2.0);
			roundCount++;
		}
		
		System.out.println(roundCount);
	}
}
