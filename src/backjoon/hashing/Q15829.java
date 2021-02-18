package backjoon.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q15829 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		
		String word = br.readLine();
		
		long hashValue = 0;
		int m = 1234567891;
		long multipliedValue = 1;
		for(int wordI = 0; wordI < word.length(); wordI++) {
			
			long currentCalcValue = (word.charAt(wordI) - 96) * multipliedValue;
			
			currentCalcValue %= m;
			
			hashValue += currentCalcValue;
			
			hashValue %= m;
			
			multipliedValue *= 31;
			multipliedValue %= m;
			
		}
		
		System.out.println(hashValue % m);
		
		
	}

}
