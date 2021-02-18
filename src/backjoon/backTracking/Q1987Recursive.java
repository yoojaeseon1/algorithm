package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 그냥 DFS랑 Backtracking이랑 어떻게 다른지 비교하자

// 재귀 실행 0할 때 count랑 DFS일 때 pop하는 count랑 비교해보자(똑같은데 비재귀에서 System.arraycopy()메소드가 많이 실행되서 오래 걸리는 것 같다.)

public class Q1987Recursive {
	
	static int maxCount = 0;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static char[][] board;
	static int r;
	static int c;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];
		String tempInput;
		for (int i = 0; i < r; i++) {
			tempInput = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = tempInput.charAt(j);
			}
		}

		boolean[] visited = new boolean[26];

		visited[board[0][0] - 'A'] = true;
		
		dfs(0,0,1,visited);
		
		System.out.println(maxCount);
		
	}
	
	public static void dfs(int x, int y, int count, boolean[] visited) {
		
		maxCount = Math.max(maxCount, count);
		
		for(int i = 0; i < 4; i++) {
			
			if(x+dx[i] >= 0 && x+dx[i] < c && y+dy[i] >= 0 && y+dy[i] < r) {
				if(!visited[board[y+dy[i]][x+dx[i]] - 'A']) {
					visited[board[y+dy[i]][x+dx[i]] - 'A'] = true;
					dfs(x+dx[i],y+dy[i], count+1,visited);
					visited[board[y+dy[i]][x+dx[i]] - 'A'] = false;
				}
			}
		}
	}

}
