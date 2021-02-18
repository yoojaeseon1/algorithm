package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2490 {
	
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int frontCount = 0;
//		int backCount = 0;
		int currentState;
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				currentState = Integer.parseInt(st.nextToken());
				if(currentState == 0) frontCount++;
//				else backCount++;
			}
			if(frontCount == 1) System.out.println("A");
			else if(frontCount == 2) System.out.println("B");
			else if(frontCount == 3) System.out.println("C");
			else if(frontCount == 4) System.out.println("D");
			else System.out.println("E");
			frontCount = 0;
//			backCount = 0;
		}
	}

}
