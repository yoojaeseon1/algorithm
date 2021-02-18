package backjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9506 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			int n = Integer.parseInt(br.readLine());
			if (n == -1)
				break;
			int divisorSum = 0;
			StringBuilder currentAnswer = new StringBuilder();
			
			currentAnswer.append(1);
			divisorSum++;
			for(int ni = 2; ni <= n/2; ni++) {
				if(n % ni == 0){
					currentAnswer.append(" + ");
					currentAnswer.append(ni);
					divisorSum += ni;
				}
				
			}
			if(n == divisorSum) System.out.println(n + " = "+ currentAnswer);
			else System.out.println(n + " is NOT perfect.");
		}
	}

}
