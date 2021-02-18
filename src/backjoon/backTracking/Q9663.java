package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663{
	
	static int n;
	static int answer;
	static int[] col;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		answer = 0;
		for(int i = 1; i <= n; i++) {
			
			col = new int[15];
			
			col[1] = i;
			
			dfs(1);
			
		}
		
		System.out.println(answer);
		
	}
	
	public static void dfs(int row) {

		if(row == n) {
			answer++;
		} else {
			for(int i = 1; i <= n; i++) {
				col[row + 1] = i;
				
				if(isPosible(row + 1)) {
					dfs(row + 1);
				} else {
					col[row + 1] = 0;
				}
			}
		}
		col[row] = 0;
	}
	
	public static boolean isPosible(int c) {
		
		for(int i = 1; i < c; i++) {
			
			if(col[i] == col[c]) {
				return false;
			}
			
			if(Math.abs(col[i] - col[c]) == Math.abs(i - c)) {
				return false;
			}
		}
		return true;
	}
}
