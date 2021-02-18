package backjoon.bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1004 {
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int minPassedPlanet = 0;
		
		for(int testcase = 1 ; testcase <= T; testcase++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			
			for(int circle = 1; circle <= n; circle++) {
				
				st = new StringTokenizer(br.readLine());
				
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				int numPassedPlanet = 0;
				
				if((x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy) < r * r)
					numPassedPlanet++;
				
				if((x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy) < r * r)
					numPassedPlanet++;
				
				System.out.println("numPassedPlanet : " + numPassedPlanet);
				if(numPassedPlanet == 1)
					minPassedPlanet++;
				
			}
			
			System.out.println(minPassedPlanet);
			minPassedPlanet = 0;
		}
		
	}

}
