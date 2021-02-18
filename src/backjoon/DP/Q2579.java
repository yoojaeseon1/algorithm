package backjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int totalSteps = Integer.parseInt(br.readLine());
		
		int[] oneStep = new int[totalSteps+1];
		int[] twoStep = new int[totalSteps+1];
		
		oneStep[1] = Integer.parseInt(br.readLine());
		
		int secondStep = Integer.parseInt(br.readLine());
		
		oneStep[2] = oneStep[1] + secondStep;
		twoStep[2] = secondStep;
		
		int currentStep;
		
		for(int i = 3; i <= totalSteps; i++) {
			
			currentStep = Integer.parseInt(br.readLine());
			
			oneStep[i] = twoStep[i-1] + currentStep;
			twoStep[i] = Math.max(oneStep[i-2], twoStep[i-2]) + currentStep;
			
		}
		
		System.out.println(Math.max(oneStep[totalSteps], twoStep[totalSteps]));
		
	}

}
