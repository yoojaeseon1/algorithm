package backjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1652 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] room = new char[N][N];
		
		StringBuilder line = new StringBuilder();
		for(int roomI = 0; roomI < N; roomI++) {
			line.append(br.readLine());
			for(int roomJ = 0; roomJ < N; roomJ++) {
				room[roomI][roomJ] = line.charAt(roomJ);
			}
			line.setLength(0);
		}
				
		int numLaybleColumn = 0;
		
		for(int roomI = 0; roomI < N - 1; roomI++) {
			for(int roomJ = 0; roomJ < N; roomJ++) {
				
				if(room[roomI][roomJ] == '.' && room[roomI+1][roomJ] == '.' && (roomI+2 == N || room[roomI+2][roomJ] == 'X'))
					numLaybleColumn++;
				
			}
		}
		int numLaybleRow = 0;
		
		for(int roomI = 0; roomI < N ; roomI++) {
			for(int roomJ = 0; roomJ < N - 1; roomJ++) {
				
				if(room[roomI][roomJ] == '.' && room[roomI][roomJ+1] == '.' && (roomJ+2 == N || room[roomI][roomJ+2] == 'X'))
					numLaybleRow++;
				
			}
		}
		
		System.out.println(numLaybleRow + " " +numLaybleColumn);
		
		
	}

}
