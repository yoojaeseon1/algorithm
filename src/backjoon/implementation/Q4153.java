package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4153 {
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] lines = new int[3];
		
		lines[0] = Integer.parseInt(st.nextToken());
		lines[1] = Integer.parseInt(st.nextToken());
		lines[2] = Integer.parseInt(st.nextToken());
		
		
		
		while(lines[0] > 0 && lines[1] > 0 && lines[2] > 0) {
			
			Arrays.sort(lines);
			
			if(Math.pow(lines[2], 2) == Math.pow(lines[0], 2) + Math.pow(lines[1], 2))
				System.out.println("right");
			else
				System.out.println("wrong");
			
			st = new StringTokenizer(br.readLine());
			
			lines[0] = Integer.parseInt(st.nextToken());
			lines[1] = Integer.parseInt(st.nextToken());
			lines[2] = Integer.parseInt(st.nextToken());
			
		}

	}

}
